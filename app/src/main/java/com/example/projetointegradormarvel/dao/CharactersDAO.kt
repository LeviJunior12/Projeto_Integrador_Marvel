package com.example.projetointegradormarvel.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegradormarvel.models.Characters

@Dao
interface CharactersDAO {
    @Insert
    suspend fun addCharacters(characters: Characters)

    @Query("SELECT * FROM characters")
    suspend fun getAllCharacters(): List<Characters>
}