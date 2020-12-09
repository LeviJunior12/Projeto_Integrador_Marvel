package com.example.projetointegradormarvel.characters

import Results
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso

class CharacterAdapter(private val listCharacters : ArrayList<Results>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCharacters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
//        holder.imageView.setImageResource(listCharacters[position].image)

        val pathImage = "${listCharacters[position].thumbnail.path.replace("http", "https")}.${listCharacters[position].thumbnail.extension}"

        Picasso.get().load(pathImage).into(holder.imageView)
        holder.textView.text = listCharacters[position].name
    }

    inner class CharacterViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val textView: TextView = itemView.findViewById(R.id.tv_recycler_card)
    }
}