package com.example.projetointegradormarvel.models.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String
)