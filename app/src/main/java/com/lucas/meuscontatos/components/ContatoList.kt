package com.lucas.meuscontatos.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lucas.meuscontatos.model.Contato

    @Composable
    fun ContatoList(listaContatos: MutableState<List<Contato>>) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    )

    {
        for (i in listaContatos.value){
            // A cada volta do for o contato é salvo em i e atribuido ao contatoCard
            ContatoCard(i)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

}