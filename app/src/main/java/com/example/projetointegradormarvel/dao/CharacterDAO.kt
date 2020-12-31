package com.example.projetointegradormarvel.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.projetointegradormarvel.models.model.Character

@Dao
interface CharacterDAO {
    @Insert
    suspend fun addCharacter(character: Character)
}