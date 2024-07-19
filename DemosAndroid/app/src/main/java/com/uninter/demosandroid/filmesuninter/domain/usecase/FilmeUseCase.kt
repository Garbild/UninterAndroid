package com.uninter.demosandroid.filmesuninter.domain.usecase

import android.annotation.SuppressLint
import android.app.Application
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeApiRepository
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeSqliteRepository
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme


class FilmeUseCase(application: Application) {
    private val apiRepository = FilmeApiRepository // Crie uma instância, se necessário
    private val dbRepository = FilmeSqliteRepository(application)
    @SuppressLint("SuspiciousIndentation")
    fun get(): List<Filme>
    {
        var filmes: List<Filme> = listOf()

        dbRepository.get()?.let {
            filmes=filmes.plus(it)
        }

        apiRepository.get()?.let {
            var lista = it.toMutableList()
                lista.removeAll{ filme -> filmes.any { filmeDb -> filmeDb.id == filme.id } }
                filmes = filmes.plus(lista)
        }
        return filmes
    }

    fun favorite(filme: Filme)
    {
        filme.favorite = true
        dbRepository.add(filme)
    }

    fun unfavorite(filme: Filme)
    {
        dbRepository.delete(filme)
    }
}