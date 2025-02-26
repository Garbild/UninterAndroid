package com.uninter.demosandroid.filmesuninter.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "filme")//entidade
data class Filme(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val poularity: Double,
    @ColumnInfo( "backdrop_path")@SerializedName("backdrop_path") val backdropPath: String,
    @ColumnInfo( "poster_path")@SerializedName("poster_path")val posterPath: String,
    var favorite: Boolean,
    val adult: Boolean

): Serializable