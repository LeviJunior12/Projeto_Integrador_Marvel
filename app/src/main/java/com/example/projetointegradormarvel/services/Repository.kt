package com.example.projetointegradormarvel.services

import com.example.projetointegradormarvel.dao.CharacterDAO
import com.example.projetointegradormarvel.models.model.Character

interface Repository {
    suspend fun addCharacter(character: Character)
}

class RepositoryImpl(val characterDao: CharacterDAO): Repository {
    override suspend fun addCharacter(character: Character) {
        characterDao.addCharacter(character)
    }

}