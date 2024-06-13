package com.example.tugasinfiniteadvance.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tugasinfiniteadvance.ui.viewmodel.SholatNowViewModel

@Suppress("UNCHECKED_CAST")
class PrayerTimesViewModelFactory(private val kota: String, private val tanggal: String) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SholatNowViewModel::class.java)){
            return SholatNowViewModel(kota, tanggal) as T
        }
        throw IllegalArgumentException("")
    }
}