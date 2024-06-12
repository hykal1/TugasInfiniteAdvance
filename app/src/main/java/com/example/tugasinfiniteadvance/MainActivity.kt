package com.example.tugasinfiniteadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tugasinfiniteadvance.ui.screens.MainScreen
import com.example.tugasinfiniteadvance.ui.screens.welcome.WelcomeScreen
import com.example.tugasinfiniteadvance.ui.theme.TugasInfiniteAdvanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TugasInfiniteAdvanceTheme {
                WelcomeScreen()
            }
        }
    }
}