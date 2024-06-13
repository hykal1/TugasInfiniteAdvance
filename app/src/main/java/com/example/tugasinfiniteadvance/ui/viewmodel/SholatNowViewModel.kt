package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.remote.model.PrayerTimeResponse
import com.example.tugasinfiniteadvance.data.repository.PrayerTimesRepository
import kotlinx.coroutines.launch

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
}