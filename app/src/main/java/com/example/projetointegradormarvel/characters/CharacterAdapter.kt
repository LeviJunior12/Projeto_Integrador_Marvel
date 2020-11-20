package com.example.projetointegradormarvel.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R

class CharacterAdapter(private val listCharacters : ArrayList<Characters>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.imageView.setImageResource(listCharacters[position].image)
    }

    inner class CharacterViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
    }
}