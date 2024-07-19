package com.uninter.demosandroid.filmesuninter.presentation.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.uninter.demosandroid.R
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme


class FilmeAdapter (private val itens: List<Filme>): Adapter<FilmeAdapter.ViewHolder>(){
    class ViewHolder(val itemview: View): RecyclerView.ViewHolder(itemview) {

        private val imgBasePath = "https://image.tmdb.org/t/p/w500"

        fun bindView(filme: Filme)
        {
            with(itemview){
                var imgpicture = findViewById<ImageView>(R.id.img_picture)

                Glide.with(this).load("${imgBasePath}${filme.backdropPath}").into(imgpicture)
                findViewById<ImageView>(R.id.img_favorite).visibility = if (filme.favorite) View.VISIBLE
                else View.GONE

                itemview.setOnClickListener{
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra( "filme", filme)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.filme_item, parent, false)
        return  ViewHolder(view)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var filme = itens[position]
        holder.bindView(filme)
    }
}