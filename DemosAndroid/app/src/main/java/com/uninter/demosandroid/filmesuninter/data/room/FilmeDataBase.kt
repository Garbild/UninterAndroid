package com.uninter.demosandroid.filmesuninter.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.uninter.demosandroid.filmesuninter.domain.entity.Filme

@Database(entities = [Filme::class], version = 1)
abstract class FilmeDataBase : RoomDatabase() {
    abstract fun filmeDAO(): IFilmeDAO
}