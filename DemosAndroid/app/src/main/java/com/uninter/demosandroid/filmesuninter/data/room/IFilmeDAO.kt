package com.uninter.demosandroid.filmesuninter.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

import androidx.room.OnConflictStrategy
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme
import retrofit2.http.Query

@Dao
interface IFilmeDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(filme: Filme)

    @androidx.room.Query("SELECT * FROM filme")
    fun get(): List<Filme>

    @Delete
    fun delete(filme: Filme)
}