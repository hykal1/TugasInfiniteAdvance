package com.example.tugasinfiniteadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tugasinfiniteadvance.ui.screens.MainScreen
import com.example.tugasinfiniteadvance.ui.theme.TugasInfiniteAdvanceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )
        setContent {
            TugasInfiniteAdvanceTheme {
                MainScreen()
            }
        }
    }
}