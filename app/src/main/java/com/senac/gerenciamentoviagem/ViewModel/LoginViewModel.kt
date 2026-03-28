package com.senac.gerenciamentoviagem.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _senha = MutableStateFlow("")
    val senha: StateFlow<String> = _senha


    val isLoginEnabled: StateFlow<Boolean> =
        combine(_email, _senha) { email, senha ->
            email.isNotBlank() && senha.isNotBlank()
        } as StateFlow<Boolean>

    fun onEmailChange(novo: String) {
        _email.value = novo
    }

    fun onSenhaChange(novo: String) {
        _senha.value = novo
    }
}