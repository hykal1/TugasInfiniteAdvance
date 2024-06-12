package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {
    val usernameState: MutableState<String> = mutableStateOf("")
    val emailState: MutableState<String> = mutableStateOf("")
    val passwordState: MutableState<String> = mutableStateOf("")
    val confirmPasswordState: MutableState<String> = mutableStateOf("")

    fun onUsernameChanged(newUsername: String) {
        usernameState.value = newUsername
    }

    fun onEmailChanged(newEmail: String) {
        emailState.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        passwordState.value = newPassword
    }

    fun onConfirmPasswordChanged(newConfirmPassword: String) {
        confirmPasswordState.value = newConfirmPassword
    }

    fun onSignUpClicked() {
        // Handle sign-up logic here
    }
}