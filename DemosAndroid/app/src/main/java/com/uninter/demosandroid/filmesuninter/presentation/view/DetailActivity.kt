package com.uninter.demosandroid.filmesuninter.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

class DetailActivity : AppCompatActivity() {

    private lateinit var txtTitle: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgBack: ImageView
    private lateinit var imgPoster: ImageView
    private lateinit var btnFavorite: Button
    private val imgBasePath = "https://image.tmdb.org/t/p/w500"

    private var filme: Filme? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        filme = intent.getSerializableExtra("filme") as Filme
        bindView()
    }

    private fun bindView() {
        txtTitle = findViewById(R.id.txtdetailname)
        txtDescription = findViewById(R.id.txtdetaildescription)
        imgPoster = findViewById(R.id.imgposter)
        imgBack = findViewById(R.id.imgdetailbackground)
        btnFavorite = findViewById(R.id.btndefav)

        filme?.let { filme ->
            txtTitle.text = filme.title
            txtDescription.text = filme.overview

            Glide.with(this).load("${imgBasePath}${filme.backdropPath}").into(imgBack)
            Glide.with(this).load("${imgBasePath}${filme.posterPath}").into(imgPoster)

            btnFavorite.text = if (filme.favorite) "Desfavoritar" else "Favoritar"
            btnFavorite.setOnClickListener {
                if (filme.favorite) unfavorite(filme) else favorite(filme)
                finish()
            }
        }//
    }

    private fun unfavorite(filme: Filme) {
        // Implementação para desfavoritar
    }

    private fun favorite(filme: Filme) {
        // Implementação para favoritar
    }
}