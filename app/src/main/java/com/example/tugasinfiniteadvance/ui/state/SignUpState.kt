package com.example.tugasinfiniteadvance.ui.state

data class SignUpState(
    val isLoading: Boolean = false,
    val isSucces: String? = "",
    val isError: String? = ""
)