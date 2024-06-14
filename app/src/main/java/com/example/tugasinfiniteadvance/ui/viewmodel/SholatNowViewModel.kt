package com.example.tugasinfiniteadvance.ui.viewmodel

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.alarm.PrayerAlarmReceiver
import com.example.tugasinfiniteadvance.data.remote.model.PrayerTimeResponse
import com.example.tugasinfiniteadvance.data.repository.PrayerTimesRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SholatNowViewModel(kota: String, tanggal: String) : ViewModel(){
    private val repository = PrayerTimesRepository()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _prayerTime = MutableLiveData<PrayerTimeResponse>()
    val prayerTime : LiveData<PrayerTimeResponse> = _prayerTime

    init {
        getPrayerTimesBySingleLocation(kota, tanggal)
    }

    private fun getPrayerTimesBySingleLocation(kota: String, tanggal: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val prayerTime = repository.getPrayerTimesBySingleLocation(kota, tanggal)
                _prayerTime.value = prayerTime
                _isLoading.value = false
            } catch ( _: Exception ) {

            }
        }
    }

    fun schedulePrayerAlarm(context: Context, prayerName: String, prayerTime: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, PrayerAlarmReceiver::class.java).apply {
            putExtra("prayer_name", prayerName)
        }
        val pendingIntent = PendingIntent.getBroadcast(context, prayerName.hashCode(), intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val prayerDate = timeFormat.parse(prayerTime)
        val calendar = Calendar.getInstance().apply {
            time = prayerDate
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}