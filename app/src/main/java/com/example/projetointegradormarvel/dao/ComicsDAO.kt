package com.example.projetointegradormarvel.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegradormarvel.comics.ComicsResults

@Dao
interface ComicsDAO {
    @Insert
    suspend fun addComics(comics: ComicsResults)

    @Query("SELECT * FROM comics")
    suspend fun getAllComics(): List<ComicsResults>
}