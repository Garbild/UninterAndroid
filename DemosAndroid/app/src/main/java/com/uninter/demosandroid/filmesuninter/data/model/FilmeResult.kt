package com.uninter.demosandroid.filmesuninter.data.model

import com.google.gson.annotations.SerializedName
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

data class FilmeResult (
    val page: Int,
    val results: List<Filme>,
    @SerializedName("total_pages")val totalpages:Int,
    @SerializedName("total_results")val totalresults: Int

)