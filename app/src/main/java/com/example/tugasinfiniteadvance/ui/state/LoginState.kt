package com.example.tugasinfiniteadvance.ui.state

data class LoginState(
    val isLoading: Boolean = false,
    val isSucces: String? = "",
    val isError: String? = ""
)