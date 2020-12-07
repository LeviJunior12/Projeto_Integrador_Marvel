package com.example.projetointegradormarvel.UI


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.characters.Characters
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.creators.Creators
import com.example.projetointegradormarvel.repository.Service
import com.example.projetointegradormarvel.repository.serv
import kotlinx.coroutines.launch

class MainViewModel(val service: Service): ViewModel() {

    var offset = 0


    //Criação das variáveis das listas
    val listComics = MutableLiveData<List<Comics>>()
    val listCreators = MutableLiveData<List<Creators>>()
    val listCharacters = MutableLiveData<List<Characters>>()



    //Funções para resgatar as informações do Repisotório Repository.kt

    //Quadrinhos
        fun getListComics(offset: Int) {
            viewModelScope.launch {
                listComics.value = listOf(serv.getAllComicsRepo(offset))
            }
        }

    //Criadores
        fun getAllCreators(offset: Int) {
            viewModelScope.launch {
                listCreators.value = listOf(serv.getAllCreatorsRepo(offset))
            }
    }

    //Personagens
    fun getAllCharacters(offset: Int) {
        viewModelScope.launch {
            listCharacters.value = listOf(serv.getAllCharactersRepo(offset))
        }
    }

}