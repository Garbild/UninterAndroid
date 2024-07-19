package com.uninter.demosandroid.filmesuninter.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme
import com.uninter.demosandroid.filmesuninter.domain.usecase.FilmeUseCase

class DetailViewModel(application: Application): ViewModel() {
    private val useCase = FilmeUseCase(application)

    fun favorite(filme: Filme){
        useCase.favorite(filme)
    }

    fun unfavorite(filme: Filme){
        useCase.unfavorite(filme)
    }

}