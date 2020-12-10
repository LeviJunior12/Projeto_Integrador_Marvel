package com.example.projetointegradormarvel.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharacterAdapter
import com.example.projetointegradormarvel.home.HomeViewModel
import com.example.projetointegradormarvel.webService
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment(), CardClickListener {

    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(webService) as T
            }
        }
        //   TODO: move to List ViewModel?
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        view.rv_list.layoutManager = GridLayoutManager(view.context, 3)
        viewModel.listCharacters.observe(viewLifecycleOwner, {
            rv_list.adapter = CharacterAdapter(it)
        })
        // TODO: Fix Gridlayout in Horizontal Mode

        return view
    }


    override fun onCardClickListener(position: Int) {
        viewModel.listComics.observe(this, {
            val bundle = bundleOf("chave" to it[position])
            findNavController().navigate(R.id.nav_host_fragment, bundle)
        })


        }

    }





//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//    }