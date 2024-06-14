package com.example.tugasinfiniteadvance.helper

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tugasinfiniteadvance.SettingPreferences
import com.example.tugasinfiniteadvance.ui.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val preferences: SettingPreferences) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(preferences) as T
        }
        throw IllegalArgumentException("")
    }
}