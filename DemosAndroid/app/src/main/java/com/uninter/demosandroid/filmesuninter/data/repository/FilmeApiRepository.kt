package com.uninter.demosandroid.filmesuninter.data.repository

import android.util.Log
import com.uninter.demosandroid.filmesuninter.data.client.ITheMovieDbClient
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FilmeApiRepository {

    private val theMovieDbClient: ITheMovieDbClient
    private val apiKey = "a4061e2bbd9072c85b5efd844e18e697"
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()

        theMovieDbClient = retrofit.create(ITheMovieDbClient::class.java)
    }

    fun get(): List<Filme>?
    {
        try {
            val call = theMovieDbClient.getmoviePopular(apiKey)
            return  call.execute().body()?.results
        }catch (e:Exception)
        {
            Log.e( "FilmeApiRepository", e.message.toString())
            return null
        }
    }
}