package com.example.projetointegradormarvel.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.projetointegradormarvel.creators.CreatorsResults

@Dao
interface CreatorsDAO {
    @Insert
    suspend fun addCreators(creators: CreatorsResults)

    @Query("SELECT * FROM creators")
    suspend fun getAllCreators(): List<CreatorsResults>
}