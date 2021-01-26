package com.example.projetointegradormarvel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.WebService
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import kotlinx.coroutines.launch

class HomeViewModel(private val webService: WebService) : ViewModel() {

    var listCharacters = MutableLiveData<List<CharactersResults>>()
    var listComics = MutableLiveData<List<ComicsResults>>()
    var listCreators = MutableLiveData<List<CreatorsResults>>()

    fun getCharacters(offset: Int) {
        viewModelScope.launch {
            listCharacters.value = webService.getCharactersRepo(offset).data.results
        }
    }

    fun getComics(offset: Int) {
        viewModelScope.launch {
            listComics.value = webService.getComicsRepo(offset).data.results
        }
    }

    fun getCreators(offset: Int) {
        viewModelScope.launch {
            listCreators.value = webService.getCreatorsRepo(offset).data.results
        }
    }

    //Chamando da API para a Busca

    fun getCharacterSearch(){
        viewModelScope.launch {
            listCharacters.value = webService.getCharactersSearch().data.results
        }
    }

    fun getComicSearch(){
        viewModelScope.launch {
            listComics.value = webService.getComicsSearch().data.results
        }
    }

    fun getCreatorSearch(){
        viewModelScope.launch {
            listCreators.value = webService.getCreatorsSearch().data.results
        }
    }
}