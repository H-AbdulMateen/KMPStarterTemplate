package com.abdulmateen.kmpstartertemplate.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState: StateFlow<LoginUIState> = _uiState

    fun uiEvent(event: LoginUIEvents){
        when(event){
            is LoginUIEvents.UpdateEmail -> {
                _uiState.update {
                    it.copy(
                        email = event.text
                    )
                }
            }
            is LoginUIEvents.UpdatePassword -> {
                _uiState.update {
                    it.copy(
                        password = event.text
                    )
                }
            }
            LoginUIEvents.OnLoginClick -> {}
        }
    }
}

data class LoginUIState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = ""
)

sealed class LoginUIEvents{
    data class UpdateEmail(val text: String): LoginUIEvents()
    data class UpdatePassword(val text: String): LoginUIEvents()
    object OnLoginClick: LoginUIEvents()
}