package com.example.tugasinfiniteadvance.data.repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class LoginRepository {
    fun login(email: String, password: String): MutableState<Boolean> {
        // Implementasi proses login di sini


        // Return state boolean untuk menunjukkan keberhasilan atau kegagalan login


        val isLoggedIn = mutableStateOf(true) // Contoh sederhana, mengembalikan true sebagai indikator berhasil login
        return isLoggedIn
    }
}