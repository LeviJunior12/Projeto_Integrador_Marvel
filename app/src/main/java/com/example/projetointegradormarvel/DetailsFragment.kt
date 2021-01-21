package com.example.projetointegradormarvel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.projetointegradormarvel.characters.CharactersResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_character.view.*

class DetailsFragment : Fragment() {
    private val args : DetailsFragmentArgs by navArgs()
    private lateinit var data: CharactersResults

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        data = args.character!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_details, container, false)
        val imgURL =
            data.thumbnail.path.replace("http", "https") + "." + data.thumbnail.extension
        Picasso.get().load(imgURL).into(view.iv_frag_character_image)


        
        view.tv_frag_character_title.text = data.name
        view.tv_frag_character_description.text = data.description

        return view
    }
}