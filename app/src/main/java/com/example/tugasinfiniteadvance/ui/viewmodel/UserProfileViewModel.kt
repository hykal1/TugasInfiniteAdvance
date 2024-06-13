package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.remote.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel : ViewModel() {
    private val _userProfile = MutableStateFlow(
        UserProfile(
        id = "1",
        username = "Muhammad Hykal",
        email = "hykalhakim312@gmail.com",
        password = "password123",
        country = "Indonesia",
        city = "Batam"
    )
    )
    val userProfile: StateFlow<UserProfile> = _userProfile

    // Function to update user profile
    fun updateUserProfile(newProfile: UserProfile) {
        viewModelScope.launch {
            _userProfile.value = newProfile
        }
    }
}