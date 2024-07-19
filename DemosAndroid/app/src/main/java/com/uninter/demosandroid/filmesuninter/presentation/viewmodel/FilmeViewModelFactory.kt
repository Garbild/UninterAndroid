package com.uninter.demosandroid.filmesuninter.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FilmeViewModelFactory(var application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(MainViewModel::class.java))
       {
           return MainViewModel(application) as T
       }
        else if(modelClass.isAssignableFrom(DetailViewModel::class.java))
        {
            return DetailViewModel(application) as T
        }

        throw IllegalArgumentException("Classe Invalida")

    }
}