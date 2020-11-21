package com.example.projetointegradormarvel.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.characters.Characters
import com.example.projetointegradormarvel.comics.ComicAdapter
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.creators.CreatorAdapter
import com.example.projetointegradormarvel.creators.Creators
import com.example.projetointegradormarvel.favorites.FavoritesViewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var listCharacters = ArrayList<Characters>()
    private var listCreators= ArrayList<Creators>()
    private var listComics = ArrayList<Comics>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view

//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        val textView: TextView = view.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listCharacters = getListCharacters()
        listCreators = getListCreators()
        listComics = getListComics()

        view.findViewById<RecyclerView>(R.id.rv_characters).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CharacterAdapter(listCharacters)
        }

        view.findViewById<RecyclerView>(R.id.rv_creators).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CreatorAdapter(listCreators)
        }

        view.findViewById<RecyclerView>(R.id.rv_comics).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = ComicAdapter(listComics)
        }
    }

    // Gera dummies

    fun getListCharacters(): ArrayList <Characters>{
        return arrayListOf(
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_background),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_marvel_logo)
        )
    }

    fun getListCreators(): ArrayList <Creators>{
        return arrayListOf(
            Creators(R.drawable.ic_marvel_logo),
            Creators(R.drawable.ic_launcher_background),
            Creators(R.drawable.ic_marvel_logo),
            Creators(R.drawable.ic_launcher_foreground),
            Creators(R.drawable.ic_launcher_foreground),
            Creators(R.drawable.ic_marvel_logo)
        )
    }

    fun getListComics(): ArrayList <Comics>{
        return arrayListOf(
            Comics(R.drawable.ic_launcher_foreground),
            Comics(R.drawable.ic_marvel_logo),
            Comics(R.drawable.ic_marvel_logo),
            Comics(R.drawable.ic_launcher_background),
            Comics(R.drawable.ic_launcher_foreground),
            Comics(R.drawable.ic_marvel_logo)
        )
    }
}