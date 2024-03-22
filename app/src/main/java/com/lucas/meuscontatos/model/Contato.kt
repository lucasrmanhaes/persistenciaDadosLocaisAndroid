package com.lucas.meuscontatos.model

import androidx.room.Entity

    @Entity
    data class Contato (
        var id: Long = 0,
        var nome: String = "",
        var telefone: String = "",
        var isAmigo: Boolean = false,
    )

