package com.uninter.demosandroid.filmesuninter.presentation.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.data.repository.FilmeApiRepository
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

class MainActivity : ComponentActivity() {

    private  lateinit var  recyclerView: RecyclerView
    private var filme: List<Filme> = listOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rcvFilmes)

        Thread(Runnable {
            FilmeApiRepository.get()?.let {
                filme = it
            }

            recyclerView.post{
                loadRecycleView()
            }

        }).start()

    }

    fun loadRecycleView(){
        recyclerView.layoutManager = LinearLayoutManager( this)
        recyclerView.adapter = FilmeAdapter(filme)
    }
}