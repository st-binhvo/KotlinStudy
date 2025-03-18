package com.example.kotlinknowledge.domain.repositories

import com.example.kotlinknowledge.data.remote.requests.LoginRequest
import com.example.kotlinknowledge.data.remote.responses.LoginResponse
import com.example.kotlinknowledge.domain.model.AppError
import com.github.michaelbull.result.Result

interface AuthenticationRepository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse, AppError>
}