package com.example.tugasinfiniteadvance.data.remote.retrofit

import com.example.tugasinfiniteadvance.data.remote.model.PrayerTimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("sholat/jadwal/{kota}/{tanggal}")
    suspend fun getPrayerTimesBySingleLocation(
        @Path("kota")
        kota: String,
        @Path("tanggal")
        tanggal: String,
    ): PrayerTimeResponse
}