package com.senac.gerenciamentoviagem.ViewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class NovoLoginViewModel : ViewModel() {

    private val _nome = MutableStateFlow("")
    val nome: StateFlow<String> = _nome

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _telefone = MutableStateFlow("")
    val telefone: StateFlow<String> = _telefone

    private val _senha = MutableStateFlow("")
    val senha: StateFlow<String> = _senha

    private val _confirmarSenha = MutableStateFlow("")
    val confirmarSenha: StateFlow<String> = _confirmarSenha

    // validação de senha
    val senhaMatch: StateFlow<Boolean> =
        combine(_senha, _confirmarSenha) { s, c ->
            s == c
        } as StateFlow<Boolean>

    // botão habilitado
    val isFormValid: StateFlow<Boolean> =
        combine(_nome, _email, _telefone, _senha, _confirmarSenha) {
                nome, email, telefone, senha, confirmar ->

            nome.isNotBlank() &&
                    email.isNotBlank() &&
                    telefone.isNotBlank() &&
                    senha.isNotBlank() &&
                    confirmar.isNotBlank() &&
                    senha == confirmar
        } as StateFlow<Boolean>

    fun onNomeChange(valor: String) { _nome.value = valor }
    fun onEmailChange(valor: String) { _email.value = valor }
    fun onTelefoneChange(valor: String) { _telefone.value = valor }
    fun onSenhaChange(valor: String) { _senha.value = valor }
    fun onConfirmarSenhaChange(valor: String) { _confirmarSenha.value = valor }
}