package com.example.appcadastrodetarefas

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CategoriaDAO {

    @Insert
    fun salvar(c: Categoria)

    @Query("SELECT * FROM Categoria")
    fun listar(): List<Categoria>

    @Query("SELECT * FROM Categoria")
    fun listProdCat(): List<CategoriaProduto>

}