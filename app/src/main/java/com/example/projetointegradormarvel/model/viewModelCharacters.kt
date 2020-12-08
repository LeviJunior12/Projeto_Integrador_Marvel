package com.example.projetointegradormarvel.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.characters.Personagens
import com.example.projetointegradormarvel.repository.Service
import kotlinx.coroutines.launch

class viewModelCharacters(var serv: Service) : ViewModel() {

    val listCharacters = MutableLiveData<List<Personagens.ResultTeste>>()

    fun getListCharacters(offset: Int) {
        viewModelScope.launch {
            listCharacters.value = serv.getAllCharactersRepo(offset).data.results
        }
    }
}