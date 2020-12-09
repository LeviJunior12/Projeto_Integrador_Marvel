package com.example.projetointegradormarvel.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class CharacterAdapter(
    private val listCharacters: List<CharactersResults>
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        holder.titleTextView.text = listCharacters[position].name

        val imgURL =
            listCharacters[position].thumbnail.path + "." + listCharacters[position].thumbnail.extension
        Picasso.get().load(imgURL).into(holder.thumbImageView)
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}