package com.example.projetointegradormarvel

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.InputDevice
import android.view.View
import android.view.inputmethod.InputMethodManager

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        getView()
        handleIntent(intent)
    }

    private fun View.hideKeyboard(){
        val i = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        i.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun getView(): View {
        return window.decorView.findViewById(android.R.id.content)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //
            // TODO: use the query to search data
            //
        }
    }
}