package com.example.projetointegradormarvel.search

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projetointegradormarvel.R

//configurar a list generica pra receber o recyclerview
class SearchFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_search, container, false)

        return view
    }

    companion object {
       fun newInstance() = SearchFragment()
    }
}