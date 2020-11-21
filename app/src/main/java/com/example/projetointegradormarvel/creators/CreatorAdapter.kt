package com.example.projetointegradormarvel.creators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R

class CreatorAdapter (private val listCreators : ArrayList<Creators>) : RecyclerView.Adapter<CreatorAdapter.CreatorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CreatorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCreators.size
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        holder.imageView.setImageResource(listCreators[position].image)
    }

    inner class CreatorViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
    }
}