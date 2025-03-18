package com.example.kotlinknowledge.data.remote.mapper

import com.example.kotlinknowledge.data.remote.responses.ErrorResponse
import com.example.kotlinknowledge.domain.model.AppError
import com.example.kotlinknowledge.ulti.nonFatalOrThrow
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.coroutines.runSuspendCatching
import com.github.michaelbull.result.mapError
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.JsonEncodingException
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import okhttp3.ResponseBody
import retrofit2.HttpException

interface RemoteErrorMapper : (Throwable) -> AppError.ApiException

@OptIn(ExperimentalContracts::class)
internal suspend inline fun <T> (suspend () -> T).catchingApiException(
  remoteErrorMapper: RemoteErrorMapper,
): Result<T, AppError.ApiException> {
  contract {
    callsInPlace(this@catchingApiException, InvocationKind.AT_MOST_ONCE)
  }
  return runSuspendCatching { this() }.mapError(remoteErrorMapper)
}

@OptIn(ExperimentalContracts::class)
internal inline fun <T> catchingApiException(remoteErrorMapper: RemoteErrorMapper, block: () -> T): Result<T, AppError.ApiException> {
  contract {
    callsInPlace(block, InvocationKind.AT_MOST_ONCE)
  }
  return runSuspendCatching(block).mapError(remoteErrorMapper)
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun <T> Flow<T>.catchingApiException(remoteErrorMapper: RemoteErrorMapper): Flow<Result<T, AppError.ApiException>> =
  map<T, Result<T, AppError.ApiException>> { Ok(it) }.catch { emit(Err(remoteErrorMapper(it))) }

internal class RemoteErrorMapperImpl
@Inject
constructor(
  private val errorResponseJsonAdapter: JsonAdapter<ErrorResponse>,
  private val mapJsonAdapter: JsonAdapter<Map<String, Any?>>,
) : RemoteErrorMapper {
  override fun invoke(t: Throwable) = runCatching {
    when (val throwable = t.nonFatalOrThrow()) {
      is AppError.ApiException -> throwable
      is IOException -> throwable.toApiException()
      is JsonDataException -> AppError.ApiException.InvalidDataException(throwable)
      is HttpException -> throwable.toApiException()
      else -> AppError.ApiException.UnknownException(throwable)
    }
  }.getOrElse { AppError.ApiException.UnknownException(it.nonFatalOrThrow()) }

  /**
   * Convert [HttpException]'s errorBody to [ApiException]
   */
  private fun HttpException.toApiException(): AppError.ApiException {
    val errorBodyString = errorBodyAsString()

    val errorResponse = runCatching { errorResponseJsonAdapter.fromJson(errorBodyString) }.getOrNull()
    val asMap = runCatching { mapJsonAdapter.fromJson(errorBodyString)!! }.getOrDefault(emptyMap())

    val code = errorResponse?.statusCode ?: this.code()
    val errorCode = errorResponse?.errorCode
      ?: runCatching { asMap["error"] as String }
        .getOrNull()

    return AppError.ApiException.ServerException(
      cause = this,
      details = AppError.ApiException.ServerException.ErrorDetails(
        message = errorResponse?.message ?: this.message(),
        statusCode = AppError.ApiException.ServerException.StatusCode
          .entries
          .first { it.code == code },
        errorCode = errorCode,
      ),
    )
  }
}

private fun IOException.toApiException(): AppError.ApiException = when (this) {
  is UnknownHostException, is SocketException -> AppError.ApiException.NetworkException(this)
  is SocketTimeoutException -> AppError.ApiException.TimeoutException(this)
  is JsonEncodingException -> AppError.ApiException.InvalidDataException(this)
  else -> AppError.ApiException.UnknownException(this)
}

@Throws(Exception::class)
private fun HttpException.errorBodyAsString(): String = response()!!
  .takeUnless { it.isSuccessful }!!
  .errorBody()!!
  .use(ResponseBody::string)
