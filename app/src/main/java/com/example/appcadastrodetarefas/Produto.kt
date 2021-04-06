package com.example.appcadastrodetarefas

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Produto(
    @PrimaryKey (autoGenerate = true)
    val idProd: Int,
    val NomeProduto: String,
    val descricao: String,
    val preco: String,
    val idCategoria: Int){

    override fun toString(): String {
        return descricao + "/" + NomeProduto
    }
}

