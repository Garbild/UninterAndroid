package com.uninter.demosandroid.filmesuninter.presentation.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

class DetailActivity : AppCompatActivity() {

    private lateinit var txtTitle:TextView
    private lateinit var txtDescription:TextView
    private lateinit var imgBack:ImageView
    private lateinit var imgPoster:ImageView
    private lateinit var btnFavorite:Button

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

        filme?.let {

        }
    }
}