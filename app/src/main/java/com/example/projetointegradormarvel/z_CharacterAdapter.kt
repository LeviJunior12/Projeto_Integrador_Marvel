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
import com.example.projetointegradormarvel.characters.CharactersResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class z_CharacterAdapter(
    private val listCharacters: List<CharactersResults>,
    private val parentFragment: Fragment,
) : RecyclerView.Adapter<z_CharacterAdapter.CharacterViewHolder>() {

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
            listCharacters[position].thumbnail.path.replace("http", "https") + "." + listCharacters[position].thumbnail.extension
        Picasso.get().load(imgURL).into(holder.thumbImageView)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("data" to listCharacters[position])
            parentFragment.findNavController().navigate(R.id.action_global_nav_character, bundle)
        }
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}