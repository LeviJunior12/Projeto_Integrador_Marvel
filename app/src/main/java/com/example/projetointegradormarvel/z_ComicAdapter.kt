package com.example.projetointegradormarvel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.comics.ComicsResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class z_ComicAdapter(
    private val listComics: List<ComicsResults>,
    private val parentFragment: Fragment,
) : RecyclerView.Adapter<z_ComicAdapter.ComicViewHolder>() {

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
            val bundle = bundleOf("data" to listComics[position])
            parentFragment.findNavController().navigate(R.id.action_global_nav_comics, bundle)
        }
    }

    inner class ComicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}