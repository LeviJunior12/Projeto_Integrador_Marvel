package com.example.projetointegradormarvel.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.creators.CardCreatorsClickListener
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.comics.ComicAdapter
import com.example.projetointegradormarvel.creators.CreatorAdapter
import kotlinx.android.synthetic.main.fragment_home.*

import androidx.navigation.fragment.findNavController
import com.example.projetointegradormarvel.characters.CardCharacterClickListener
import com.example.projetointegradormarvel.comics.CardComicsClickListener
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment(), CardCreatorsClickListener, CardCharacterClickListener, CardComicsClickListener {
    companion object {
        fun newInstance() = HomeFragment()
    }

    @Suppress("UNCHECKED_CAST")
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
            rv_characters.adapter = CharacterAdapter(it, this)
        })

        view.rv_comics.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listComics.observe(viewLifecycleOwner, {
            rv_comics.adapter = ComicAdapter(it, this)
        })

        view.rv_creators.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)
        viewModel.listCreators.observe(viewLifecycleOwner, {
            rv_creators.adapter = CreatorAdapter(it, this)
        })

        return view
    }

    override fun onCardCreatorsClickListener(position: Int) {

        viewModel.listCreators.observe(this, {
            val data = it[position]

            val bundle = bundleOf("data" to data)
            findNavController().navigate(R.id.nav_creators, bundle)
        })
    }

    override fun onCardCharacterClickListener(position: Int) {
        viewModel.listCharacters.observe(this, {

            val data = it[position]

            val bundle = bundleOf("data" to data)
            findNavController().navigate(R.id.nav_character, bundle)
        })
    }

    override fun onCardComicsClickListener(position: Int) {
        viewModel.listComics.observe(this, {
            val data = it[position]

            val bundle = bundleOf("data" to data)
            findNavController().navigate(R.id.nav_comics, bundle)
        })
    }
}