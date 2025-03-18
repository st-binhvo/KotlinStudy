package com.example.kotlinknowledge.presentation.authentication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinknowledge.app.constant.AppKey
import com.example.kotlinknowledge.data.remote.requests.LoginRequest
import com.example.kotlinknowledge.domain.repositories.AuthenticationRepository
import com.example.kotlinknowledge.ulti.SharedPrefs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import com.github.michaelbull.result.fold
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthenticationRepository
): ViewModel() {
    private val _uiStateFlow = MutableStateFlow<LoginUiState>(LoginUiState.Initial)
    internal val uiStateFlow: StateFlow<LoginUiState> = _uiStateFlow.asStateFlow()

    private inline fun emitState(value : (LoginUiState)-> LoginUiState) = _uiStateFlow.update(value)

    fun login() {
        viewModelScope.launch {
            repository.login(LoginRequest("emilys","emilyspass"))
                .fold(
                    success = {
                        val result = it
                        //save token Authorization to Local
                        saveToken(result.accessToken)
                        emitState {
                            LoginUiState.Succeeded(
                                loginSessionData = result
                            )
                        }
                    },
                    failure = {
                        val error = it
                        emitState {
                            LoginUiState.Failure(error)
                        }
                    },
                )
        }
    }

    private fun saveToken(token: String){
        SharedPrefs.put(AppKey.token,token)
    }
}