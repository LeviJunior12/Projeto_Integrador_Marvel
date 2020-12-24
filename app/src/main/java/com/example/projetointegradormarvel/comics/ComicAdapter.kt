package com.example.projetointegradormarvel.comics

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class ComicAdapter(
    private val listComics: List<ComicsResults>, private val click: CardComicsClickListener

) : RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return ComicViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listComics.size
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.titleTextView.text = listComics[position].title

        val imgURL =
            listComics[position].thumbnail.path.replace("http", "https") + "." + listComics[position].thumbnail.extension
        Picasso.get().load(imgURL).into(holder.thumbImageView)

        holder.itemView.setOnClickListener {
            click.onCardComicsClickListener(position)
        }
    }

    inner class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}