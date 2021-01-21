package com.example.projetointegradormarvel.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCharacter
import com.example.projetointegradormarvel.search.adapter.SearchAdapterComics
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCreators
import com.example.projetointegradormarvel.search.fragSearch.FragmentSearchCharacter
import com.example.projetointegradormarvel.search.fragSearch.FragmentSearchComics
import com.example.projetointegradormarvel.search.fragSearch.FragmentSearchCreator
import kotlinx.android.synthetic.main.activity_busca.*
import kotlinx.android.synthetic.main.tab_character.*
import kotlinx.android.synthetic.main.tab_comics.*
import kotlinx.android.synthetic.main.tab_creators.*

class BuscaActivity : AppCompatActivity() {

    var list = ArrayList<CharactersResults>()
    var list2 = ArrayList<ComicsResults>()
    var list3 = ArrayList<CreatorsResults>()

    var characterAdapter = SearchAdapterCharacter(list)
    var comicAdapter = SearchAdapterComics(list2)
    var creatorAdapter = SearchAdapterCreators(list3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)




        btnCharacters()
        btnComics()
        btnCreators()

        val search: SearchView = findViewById(R.id.text_searchview)

/*        val rvCharacter: RecyclerView? = findViewById(R.id.rv_listSearchCharacter)
        val rvComics: RecyclerView = findViewById(R.id.rv_listSearchComics)
        val rvCreator: RecyclerView = findViewById(R.id.rv_listSearchCreator)*/


        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                characterAdapter.filter.filter(query)
//
//                 when {
//                     rvCharacter.contains(query) -> {
//                         characterAdapter.filter.filter(query)
//
//                     }
//                     rvCreator.contains(query) -> {
//                         comicAdapter.filter.filter(query)
//                     }
//                     rvComics.contains(query) -> {
//                         creatorAdapter.filter.filter(query)
//
//                     }
//                 }
                Log.i("BUSCA AAAAAAAAAAAA", "OnQUERYTEXT ${query}")

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {

                Log.i("ALTERA AAAAAAAAAAA", "OnQUERYCHANGE ${query}")
                characterAdapter.filter.filter(query)
                comicAdapter.filter.filter(query)
                creatorAdapter.filter.filter(query)

                return true
            }

        })
    }

    private fun btnCharacters() {
        btnCharacter.setOnClickListener {
            alterColorCharacter(R.color.marvelRed)
            alterColorComic(R.color.white)
            alterColorCreator(R.color.white)
            callFragCharacter()
        }
    }

    private fun btnComics() {
        btnComics.setOnClickListener {
            alterColorCharacter(R.color.white)
            alterColorComic(R.color.marvelRed)
            alterColorCreator(R.color.white)
            callFragComic()
        }
    }

    private fun btnCreators() {
        btnCreators.setOnClickListener {
            alterColorCharacter(R.color.white)
            alterColorComic(R.color.white)
            alterColorCreator(R.color.marvelRed)
            callFragCreator()
        }
    }

    private fun alterColorCharacter(idCor: Int) {
        llCharacter.setBackgroundColor(ContextCompat.getColor(this, idCor))
        tvTabCharacter.setTextColor(ContextCompat.getColor(this, idCor))
    }

    private fun callFragCharacter() {
        val frag = FragmentSearchCharacter.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragSearch, frag)
            commit()
        }

    }

    private fun alterColorComic(idCor: Int) {
        llComics.setBackgroundColor(ContextCompat.getColor(this, idCor))
        tvTabComics.setTextColor(ContextCompat.getColor(this, idCor))
    }

    private fun callFragComic() {
        val frag = FragmentSearchComics.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragSearch, frag)
            commit()
        }
    }

    private fun alterColorCreator(idCor: Int) {
        llCreator.setBackgroundColor(ContextCompat.getColor(this, idCor))
        tvTabCreators.setTextColor(ContextCompat.getColor(this, idCor))
    }

    private fun callFragCreator() {
        val frag = FragmentSearchCreator.newInstance()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragSearch, frag)
            commit()
        }
    }


}