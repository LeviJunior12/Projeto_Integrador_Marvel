package com.example.projetointegradormarvel.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
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

    var characterAdapter: SearchAdapterCharacter? = null
    var comicAdapter: SearchAdapterComics? = null
    var creatorAdapter: SearchAdapterCreators? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)
        btnCharacter.setOnClickListener {
            alterColorCharacter(R.color.marvelRed)
            alterColorComic(R.color.white)
            alterColorCreator(R.color.white)
            callFragCharacter()
        }

        btnComics.setOnClickListener {
            alterColorCharacter(R.color.white)
            alterColorComic(R.color.marvelRed)
            alterColorCreator(R.color.white)
            callFragComic()
        }

        btnCreators.setOnClickListener {
            alterColorCharacter(R.color.white)
            alterColorComic(R.color.white)
            alterColorCreator(R.color.marvelRed)
            callFragCreator()
        }


        val search = findViewById<SearchView>(R.id.text_searchview)

        val recViewCharacter = findViewById<RecyclerView>(R.id.rv_listSearchCharacter)
        val recViewComics = findViewById<RecyclerView>(R.id.rv_listSearchComics)
        val recViewCreator = findViewById<RecyclerView>(R.id.rv_listSearchCreator)


        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                when {
                    characterAdapter?.listCharacterSearchFilter?.contains(query) == true -> {
                        characterAdapter?.filter?.filter(query)
                    }
                    comicAdapter?.listComicSearchFilter?.contains(query) == true -> {

                        comicAdapter?.filter?.filter(query)
                    }
                    comicAdapter?.listComicSearchFilter?.contains(query) == true -> {
                        creatorAdapter?.filter?.filter(query)
                    }
                }

                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {

                characterAdapter?.filter?.filter(query)
                comicAdapter?.filter?.filter(query)
                creatorAdapter?.filter?.filter(query)

                return true
            }

        })

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