package com.example.kotlinknowledge.data.remote.requests

data class LoginRequest(
    val username: String,
    val password: String,
    val expiresInMins: Int = 60,
)
