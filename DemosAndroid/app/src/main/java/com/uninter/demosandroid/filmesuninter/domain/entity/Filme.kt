package com.uninter.demosandroid.filmesuninter.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "filme")
data class Filme(
    @PrimaryKey val id: Int,
    val name: String,
    val overwiew: String,
    val poularity: Double,
    @ColumnInfo( "backdrop_path")@SerializedName("backdrop_path") val backdropPath: String,
    @ColumnInfo( "poster_path")@SerializedName("poster_path")val posterPath: String,
    val adult: Boolean
): Serializable