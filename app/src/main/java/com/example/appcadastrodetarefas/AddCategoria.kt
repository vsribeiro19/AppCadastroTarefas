package com.example.appcadastrodetarefas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_categoria.*

class AddCategoria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_categoria)

        btnHome.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        btnSalvarCategoria.setOnClickListener{
            val CategoriaDAO = AppDatabase.getInstance(this)?.categoriaDAO()

            val nomeCategoria = edtNomeCategoria.text.toString()

            val a = Categoria(nomeCategoria)

            CategoriaDAO?.salvar(a)

            Toast.makeText(this, "Categoria inserida com sucesso!" , Toast.LENGTH_SHORT).show()
        }
    }
}
