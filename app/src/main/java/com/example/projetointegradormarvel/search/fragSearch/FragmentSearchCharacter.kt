package com.example.projetointegradormarvel.search.fragSearch

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
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.home.HomeViewModel
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCharacter
import com.example.projetointegradormarvel.ui.main.PlaceholderFragment
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_search_character.*
import kotlinx.android.synthetic.main.fragment_search_character.view.*


class FragmentSearchCharacter : Fragment() {
    @Suppress("UNCHECKED_CAST")
    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(webService) as T
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search_character, container, false)

        viewModel.getCharacterSearch()

        view.rv_listSearchCharacter.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.listCharacters.observe(viewLifecycleOwner, {
            rv_listSearchCharacter.adapter = SearchAdapterCharacter(it as ArrayList<CharactersResults>)
        })

        return view

    }

//    companion object {
//        fun newInstance() = FragmentSearchCharacter()
//    }

    companion object {
        private const val ARG_QUERY = "query_string"

        @JvmStatic
        fun newInstance(queryArg: String): FragmentSearchCharacter {
            return FragmentSearchCharacter().apply {
                arguments = Bundle().apply {
                    putString(ARG_QUERY, queryArg)
                }
            }
        }
    }
}