package com.example.kotlinknowledge.data.remote.api

import com.example.kotlinknowledge.data.remote.requests.LoginRequest
import com.example.kotlinknowledge.data.remote.responses.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationServices {
    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): LoginResponse
}