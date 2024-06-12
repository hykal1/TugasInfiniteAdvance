package com.example.tugasinfiniteadvance.data.repository

import kotlinx.coroutines.delay

class SignUpRepository {
    // Simulasi operasi jaringan atau database
    suspend fun registerUser(username: String, email: String, password: String): Result<String> {
        // Simulasikan delay operasi jaringan atau database
        delay(2000)

        return if (username.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
            Result.success("User registered successfully")
        } else {
            Result.failure(Exception("Registration failed: Fields cannot be empty"))
        }
    }
}