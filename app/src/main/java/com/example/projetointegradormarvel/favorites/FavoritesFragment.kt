package com.example.projetointegradormarvel.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.characters.Characters
import com.example.projetointegradormarvel.comics.ComicAdapter
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.creators.CreatorAdapter
import com.example.projetointegradormarvel.creators.Creators

class FavoritesFragment : Fragment() {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    private lateinit var viewModel: FavoritesViewModel
    private var listCharacters = ArrayList<Characters>()
    private var listCreators= ArrayList<Creators>()
    private var listComics = ArrayList<Comics>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        listCharacters = getListCharacters()
        listCreators = getListCreators()
        listComics = getListComics()

        view.findViewById<RecyclerView>(R.id.rv_fav_characters).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CharacterAdapter(listCharacters)
        }

        view.findViewById<RecyclerView>(R.id.rv_fav_creators).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CreatorAdapter(listCreators)
        }

        view.findViewById<RecyclerView>(R.id.rv_fav_comics).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = ComicAdapter(listComics)
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    fun getListCharacters(): ArrayList <Characters>{
        return arrayListOf(
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_marvel_logo)
        )
    }

    fun getListCreators(): ArrayList <Creators>{
        return arrayListOf(
            Creators(R.drawable.ic_launcher_background),
            Creators(R.drawable.ic_marvel_logo)
        )
    }

    fun getListComics(): ArrayList <Comics>{
        return arrayListOf(
            Comics(R.drawable.ic_launcher_foreground),
            Comics(R.drawable.ic_launcher_foreground),
            Comics(R.drawable.ic_launcher_foreground),
            Comics(R.drawable.ic_marvel_logo)
        )
    }
}