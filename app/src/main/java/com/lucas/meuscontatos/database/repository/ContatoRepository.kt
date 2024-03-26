package com.lucas.meuscontatos.database.repository

import android.content.Context
import com.lucas.meuscontatos.database.dao.ContatoDB
import com.lucas.meuscontatos.model.Contato

    class ContatoRepository(context: Context) {

//  Criando uma variavel que contém a instancia
//  e o DAO para fazer a persistencia de Contatos
    private val db = ContatoDB.getDatabase(context).contatoDao()

//  Criando uma função salvar e vai retornar o numero do id do contato salvo
    fun salvar(contato: Contato): Long {
        return db.salvar(contato = contato)
    }

    //atualizar
    fun atualizar(contato: Contato): Int{
        return db.atualizar(contato = contato)
    }

    //Excluir
    fun excluir(contato: Contato): Int{
        return db.excluir(contato = contato)
    }

    //BuscarUsuarioPeloID
    fun buscarUsuarioPeloId(id: Int): Contato{
        return db.buscarContatoPeloId(id = id)
    }

    //ListarContatos
    fun listarContatos(): List<Contato>{
        return db.listarContatos()
    }

}

