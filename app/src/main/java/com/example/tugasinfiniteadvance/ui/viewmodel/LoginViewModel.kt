package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val emailState = mutableStateOf("")
    val passwordState = mutableStateOf("")

    fun onEmailChanged(email: String) {
        emailState.value = email
    }

    fun onPasswordChanged(password: String) {
        passwordState.value = password
    }

    fun onLoginClicked() {
        val email = emailState.value
        val password = passwordState.value

        // Lakukan validasi email dan password di sini
        // Panggil repository untuk melakukan proses login
    }
}