package com.example.kotlinknowledge.data.repositories

import com.example.kotlinknowledge.data.remote.api.AuthenticationServices
import com.example.kotlinknowledge.data.remote.mapper.RemoteErrorMapper
import com.example.kotlinknowledge.data.remote.mapper.catchingApiException
import com.example.kotlinknowledge.data.remote.requests.LoginRequest
import com.example.kotlinknowledge.data.remote.responses.LoginResponse
import com.example.kotlinknowledge.domain.model.AppError
import com.example.kotlinknowledge.domain.repositories.AuthenticationRepository
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.coroutines.runSuspendCatching
import com.github.michaelbull.result.mapError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class AuthenticationRepositoryImpl @Inject constructor(
    private val services: AuthenticationServices,
    private val remoteErrorMapper: RemoteErrorMapper
) : AuthenticationRepository {
    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse, AppError> = withContext(Dispatchers.IO){
        catchingApiException(remoteErrorMapper){
            services.login(loginRequest)
        }
    }
}