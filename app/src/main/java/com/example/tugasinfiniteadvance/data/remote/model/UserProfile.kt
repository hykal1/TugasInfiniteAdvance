package com.example.tugasinfiniteadvance.data.remote.model

data class UserProfile(
    val id: String,
    val username: String,
    val email: String,
    val password: String,
    val country: String,
    val city: String
)