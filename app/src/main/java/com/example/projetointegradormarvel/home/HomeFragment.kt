package com.example.projetointegradormarvel.home

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
import com.example.projetointegradormarvel.DataAdapter
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(webService) as T
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewModel.getCharacters(1)
        viewModel.getComics(1)
        viewModel.getCreators(1)

        view.rv_characters.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listCharacters.observe(viewLifecycleOwner, {
//            rv_characters.adapter = CharacterAdapter(it, this)
            rv_characters.adapter = DataAdapter(it, this)
        })

        view.rv_comics.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listComics.observe(viewLifecycleOwner, {
//            rv_comics.adapter = ComicAdapter(it, this)
            rv_comics.adapter = DataAdapter(it, this)
        })

        view.rv_creators.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listCreators.observe(viewLifecycleOwner, {
//            rv_creators.adapter = CreatorAdapter(it, this)
            rv_creators.adapter = DataAdapter(it, this)
        })

        return view
    }
}