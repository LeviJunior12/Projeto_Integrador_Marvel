package com.example.projetointegradormarvel.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.characters.Characters

class ListFragment : Fragment() {

    private var listItems = ArrayList<Characters>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        listItems = getListItems()

        view.findViewById<RecyclerView>(R.id.rv_list).apply {
            layoutManager = GridLayoutManager(view.context, 3)
            adapter = CharacterAdapter(listItems)
        }
        // TODO: Fix Gridlayout in Horizontal Mode
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }

    fun getListItems(): ArrayList <Characters>{
        return arrayListOf(
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_background),
            Characters(R.drawable.ic_marvel_logo),
            Characters(R.drawable.ic_launcher_background),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_launcher_background),
            Characters(R.drawable.ic_launcher_foreground),
            Characters(R.drawable.ic_marvel_logo)
        )
    }
}