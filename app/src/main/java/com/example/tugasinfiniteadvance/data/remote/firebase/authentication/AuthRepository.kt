package com.example.tugasinfiniteadvance.data.remote.firebase.authentication

import com.example.tugasinfiniteadvance.util.Resource
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun loginUser(email: String, password: String) : Flow<Resource<AuthResult>>
    fun registerUser(username: String, email: String, password: String) : Flow<Resource<AuthResult>>

    fun googleSignIn(credential: AuthCredential) : Flow<Resource<AuthResult>>
}