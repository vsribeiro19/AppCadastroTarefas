package com.example.appcadastrodetarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAddCategoria.setOnClickListener{
            startActivity(Intent(this, AddCategoria::class.java))
        }

        lstCategoria.setOnItemClickListener { parent, view, position, id ->
            startActivity(Intent(this, ListagemProdutos::class.java))
        }
    }
    override fun onResume() {
        super.onResume()

        carregarLista()
    }

    private fun carregarLista() {
        val categoriaDAO = AppDatabase.getInstance(this)?.categoriaDAO()
        val listarCategorias: List<Categoria>
        listarCategorias = categoriaDAO!!.listar()

        val adp =
            ArrayAdapter<Categoria>(this, android.R.layout.simple_list_item_1, listarCategorias)

        lstCategoria.adapter = adp
    }
}
