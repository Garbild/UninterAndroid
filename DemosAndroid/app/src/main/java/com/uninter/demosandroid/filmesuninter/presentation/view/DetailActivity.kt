package com.uninter.demosandroid.filmesuninter.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

class DetailActivity : AppCompatActivity() {

    private lateinit var txtTitle:TextView
    private lateinit var txtDescription:TextView
    private lateinit var imgBack:ImageView
    private lateinit var imgPoster:ImageView
    private lateinit var btnFavorite:Button
    private val imgBasePath = "https://image.tmdb.org/t/p/w500"

    private var filme: Filme? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        filme = intent.getSerializableExtra("filme") as Filme
    }
    fun bindView()
    {
        txtTitle = findViewById(R.id.txt_detailname)
        txtDescription = findViewById(R.id.txt_detaildescription)
        imgPoster = findViewById(R.id.img_poster)
        imgBack = findViewById(R.id.img_detailbackground)
        btnFavorite = findViewById(R.id.btn_detailfav)

        filme?.let { filme ->
            txtTitle.text = filme.name
            txtDescription.text = filme.overwiew

            Glide.with(this).load("${imgBasePath}${filme.backdropPath}").into(imgBack)
            Glide.with( this).load( "${imgBasePath}${filme.posterPath}").into(imgPoster)

            btnFavorite.text = if(filme.favorite) "Desfavoritar" else "Favoritar"
            btnFavorite.setOnClickListener{
                if(filme.favorite)
                    unfavorite(filme)
                else
                    favorite(filme)

                finish()
            }
        }
    }

    private fun unfavorite(filme: Filme) {

    }
    private fun favorite(filme: Filme) {

    }
}