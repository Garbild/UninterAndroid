package com.uninter.demosandroid.filmesuninter.data.client

import com.uninter.demosandroid.filmesuninter.data.model.FilmeResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ITheMovieDbClient {
    @GET("3/movie/popular")
    fun getmoviePopular(@Query("api_key") apikey: String): Call <FilmeResult>

}