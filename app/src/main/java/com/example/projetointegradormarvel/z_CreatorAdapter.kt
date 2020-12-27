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
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class z_CreatorAdapter(
    private val listCreators: List<CreatorsResults>,
    private val parentFragment: Fragment,
) : RecyclerView.Adapter<z_CreatorAdapter.CreatorViewHolder>() {

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
            listCreators[position].thumbnail.path.replace("http", "https")  + "." + listCreators[position].thumbnail.extension
        Picasso.get().load(imgURL).into(holder.thumbImageView)

        holder.itemView.setOnClickListener {
            val bundle = bundleOf("data" to listCreators[position])
            parentFragment.findNavController().navigate(R.id.action_global_nav_creators, bundle)
        }
    }

    inner class CreatorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val titleTextView: TextView = itemView.tv_recycler_card
    }
}