package com.example.projetointegradormarvel.comics

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.services.RepositoryComic
import kotlinx.coroutines.launch

class ComicsViewModel(val repository: RepositoryComic): ViewModel() {

    val listComics = MutableLiveData<List<ComicsResults>>()

    fun addAllComics(comics: ComicsResults) {
        viewModelScope.launch {
            repository.addComicsRepository(comics)
        }
    }

    fun getAllComics() {
        viewModelScope.launch {
            listComics.value = repository.getAllComicsRepository()
        }
    }
}