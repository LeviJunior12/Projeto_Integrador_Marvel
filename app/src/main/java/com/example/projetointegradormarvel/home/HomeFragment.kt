package com.example.projetointegradormarvel.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.comics.ComicAdapter
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.comicsHQgenerica.Personagens
import com.example.projetointegradormarvel.creators.CreatorAdapter
import com.example.projetointegradormarvel.creators.Creators

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private var listCharacters = ArrayList<Personagens.Characters>()
    private var listCreators= ArrayList<Creators>()
    private var listComics = ArrayList<Comics>()

    private lateinit var adapterHQ: CharacterAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var listCharacters = ArrayList<Personagens.Characters>()

        val view = inflater.inflate(R.layout.fragment_home, container, false)

//        listCharacters = getListCharacters()
//        listCreators = getListCreators()
//        listComics = getListComics()

        view.findViewById<RecyclerView>(R.id.rv_characters).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CharacterAdapter(listCharacters,this)
        }

        view.findViewById<RecyclerView>(R.id.rv_creators).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = CreatorAdapter(listCreators)
        }

        view.findViewById<RecyclerView>(R.id.rv_comics).apply {
            layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
            adapter = ComicAdapter(listComics)
        }
        return view

//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        val textView: TextView = view.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        TODO: Use the ViewModel
//    }

//    fun getListCharacters(): ArrayList <Characters>{
//        return arrayListOf(
//            Characters(R.drawable.dummy_capitain),
//            Characters(R.drawable.dummy_hulk),
//            Characters(R.drawable.dummy_panther),
//            Characters(R.drawable.dummy_spider),
//            Characters(R.drawable.dummy_thor),
//            Characters(R.drawable.dummy_widow)
//        )
//    }
//
//    fun getListCreators(): ArrayList <Creators>{
//        return arrayListOf(
//            Creators(R.drawable.dummy_spider),
//            Creators(R.drawable.dummy_thor),
//            Creators(R.drawable.dummy_widow),
//            Creators(R.drawable.dummy_hulk),
//            Creators(R.drawable.dummy_panther),
//            Creators(R.drawable.dummy_capitain)
//        )
//    }
//
//    fun getListComics(): ArrayList <Comics>{
//        return arrayListOf(
//            Comics(R.drawable.dummy_thor),
//            Comics(R.drawable.dummy_widow),
//            Comics(R.drawable.dummy_hulk),
//            Comics(R.drawable.dummy_panther),
//            Comics(R.drawable.dummy_capitain),
//            Comics(R.drawable.dummy_spider)
//        )
//    }
}