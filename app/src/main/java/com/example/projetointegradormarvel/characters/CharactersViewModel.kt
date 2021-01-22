package com.example.projetointegradormarvel.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.services.Repository
import kotlinx.coroutines.launch

class CharactersViewModel(val repository: Repository): ViewModel() {

    val listCharacters = MutableLiveData<List<CharactersResults>>()

    fun addAllCharacter(characters: CharactersResults) {
        viewModelScope.launch {
            repository.addCharactersRepository(characters)
        }
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            listCharacters.value = repository.getAllCharactersRepository()
        }
    }

}