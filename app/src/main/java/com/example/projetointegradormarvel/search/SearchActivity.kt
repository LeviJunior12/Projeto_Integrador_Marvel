package com.example.projetointegradormarvel.search

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.projetointegradormarvel.R
import kotlinx.android.synthetic.main.layout_main_buscar.*

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btn_characterSearch.setOnClickListener {

        }

        btn_comicsSearch.setOnClickListener {

        }

        btn_creatorsSearch.setOnClickListener {

        }

        getView()
    }

    private fun getView(): View {
        return window.decorView.findViewById(android.R.id.content)
    }
}