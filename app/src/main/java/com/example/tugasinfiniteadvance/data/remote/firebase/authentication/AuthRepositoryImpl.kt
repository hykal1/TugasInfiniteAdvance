package com.example.tugasinfiniteadvance.data.remote.firebase.authentication

import com.example.tugasinfiniteadvance.util.Resource
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl : AuthRepository {
    override fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> {
        TODO("Not yet implemented")
    }

    override fun registerUser(
        username: String,
        email: String,
        password: String
    ): Flow<Resource<AuthResult>> {
        TODO("Not yet implemented")
    }
}