package com.example.projetointegradormarvel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.characters.Personagens
import com.example.projetointegradormarvel.repository.Service
import kotlinx.coroutines.launch

class HomeViewModel(var serv: Service) : ViewModel() {

    val listCharacters = MutableLiveData<List<Personagens.ResultTeste>>()

    fun getAll(offset: Int) {
        viewModelScope.launch {
            listCharacters.value = serv.getAllCharactersRepo(offset).data.results
        }
    }
}
