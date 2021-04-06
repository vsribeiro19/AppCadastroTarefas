package com.example.appcadastrodetarefas

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Categoria(
    val nomeCategoria: String,
    @PrimaryKey(autoGenerate = true)
    val idCategoria: Int = 0){

    override fun toString(): String {
        return nomeCategoria
    }
}

