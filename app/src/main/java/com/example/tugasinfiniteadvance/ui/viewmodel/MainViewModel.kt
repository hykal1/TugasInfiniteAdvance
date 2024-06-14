package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.SettingPreferences
import kotlinx.coroutines.launch

class MainViewModel(private val pref: SettingPreferences) : ViewModel() {
    fun getStatusLogin() : LiveData<Boolean> {
        return pref.getStatusLogin().asLiveData()
    }

    fun saveLoginStatus(isLoggedIn: Boolean) {
        viewModelScope.launch {
            pref.saveLoginStatus(isLoggedIn)
        }
    }
}