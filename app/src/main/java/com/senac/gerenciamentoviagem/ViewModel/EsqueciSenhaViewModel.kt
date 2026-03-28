package com.senac.gerenciamentoviagem.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

class EsqueciSenhaViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    // validação simples de email
    val isEmailValid: StateFlow<Boolean> =
        _email.map { email ->
            email.isNotBlank() && email.contains("@")
        } as StateFlow<Boolean>

    fun onEmailChange(valor: String) {
        _email.value = valor
    }
}