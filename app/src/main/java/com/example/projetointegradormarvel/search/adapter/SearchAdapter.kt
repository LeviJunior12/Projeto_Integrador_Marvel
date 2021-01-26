package com.example.projetointegradormarvel.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.example.projetointegradormarvel.characters.CharactersResults
import com.example.projetointegradormarvel.comics.ComicsResults
import com.example.projetointegradormarvel.creators.CreatorsResults
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_search.view.*
import java.util.*
import kotlin.collections.ArrayList

class SearchAdapterCharacter(
    private var listCharacterSearch: List<CharactersResults>,
) : RecyclerView.Adapter<SearchAdapterCharacter.holderCharacter>(), Filterable { //CHARACTERS

    lateinit var listCharacterSearchFilter: List<CharactersResults>

/*    fun setData(listCharacter: List<CharactersResults>) {
        this.listCharacterSearch = listCharacter
        this.listCharacterSearchFilter = listCharacter
        notifyDataSetChanged()
    }*/


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): holderCharacter {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        return holderCharacter(view)
    }

    override fun onBindViewHolder(holder: holderCharacter, position: Int) {

        val itemHolder = listCharacterSearch[position]

        val imgURL = listCharacterSearch[position].thumbnail.path.replace(
            "http", "https"
        ) + "." + listCharacterSearch[position].thumbnail.extension

        Picasso.get().load(imgURL).into(holder.img)

        holder.tipo.text = itemHolder.id.toString()
        holder.nome.text = listCharacterSearch[position].name


        ///EVENTO DE CLICK DENTRO DA RECYCLERVIEW NA SEARCH CHARACTER
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount() = listCharacterSearch.size

    inner class holderCharacter(item: View) : RecyclerView.ViewHolder(item) {
        val img: ImageView = item.findViewById(R.id.item_imagem)
        val tipo: TextView = item.tv_tipo
        val nome: TextView = item.tv_item_busca_nome
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            var list = ArrayList<CharactersResults>()

            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val results = FilterResults()

                if (constraint == null || constraint.isEmpty()) {
                    results.values = list
                    results.count = list.size
                } else {
                    getBaseList().filterTo(list) {
                        it.name.toLowerCase(Locale.getDefault()).contains(constraint)
                    }

                    results.values = list
                    results.count = list.size

                }
                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                setList(results?.values as List<CharactersResults>)
                notifyDataSetChanged()

            }
        }
    }


    fun getBaseList(): List<CharactersResults> = listCharacterSearch

    fun setList(list: List<CharactersResults>) {
        this.listCharacterSearch = list as ArrayList<CharactersResults>
    }

}


class SearchAdapterComics(
    private var listComicSearch: List<ComicsResults>,
) : RecyclerView.Adapter<SearchAdapterComics.holderComics>(), Filterable { //COMICS

    lateinit var listComicSearchFilter: ArrayList<ComicsResults>
    private val parentFragment: Fragment
        get() {
            TODO()
        }


/*    fun setData(listComic: ArrayList<ComicsResults>) {
        this.listComicSearch = listComic
        this.listComicSearchFilter = listComic
        notifyDataSetChanged()
    }*/


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): holderComics {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

        return holderComics(view)

    }

    override fun onBindViewHolder(holder: holderComics, position: Int) {

        val itemHolder = listComicSearch[position]

        val imgURL = listComicSearch[position].thumbnail.path.replace(
            "http", "https"
        ) + "." + listComicSearch[position].thumbnail.extension

        Picasso.get().load(imgURL).into(holder.img)

        holder.tipo.text = itemHolder.id.toString()
        holder.nome.text = listComicSearch[position].title


        ///EVENTO DE CLICK DENTRO DA RECYCLERVIEW NA SEARCH COMIC
        holder.itemView.setOnClickListener {


        }

    }

    override fun getItemCount() = listComicSearch.size

    inner class holderComics(item: View) : RecyclerView.ViewHolder(item) {
        val img: ImageView = item.findViewById(R.id.item_imagem)
        val tipo: TextView = item.tv_tipo
        val nome: TextView = item.tv_item_busca_nome

    }

    override fun getFilter(): Filter {
        return object : Filter() {

            var list = ArrayList<ComicsResults>()

            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val results = FilterResults()

                if (constraint == null || constraint.isEmpty()) {
                    results.values = list
                    results.count = list.size
                } else {
                    getBaseList().filterTo(list) {
                        it.title.toLowerCase(Locale.getDefault()).contains(constraint)
                    }

                    results.values = list
                    results.count = list.size

                }
                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                setList(results?.values as List<ComicsResults>)
                notifyDataSetChanged()

            }
        }
    }

    fun getBaseList(): List<ComicsResults> = listComicSearch

    fun setList(list: List<ComicsResults>) {
        this.listComicSearch = list as ArrayList<ComicsResults>
    }

}

class SearchAdapterCreators(
    private var listCreatorSearch: List<CreatorsResults>,
) : RecyclerView.Adapter<SearchAdapterCreators.holderCreator>(), Filterable {
    // Creators

    lateinit var listCreatorSearchFilter: ArrayList<CreatorsResults>
    private val parentFragment: Fragment
        get() {
            TODO()
        }


/*
    fun setData(listCharacter: List<CreatorsResults>) {
        this.listCreatorSearch = listCharacter
        this.listCreatorSearchFilter = listCharacter
        notifyDataSetChanged()
    }
*/

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): holderCreator {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

        return holderCreator(view)
    }

    override fun onBindViewHolder(holder: holderCreator, position: Int) {
        val itemHolder = listCreatorSearch[position]

        val imgURL = listCreatorSearch[position].thumbnail.path.replace(
            "http", "https"
        ) + "." + listCreatorSearch[position].thumbnail.extension

        Picasso.get().load(imgURL).into(holder.img)

        holder.tipo.text = itemHolder.id.toString()
        holder.nome.text = listCreatorSearch[position].firstName

        ///EVENTO DE CLICK DENTRO DA RECYCLERVIEW NA SEARCH CREATOR
        holder.itemView.setOnClickListener {

        }
    }

    override fun getItemCount() = listCreatorSearch.size

    inner class holderCreator(item: View) : RecyclerView.ViewHolder(item) {
        val img: ImageView = item.findViewById(R.id.item_imagem)
        val tipo: TextView = item.tv_tipo
        val nome: TextView = item.tv_item_busca_nome
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            var list = ArrayList<CreatorsResults>()

            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val results = Filter.FilterResults()

                if (constraint == null || constraint.isEmpty()) {
                    results.values = list
                    results.count = list.size
                } else {
                    getBaseList().filterTo(list) {
                        it.firstName.toLowerCase(Locale.getDefault()).contains(constraint)
                    }

                    results.values = list
                    results.count = list.size

                }
                return results
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                setList(results?.values as List<CreatorsResults>)
                notifyDataSetChanged()

            }
        }
    }

    fun getBaseList(): List<CreatorsResults> = listCreatorSearch

    fun setList(list: List<CreatorsResults>) {
        this.listCreatorSearch = list as ArrayList<CreatorsResults>
    }

}