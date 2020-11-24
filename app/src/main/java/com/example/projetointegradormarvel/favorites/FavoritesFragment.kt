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
            Characters(R.drawable.dummy_capitain),
            Characters(R.drawable.dummy_hulk),
            Characters(R.drawable.dummy_widow)
        )
    }

    fun getListCreators(): ArrayList <Creators>{
        return arrayListOf(
            Creators(R.drawable.dummy_spider),
            Creators(R.drawable.dummy_capitain)
        )
    }

    fun getListComics(): ArrayList <Comics>{
        return arrayListOf(
            Comics(R.drawable.dummy_thor),
            Comics(R.drawable.dummy_widow),
            Comics(R.drawable.dummy_spider)
        )
    }
}