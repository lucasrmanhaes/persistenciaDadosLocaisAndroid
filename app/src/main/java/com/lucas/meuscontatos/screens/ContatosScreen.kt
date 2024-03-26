package com.lucas.meuscontatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.lucas.meuscontatos.components.ContatoForm
import com.lucas.meuscontatos.components.ContatoList

@Composable
fun ContatosScreen() {

    var nomeState by remember { mutableStateOf("") }
    var telefoneState by remember { mutableStateOf("") }
    var amigoState by remember { mutableStateOf(false) }

    Column {
        ContatoForm(
            nome = nomeState,
            telefone = telefoneState,
            amigo = amigoState,
            onNomeChange = {
                nomeState = it
            },
            onTelefoneChange = {
                telefoneState = it
            },
            onAmigoChange ={
                amigoState = it
            }
        )
        ContatoList()
    }
}
