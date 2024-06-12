package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

enum class Screen {
    WELCOME,
    SIGN_IN,
    SIGN_UP
}

class WelcomeViewModel : ViewModel() {
    val currentScreen = mutableStateOf(Screen.WELCOME)

    fun navigateToSignIn() {
        currentScreen.value = Screen.SIGN_IN
    }

    fun navigateToSignUp() {
        currentScreen.value = Screen.SIGN_UP
    }

    fun navigateBack() {
        currentScreen.value = Screen.WELCOME
    }
}