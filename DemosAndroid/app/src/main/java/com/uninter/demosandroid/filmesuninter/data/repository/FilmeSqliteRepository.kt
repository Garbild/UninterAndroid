package com.uninter.demosandroid.filmesuninter.data.repository

import android.app.Application
import androidx.room.Room
import com.uninter.demosandroid.filmesuninter.data.room.FilmeDataBase
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

class FilmeSqliteRepository  constructor(application: Application) {

    companion object {
        @Volatile
        private var INSTANCE: FilmeSqliteRepository? = null

        fun getInstance(application: Application): FilmeSqliteRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: FilmeSqliteRepository(application).also { INSTANCE = it }
            }
        }
    }

    private val dataBase: FilmeDataBase = Room.databaseBuilder(
        application.applicationContext,
        FilmeDataBase::class.java,
        "filme-db"
    )
        .allowMainThreadQueries() // Use apenas para fins de teste
        .build()

    fun add(filme: Filme) {
        dataBase.filmeDAO().insert(filme)
    }

    fun get(): List<Filme> {
        return dataBase.filmeDAO().get()
    }

    fun delete(filme: Filme) {
        dataBase.filmeDAO().delete(filme)
    }
}