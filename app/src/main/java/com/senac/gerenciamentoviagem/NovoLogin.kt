package com.senac.gerenciamentoviagem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.senac.gerenciamentoviagem.ViewModel.NovoLoginViewModel

@Composable
fun NovoLogin(
    onNavigate: () -> Unit,
    viewModel: NovoLoginViewModel = viewModel()
) {
    val nome = viewModel.nome.collectAsState().value
    val email = viewModel.email.collectAsState().value
    val telefone = viewModel.telefone.collectAsState().value
    val senha = viewModel.senha.collectAsState().value
    val confirmarSenha = viewModel.confirmarSenha.collectAsState().value

    val senhaMatch = viewModel.senhaMatch.collectAsState(initial = true).value
    val isFormValid = viewModel.isFormValid.collectAsState(initial = false).value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nome,
            onValueChange = { viewModel.onNomeChange(it) },
            label = { Text("Nome") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = telefone,
            onValueChange = { viewModel.onTelefoneChange(it) },
            label = { Text("Telefone") }
        )

        PasswordTextField(
            senha = senha,
            onSenhaChange = { viewModel.onSenhaChange(it) },
            label = "Senha"
        )

        PasswordTextField(
            senha = confirmarSenha,
            onSenhaChange = { viewModel.onConfirmarSenhaChange(it) },
            label = "Confirmar Senha"
        )


        if (!senhaMatch) {
            Text(
                text = "As senhas não coincidem",
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = onNavigate,
                enabled = isFormValid
            ) {
                Text(text = "Cadastrar")
            }
        }
    }
}