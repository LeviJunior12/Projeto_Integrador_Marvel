package com.example.projetointegradormarvel.creators

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.services.RepositoryCreator
import kotlinx.coroutines.launch

class CreatorsViewModel(val repository: RepositoryCreator): ViewModel() {
    val listCreators = MutableLiveData<List<CreatorsResults>>()

    fun addAllCreators(creators: CreatorsResults) {
        viewModelScope.launch {
            repository.addCreatorRepository(creators)
        }
    }

    fun getAllCreators() {
        viewModelScope.launch {
            listCreators.value = repository.getAllCreatorsRepository()
        }
    }
}