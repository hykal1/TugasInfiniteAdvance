package com.example.tugasinfiniteadvance.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.tugasinfiniteadvance.R

class PrayerAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "prayer_alarm_channel",
                "Prayer Alarm Channel",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Channel untuk notifikasi alarm sholat"
            }
            notificationManager.createNotificationChannel(channel)
        }

        val currentPrayer = intent.getStringExtra("prayer_name") ?: return
        val previousPrayer = getPreviousPrayer(currentPrayer)

        val notification = NotificationCompat.Builder(context, "prayer_alarm_channel")
            .setContentTitle("Pengingat Sholat")
            .setContentText("Sudah Waktu $previousPrayer, Saatnya Sholat")
            .setSmallIcon(R.drawable.ic_alarm)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        notificationManager.notify(1, notification)
    }

    private fun getPreviousPrayer(prayerName: String): String {
        return when (prayerName) {
            "Subuh" -> "Isya"
            "Dzuhur" -> "Subuh"
            "Ashar" -> "Dzuhur"
            "Maghrib" -> "Ashar"
            "Isya" -> "Maghrib"
            else -> prayerName
        }
    }
}