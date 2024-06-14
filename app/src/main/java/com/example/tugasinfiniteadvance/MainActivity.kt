package com.example.tugasinfiniteadvance

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
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

        createNotificationChannel()

        setContent {
            TugasInfiniteAdvanceTheme {
                MainScreen()
            }
        }
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Prayer Time Notifications"
            val descriptionText = "Notifikasi untuk waktu sholat"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("prayer_channel_id", name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}