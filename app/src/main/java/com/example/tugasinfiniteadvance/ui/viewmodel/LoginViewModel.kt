package com.example.tugasinfiniteadvance.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugasinfiniteadvance.data.remote.firebase.authentication.AuthRepository
import com.example.tugasinfiniteadvance.ui.state.GoogleLoginState
import com.example.tugasinfiniteadvance.ui.state.LoginState
import com.example.tugasinfiniteadvance.util.Resource
import com.google.firebase.auth.AuthCredential
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginState = Channel<LoginState>()
    val loginState =  _loginState.receiveAsFlow()

    private val _googleState = mutableStateOf(GoogleLoginState())
    val googleState: State<GoogleLoginState> = _googleState

    fun googleLogin(credential: AuthCredential) = viewModelScope.launch {
        repository.googleSignIn(credential).collect { result ->
            when (result) {
                is Resource.Success -> {
                    _googleState.value = GoogleLoginState(success = result.data)
                } is Resource.Loading -> {
                    _googleState.value = GoogleLoginState(loading = true)
                } is Resource.Error -> {
                    _googleState.value = GoogleLoginState(error = result.message)
                }
            }
        }
    }

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