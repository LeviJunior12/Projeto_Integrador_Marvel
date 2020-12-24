package com.example.projetointegradormarvel.creators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class CreatorAdapter(
    private val listCreators: List<CreatorsResults>
) : RecyclerView.Adapter<CreatorAdapter.CreatorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreatorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CreatorViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listCreators.size
    }

    override fun onBindViewHolder(holder: CreatorViewHolder, position: Int) {
        holder.titleTextView.text = listCreators[position].firstName

        val imgURL =
            listCreators[position].thumbnail.path + "." + listCreators[position].thumbnail.extension
        Picasso.get().load(imgURL).into(holder.thumbImageView)
    }

    inner class CreatorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}