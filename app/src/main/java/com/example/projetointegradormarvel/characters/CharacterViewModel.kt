package com.example.projetointegradormarvel.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.models.model.Character
import com.example.projetointegradormarvel.services.Repository
import kotlinx.coroutines.launch

class CharacterViewModel(val repository: Repository): ViewModel() {
    fun addCharacter(character: Character) {
        viewModelScope.launch {
            repository.addCharacter(character)
        }
    }
}