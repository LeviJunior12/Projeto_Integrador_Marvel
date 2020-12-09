package com.example.projetointegradormarvel.home

import Results
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projetointegradormarvel.services.Service
import kotlinx.coroutines.launch

class HomeViewModel(val service: Service) : ViewModel() {

    var listCharacters = MutableLiveData<ArrayList<Results>>()

    fun getListCharacters() {
        viewModelScope.launch {
            listCharacters.value = service.getCharacters("1", "484aabccfdee8f7fb36050a933af2cd6", "803577de0ce5cc73cb0b03144f63779c", "10").data.results
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}