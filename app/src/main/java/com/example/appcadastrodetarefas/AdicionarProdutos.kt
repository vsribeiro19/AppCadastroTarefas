package com.example.appcadastrodetarefas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adicionar_produtos.*

class AdicionarProdutos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_produtos)

        val categoria = AppDatabase.getInstance(this)!!.categoriaDAO().listar()

        val adp = ArrayAdapter(this,android.R.layout.simple_spinner_item, categoria)
        spnCategoria.adapter = adp

        btnSalvarProduto.setOnClickListener{
            val idProd = edtIdProd.text.toString().toInt()
            val NomeProduto = edtNomeProduto.text.toString()
            val descricao = edtPreco.text.toString()
            val preco = edtPreco.text.toString()
            val idCategoria = spnCategoria.selectedItem.toString().toInt()

            val p = Produto(idProd,NomeProduto, descricao, preco, idCategoria)

            AppDatabase.getInstance(this)!!.produtoDAO().salvar(p)

            Toast.makeText(this, "Produto inserido com sucesso!" , Toast.LENGTH_SHORT).show()

            finish()
        }

        /*

        btnSalvarProduto.setOnClickListener{
            val ProdutoDAO = AppDatabase.getInstance(this)?.produtoDAO()
            val produto = edtNomeProduto.text.toString()
            val descricao = edtDescProduto.text.toString()
            //val preco = edtPreco.text.toString().toFloat()

            val a = Produto(produto , descricao)
            //val c = Produto(preco)
            ProdutoDAO?.SalvarProduto(a)

            Toast.makeText(this, "Produto inserido com sucesso!" , Toast.LENGTH_SHORT).show()
        }

    val tiposCategoria = resources.getStringArray(R.array.tiposCategoria)

    val adp = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,tiposCategoria)

        spnCategoria.adapter = adp


*/

    }
}
