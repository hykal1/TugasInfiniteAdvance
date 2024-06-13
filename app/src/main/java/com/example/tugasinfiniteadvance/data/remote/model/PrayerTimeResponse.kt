package com.example.tugasinfiniteadvance.data.remote.model

data class PrayerTimeResponse(
	val request: Request,
	val data: Data,
	val status: Boolean
)

data class Data(
	val jadwal: Jadwal,
	val lokasi: String,
	val daerah: String,
	val id: Int
)

data class Jadwal(
	val date: String,
	val imsak: String,
	val isya: String,
	val dzuhur: String,
	val subuh: String,
	val dhuha: String,
	val terbit: String,
	val tanggal: String,
	val ashar: String,
	val maghrib: String
)

data class Request(
	val path: String
)

