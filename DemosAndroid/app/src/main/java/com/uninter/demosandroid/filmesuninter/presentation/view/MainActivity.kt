package com.uninter.demosandroid.filmesuninter.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeApiRepository
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeSqliteRepository
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme
import com.uninter.demosandroid.filmesuninter.presentation.viewmodel.FilmeViewModelFactory
import com.uninter.demosandroid.filmesuninter.presentation.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private val viewModel by lazy {
        val factory = FilmeViewModelFactory(application)
        ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rcvFilmes)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.filme.observe(this) { filmes ->
            recyclerView.adapter = FilmeAdapter(filmes)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }
}