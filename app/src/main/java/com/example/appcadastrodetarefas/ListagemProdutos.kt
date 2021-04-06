package com.example.appcadastrodetarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_listagem_produtos.*

class ListagemProdutos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem_produtos)

        btnAddProduto.setOnClickListener{
            startActivity(Intent(this, AdicionarProdutos::class.java))
        }
    }

    override fun onResume(){
        super.onResume()

        listarProdutos()
    }

    private fun listarProdutos() {
        val produtoDAO = AppDatabase.getInstance(this)?.produtoDAO()

        val listarProtuto: List<Produto>
        listarProtuto = produtoDAO!!.listar()

        val adp = ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, listarProtuto)

        lstProdutos.adapter = adp
    }
}
