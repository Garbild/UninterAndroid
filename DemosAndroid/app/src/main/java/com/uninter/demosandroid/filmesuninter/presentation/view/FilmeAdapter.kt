package com.uninter.demosandroid.filmesuninter.presentation.view

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme


class FilmeAdapter(private val itens: List<Filme>) : RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {
    class ViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgBasePath = "https://image.tmdb.org/t/p/w500"

        fun bindView(filme: Filme) {
            with(itemView) {
                val imgPicture = findViewById<ImageView>(R.id.imgpicture)

                Glide.with(this).load("$imgBasePath${filme.backdropPath}").into(imgPicture)

                findViewById<ImageView>(R.id.imgfavorite).visibility = if (filme.favorite) View.VISIBLE else View.GONE

                findViewById<TextView>(R.id.txtTitle).text = filme.title

                Log.d("FilmeAdapter", "Filme ID: ${filme.id}, Favorite: ${filme.favorite}")
                setOnClickListener {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("filme", filme)
                    context.startActivity(intent)

                }
            }
        }//
    }//
//
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filme_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = itens[position]
        holder.bindView(filme)
    }
}