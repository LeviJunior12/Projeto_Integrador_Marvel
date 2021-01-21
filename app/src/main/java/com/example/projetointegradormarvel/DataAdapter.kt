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
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.example.projetointegradormarvel.home.HomeFragmentDirections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_card.view.*

class DataAdapter(
    private var adapterDataList: List<Any>,
    private val parentFragment: Fragment,
) : RecyclerView.Adapter<DataAdapter.BaseViewHolder<*>>() {

    companion object {
        private const val TYPE_CHARACTER = 0
        private const val TYPE_COMICS = 1
        private const val TYPE_CREATORS = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return when (viewType) {
            TYPE_CHARACTER -> CharacterViewHolder(view)
            TYPE_COMICS -> ComicViewHolder(view)
            TYPE_CREATORS -> CreatorViewHolder(view)
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is CharacterViewHolder -> holder.bind(element as CharactersResults)
            is ComicViewHolder -> holder.bind(element as ComicsResults)
            is CreatorViewHolder -> holder.bind(element as CreatorsResults)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (adapterDataList[position]) {
            is CharactersResults -> TYPE_CHARACTER
            is ComicsResults -> TYPE_COMICS
            is CreatorsResults -> TYPE_CREATORS
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    override fun getItemCount(): Int {
        return adapterDataList.size
    }

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImageView: ImageView = itemView.iv_recycler_card
        val titleTextView: TextView = itemView.tv_recycler_card

        abstract fun bind(item: T)
    }

    inner class CharacterViewHolder(itemView: View) : BaseViewHolder<CharactersResults>(itemView) {
        override fun bind(item: CharactersResults) {
            val imgURL =
                item.thumbnail.path.replace("http", "https") + "." + item.thumbnail.extension
            Picasso.get().load(imgURL).into(thumbImageView)

            titleTextView.text = item.name
//            itemView.setOnClickListener {
//                parentFragment.findNavController()
//                    .navigate(R.id.action_global_nav_character, bundleOf("data" to item))
//            }
            itemView.setOnClickListener {
                val directions = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item, null, null)
                parentFragment.findNavController().navigate(directions)
            }
        }
    }

    inner class ComicViewHolder(itemView: View) : BaseViewHolder<ComicsResults>(itemView) {
        override fun bind(item: ComicsResults) {
            val imgURL =
                item.thumbnail.path.replace("http", "https") + "." + item.thumbnail.extension
            Picasso.get().load(imgURL).into(thumbImageView)

            titleTextView.text = item.title
            itemView.setOnClickListener {
                parentFragment.findNavController()
                    .navigate(R.id.action_global_nav_comics, bundleOf("data" to item))
            }
        }
    }

    inner class CreatorViewHolder(itemView: View) : BaseViewHolder<CreatorsResults>(itemView) {
        override fun bind(item: CreatorsResults) {
            val imgURL =
                item.thumbnail.path.replace("http", "https") + "." + item.thumbnail.extension
            Picasso.get().load(imgURL).into(thumbImageView)

            titleTextView.text = item.firstName
            itemView.setOnClickListener {
                parentFragment.findNavController()
                    .navigate(R.id.action_global_nav_creators, bundleOf("data" to item))
            }
        }
    }
}
