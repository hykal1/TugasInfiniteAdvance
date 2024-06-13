package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.remote.firebase.authentication.AuthRepository
import com.example.tugasinfiniteadvance.ui.state.LoginState
import com.example.tugasinfiniteadvance.util.Resource
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = Channel<LoginState>()
    val loginState =  _loginState.receiveAsFlow()

    fun loginUser(email: String, password: String) = viewModelScope.launch {
        repository.loginUser(email, password).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _loginState.send(LoginState(isSucces = "Sign In Success"))
                } is Resource.Loading -> {
                    _loginState.send(LoginState(isLoading = true))
                } is Resource.Error -> {
                    _loginState.send(LoginState(isError = result.message))
                }
            }
        }
    }

}