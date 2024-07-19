package com.uninter.demosandroid.filmesuninter.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeApiRepository
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme
import com.uninter.demosandroid.filmesuninter.domain.usecase.FilmeUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application): ViewModel() {

    private val useCase = FilmeUseCase(application)
    var filme = MutableLiveData<List<Filme>>()

    fun load(){
        Thread(Runnable {
            filme.postValue(useCase.get())
            useCase.get()
        }).start()
    }
    fun updateFavoriteStatus(filme: Filme) {
        viewModelScope.launch {
            if (filme.favorite) {
                useCase.favorite(filme)
            } else {
                useCase.unfavorite(filme)
            }
            load()
        }
    }
}