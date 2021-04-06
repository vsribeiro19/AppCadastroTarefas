package com.example.appcadastrodetarefas

import androidx.room.Embedded
import androidx.room.Relation

data class CategoriaProduto(@Embedded val categoria : Categoria,
@Relation(
    parentColumn = "idCategoria",
    entityColumn = "idCategoria"
) val produtos: List<Produto>){

}