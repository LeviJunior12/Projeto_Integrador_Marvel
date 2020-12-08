package com.example.projetointegradormarvel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.UI.MainViewModel
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.characters.Personagens
import com.example.projetointegradormarvel.creators.Creators
import com.example.projetointegradormarvel.repository.serv

class ListFragment : Fragment() {

    private var listIComics = ArrayList<Comics>()
    private var listCharacters = ArrayList<Personagens.Characters>()
    private var listCreators = ArrayList<Creators>()


    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(serv) as T
            }
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.findViewById<RecyclerView>(R.id.rv_characters).apply {
            layoutManager = LinearLayoutManager(view.context,)

        }
        // TODO: Fix Gridlayout in Horizontal Mode
        return view
    }

}
