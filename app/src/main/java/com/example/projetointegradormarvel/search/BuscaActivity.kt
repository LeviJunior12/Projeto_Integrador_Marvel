package com.example.projetointegradormarvel.search

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    var rvCharacter: RecyclerView? = null
    var rvComics: RecyclerView? = null
    var rvCreator: RecyclerView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)


        btnCharacters()
        btnComics()
        btnCreators()

        val searchView = findViewById<SearchView>(R.id.text_searchview)

        val list1 = ArrayList<CharactersResults>()
        val list2 = ArrayList<ComicsResults>()
        val list3 = ArrayList<CreatorsResults>()

        val characterAdapter = SearchAdapterCharacter(arrayListOf())
        var comicAdapter = SearchAdapterComics(list2)
        var creatorAdapter = SearchAdapterCreators(list3)

        rvCharacter  = findViewById(R.id.rv_listSearchCharacter)
        rvComics   = findViewById(R.id.rv_listSearchComics)
        rvCreator     = findViewById(R.id.rv_listSearchCreator)

/*        listView = findViewById<FrameLayout>(R.id.flfragSearch) as ListView?
        list = arrayListOf("asdasdadasfassda")*/

        /*list.add(CharactersResults(1, "Character: Amadeus Cho", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(2, "Character: Hulk", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(3, "Character: Luke Cage", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(4, "Character: Ghost River", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(5, "Character: Psylocke", "", "", Thumbnail("", ""), "").name)

        list.add(
            ComicsResults(
                1,
                "Comic: (Amazing Fantasy #15)",
                "",
                1,
                "",
                Thumbnail("", "")
            ).title
        )
        list.add(
            ComicsResults(
                2,
                "Comic: (Incredible Hulk #1)",
                "",
                2,
                "",
                Thumbnail("", "")
            ).title
        )
        list.add(
            ComicsResults(
                3,
                "Comic: (Luke Cage Epic Collection: Retribution)",
                "",
                3,
                "",
                Thumbnail("", "")
            ).title
        )
        list.add(ComicsResults(4, "Comic: (Ghost Rider #4)", "", 4, "", Thumbnail("", "")).title)
        list.add(
            ComicsResults(
                5,
                "Comic: (X-Men: Reload Vol. 2: House of M) ",
                "",
                5,
                "",
                Thumbnail("", "")
            ).title
        )

        list.add(
            CreatorsResults(
                1,
                "Creator: Greg Pak",
                "",
                "",
                "",
                "",
                "",
                Thumbnail("", ""),
                ""
            ).firstName
        )

        list.add(
            CreatorsResults(
                2,
                "Creator: Stan Lee",
                "",
                "",
                "",
                "",
                "",
                Thumbnail("", ""),
                ""
            ).firstName
        )
        list.add(
            CreatorsResults(
                3,
                " Creator: Archie Goodwin",
                "",
                "",
                "",
                "",
                "",
                Thumbnail("", ""),
                ""
            ).firstName
        )
        list.add(
            CreatorsResults(
                4,
                "Creator: Roy Thomas",
                "",
                "",
                "",
                "",
                "",
                Thumbnail("", ""),
                ""
            ).firstName
        )
        list.add(
            CreatorsResults(
                5,
                "Creator: Chris Claremont",
                "",
                "",
                "",
                "",
                "",
                Thumbnail("", ""),
                ""
            ).firstName
        )*/

/*        adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list)
        listView?.adapter = adapter*/

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list1.contains(query)) {
                    comicAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@BuscaActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                comicAdapter.filter.filter(newText)

                return false
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