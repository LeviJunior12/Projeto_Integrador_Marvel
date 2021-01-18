package com.example.projetointegradormarvel.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Characters(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val description: String
)