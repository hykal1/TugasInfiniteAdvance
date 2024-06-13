package com.example.tugasinfiniteadvance.data.repository

import com.example.tugasinfiniteadvance.data.remote.model.PrayerTimeResponse
import com.example.tugasinfiniteadvance.data.remote.retrofit.ApiConfig
import com.example.tugasinfiniteadvance.data.remote.retrofit.ApiService

class PrayerTimesRepository {
    private val prayerTimeService = ApiConfig.getApiService()

    suspend fun getPrayerTimesBySingleLocation(kota: String, tanggal: String): PrayerTimeResponse{
        return prayerTimeService.getPrayerTimesBySingleLocation(kota, tanggal)
    }
}