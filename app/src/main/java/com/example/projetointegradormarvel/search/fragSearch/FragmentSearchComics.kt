package com.example.projetointegradormarvel.search.fragSearch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.api.webService
import com.example.projetointegradormarvel.home.HomeViewModel
import com.example.projetointegradormarvel.search.adapter.SearchAdapterComics
import kotlinx.android.synthetic.main.fragment_search_comics.*
import kotlinx.android.synthetic.main.fragment_search_comics.view.*

class FragmentSearchComics : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_search_comics, container, false)

        viewModel.getComicSearch()

        view.rv_listSearchComics.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.listComics.observe(viewLifecycleOwner, {
            rv_listSearchComics.adapter = SearchAdapterComics(it, this)
        })

        return view
    }

    companion object {
        fun newInstance() = FragmentSearchComics()
    }




}