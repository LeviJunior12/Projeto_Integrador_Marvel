package com.example.projetointegradormarvel

import android.content.Context
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
    }

    private fun View.hideKeyboard(){
        val i = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        i.hideSoftInputFromWindow(windowToken, 0)
    }

    private fun getView(): View {
        return window.decorView.findViewById(android.R.id.content)
    }
}