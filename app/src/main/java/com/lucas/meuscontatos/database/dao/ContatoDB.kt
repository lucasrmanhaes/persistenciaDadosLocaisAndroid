package com.lucas.meuscontatos.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lucas.meuscontatos.model.Contato

@Database(entities = [Contato::class], version = 1)
abstract class ContatoDB : RoomDatabase() {

    abstract fun contatoDao(): ContatoDao

//  Bloco estático - o que tiver aqui não precisa de instancia
    companion object {

//      Irá retornar a instancia única de ContatoDB
//      e seu atributo da propria classe e não do objeto
        private lateinit var instance: ContatoDB
//      Um método que contem o contexto da aplicação
//      Quem chamar o metodo getDatabase deverá informar o contexto
//      que são os recursos da aplicação que estamos trabalhando
//      Essa função retorna a instancia única do banco de dados
        fun getDatabase(context: Context): ContatoDB {

//          !:: Se a instancia não for inicializada executar o bloco de criação de instancia
            if (!::instance.isInitialized) {
//              Criar instancia chamando a classe Room e o metodo databaseBuilder
//              Que é o construtor do banco de dados passando como parametro o
//              contexto que está na função getDatabase e também quem é o banco de dados
//              a instancia, a classe que representa o banco de dados ContatoDB::class.java
//              A classe deve ser passada já instanciada e o nome do db name:"contato_db"
//              Esse banco nao existe, então ele vai ser criado na primeira instancia
                instance = Room.databaseBuilder(
                    context,
                    ContatoDB::class.java,
                    "contato_db"
                )
                    .allowMainThreadQueries() // Fazer a persistencia na mesma Thread
                    .fallbackToDestructiveMigration() // A cada atualização, não usar o banco antigo, destruir o db antigo
                    .build() // fazer a construção da instancia
            }
            return instance // se for falso executa o bloco e retorna a intancia, se for verdadeiro pula o bloco e retorna a instancia
        }
    }
}


