package com.example.appcadastrodetarefas

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Categoria::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun  categoriaDAO() : CategoriaDAO
    abstract fun  produtoDAO() : ProdutoDAO

    companion object{

        private var database: AppDatabase? = null
        private val DATABASE = "AppDatabase"

        fun getInstance(context: Context): AppDatabase? {

            if(database == null)
                return criaBanco(context)
            else
                return database
        }


        private fun criaBanco(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}