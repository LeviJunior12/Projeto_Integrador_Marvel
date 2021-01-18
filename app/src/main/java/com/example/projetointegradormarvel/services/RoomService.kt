package com.example.projetointegradormarvel.services

import com.example.projetointegradormarvel.dao.CharactersDAO
import com.example.projetointegradormarvel.models.Characters

interface Repository {
    suspend fun addCharactersRepository(characters: Characters)

    suspend fun getAllCharactersRepository(): List<Characters>
}

class ReposirotyImpl(val charactersDAO: CharactersDAO): Repository {
    override suspend fun addCharactersRepository(characters: Characters) {
        charactersDAO.addCharacters(characters)
    }

    override suspend fun getAllCharactersRepository() = charactersDAO.getAllCharacters()

}