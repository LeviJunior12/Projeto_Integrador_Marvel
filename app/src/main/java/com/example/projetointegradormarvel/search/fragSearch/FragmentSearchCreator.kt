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
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.home.HomeViewModel
import com.example.projetointegradormarvel.search.adapter.SearchAdapterCreators
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_search_creator.*
import kotlinx.android.synthetic.main.fragment_search_creator.view.*

class FragmentSearchCreator : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_search_creator, container, false)

        viewModel.getCreatorSearch()

        view.rv_listSearchCreator.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.listCreators.observe(viewLifecycleOwner, {
            rv_listSearchCreator.adapter = SearchAdapterCreators(it as ArrayList<CreatorsResults>)
        })

        return  view

    }

    companion object {
        fun newInstance() = FragmentSearchCreator()
    }


}