package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.remote.firebase.authentication.AuthRepository
import com.example.tugasinfiniteadvance.ui.state.SignUpState
import com.example.tugasinfiniteadvance.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _signUpState = Channel<SignUpState>()
    val signUpState = _signUpState.receiveAsFlow()

    fun registerUser(username: String, email: String, password: String) = viewModelScope.launch {
        repository.registerUser(username, email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _signUpState.send(SignUpState(isSucces = "Sign Up Success"))
                } is Resource.Loading -> {
                    _signUpState.send(SignUpState(isLoading = true))
                } is Resource.Error -> {
                    _signUpState.send(SignUpState(isError = result.message))
                }
            }
        }
    }

}