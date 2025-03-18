package com.example.kotlinknowledge.presentation.authentication.viewmodel

import androidx.compose.runtime.Immutable
import com.example.kotlinknowledge.data.remote.responses.LoginResponse
import com.example.kotlinknowledge.domain.model.AppError

@Immutable
sealed interface LoginUiState {
    @Immutable
    data object Initial : LoginUiState

    @Immutable
    data object Loading : LoginUiState

    @Immutable
    data class Succeeded(
        val loginSessionData: LoginResponse,
    ) : LoginUiState

    @Immutable
    data class Failure(
        val error: AppError,
    ) : LoginUiState
}