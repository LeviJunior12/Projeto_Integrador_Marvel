package com.example.projetointegradormarvel.search

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.Thumbnail
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCharacter
import com.example.projetointegradormarvel.search.adapter.SearchAdapterComics
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCreators
import kotlinx.android.synthetic.main.activity_busca.*
import kotlinx.android.synthetic.main.tab_character.*
import kotlinx.android.synthetic.main.tab_comics.*
import kotlinx.android.synthetic.main.tab_creators.*


class BuscaActivity : AppCompatActivity() {

    var list1 = ArrayList<CharactersResults>()
    var list2 = ArrayList<ComicsResults>()
    var list3 = ArrayList<CreatorsResults>()

    var characterAdapter = SearchAdapterCharacter(list1)
    var comicAdapter = SearchAdapterComics(list2)
    var creatorAdapter = SearchAdapterCreators(list3)

    var searchView: SearchView? = null
    var listView: ListView? = null
    lateinit var list: ArrayList<String>
    var adapter: ArrayAdapter<*>? = null
//    var fragCharacter: SearchAdapterCharacter =

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca)

        searchView = findViewById<View>(R.id.text_searchview) as SearchView?
        listView = findViewById<View>(R.id.list_search) as ListView?
        list = arrayListOf()

        list.add(CharactersResults(1, "Character: Amadeus Cho", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(2, "Character: Hulk", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(3, "Character: Luke Cage", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(4, "Character: Ghost River", "", "", Thumbnail("", ""), "").name)
        list.add(CharactersResults(5, "Character: Psylocke", "", "", Thumbnail("", ""), "").name)

        list.add(ComicsResults(1, "Comic: (Amazing Fantasy #15)", "", 1, "", Thumbnail("", "")).title)
        list.add(ComicsResults(2, "Comic: (Incredible Hulk #1)", "", 2, "", Thumbnail("", "")).title)
        list.add(ComicsResults(3, "Comic: (Luke Cage Epic Collection: Retribution)", "", 3, "", Thumbnail("", "")).title)
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

        list.add(CreatorsResults(1, "Creator: Greg Pak", "", "", "", "", "", Thumbnail("", ""), "").firstName)

        list.add(CreatorsResults(2, "Creator: Stan Lee", "", "", "", "", "", Thumbnail("", ""), "").firstName)
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
        )

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list)
        listView?.adapter = adapter
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (list.contains(query)) {
                    adapter?.filter?.filter(query)
                } else {
                    Toast.makeText(this@BuscaActivity, "No Match found", Toast.LENGTH_LONG).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                (adapter as ArrayAdapter<*>).filter.filter(newText)
                return false
            }
        })
    }
}