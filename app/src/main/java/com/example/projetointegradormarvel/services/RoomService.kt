package com.example.projetointegradormarvel.services

import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.dao.CharactersDAO
import com.example.projetointegradormarvel.dao.ComicsDAO
import com.example.projetointegradormarvel.dao.CreatorsDAO

interface Repository {
    suspend fun addCharactersRepository(characters: CharactersResults)

    suspend fun getAllCharactersRepository(): List<CharactersResults>

}

interface RepositoryComic {
    suspend fun addComicsRepository(comics: ComicsResults)
    suspend fun getAllComicsRepository(): List<ComicsResults>
}

interface RepositoryCreator {
    suspend fun addCreatorRepository(creatorsResults: CreatorsResults)
    suspend fun getAllCreatorsRepository(): List<CreatorsResults>
}

class ReposirotyImpl(val charactersDAO: CharactersDAO): Repository {
    override suspend fun addCharactersRepository(characters: CharactersResults) {
        charactersDAO.addCharacters(characters)
    }

    override suspend fun getAllCharactersRepository() = charactersDAO.getAllCharacters()

}

class RepositoryComics(val comicsDAO: ComicsDAO): RepositoryComic {
    override suspend fun addComicsRepository(comics: ComicsResults) {
        comicsDAO.addComics(comics)
    }

    override suspend fun getAllComicsRepository(): List<ComicsResults> = comicsDAO.getAllComics()

}

class RepositoryCreators(val creatorsDAO: CreatorsDAO): RepositoryCreator {
    override suspend fun addCreatorRepository(creators: CreatorsResults) {
        creatorsDAO.addCreators(creators)
    }

    override suspend fun getAllCreatorsRepository(): List<CreatorsResults> = creatorsDAO.getAllCreators()
}