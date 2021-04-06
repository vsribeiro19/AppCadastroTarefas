package com.example.appcadastrodetarefas

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ProdutoDAO {

    @Insert
    fun salvar(p: Produto)

    @Query("SELECT * FROM Produto")
    fun listar(): List<Produto>

    @Query("SELECT * FROM Produto")
    fun listProdCat(): List<CategoriaProduto>


}