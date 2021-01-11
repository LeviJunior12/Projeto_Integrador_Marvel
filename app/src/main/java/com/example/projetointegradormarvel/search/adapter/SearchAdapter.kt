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

class SearchAdapterCharacter(private var listCharacterSearch: List<CharactersResults>,
                    private val parentFragment: Fragment
) : RecyclerView.Adapter<SearchAdapterCharacter.holderCharacter>(), Filterable { //CHARACTERS


    lateinit var listCharacterSearchFilter: List<CharactersResults>

    fun setData(listCharacter: List<CharactersResults>) {
        this.listCharacterSearch = listCharacter
        this.listCharacterSearchFilter = listCharacter
        notifyDataSetChanged()
    }


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
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (charSequence == null || charSequence.isEmpty()) {
                    filterResults.count = listCharacterSearchFilter.size
                    filterResults.values = listCharacterSearchFilter

                }
                else{
                    val searchChar = charSequence.toString().toLowerCase(Locale.ROOT)

                    val listCharacter = ArrayList<CharactersResults>()

                    for (item in listCharacterSearchFilter){
                        if(item.name.contains(searchChar) || item.id.toString().contains(searchChar)){
                            listCharacter.add(item)
                        }
                    }

                    filterResults.count =  listCharacter.size
                    filterResults.values = listCharacter
                }

                return filterResults

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listCharacterSearch = results?.values as List<CharactersResults>
                notifyDataSetChanged()

            }

        }
    }

}

class SearchAdapterComics(
    private var listComicSearch: List<ComicsResults>,
    private val parentFragment: Fragment
) : RecyclerView.Adapter<SearchAdapterComics.holderComics>(), Filterable { //COMICS

    lateinit var listComicSearchFilter: List<ComicsResults>



    fun setData(listComic: ArrayList<ComicsResults>) {
        this.listComicSearch = listComic
        this.listComicSearchFilter = listComic
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): holderComics {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

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
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (charSequence == null || charSequence.length < 0) {
                    filterResults.count = listComicSearchFilter.size
                    filterResults.values = listComicSearchFilter

                }
                else{
                    val searchChar = charSequence.toString().toLowerCase(Locale.ROOT)

                    val listComics = ArrayList<ComicsResults>()

                    for (item in listComicSearchFilter){
                        if(item.title.contains(searchChar) || item.id.toString().contains(searchChar)){
                            listComics.add(item)
                        }
                    }

                    filterResults.count =  listComics.size
                    filterResults.values = listComics
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                listComicSearch = results!!.values as List<ComicsResults>
                notifyDataSetChanged()
            }

        }
    }
}

class SearchAdapterCreators(
    private var listCreatorSearch: List<CreatorsResults>,
    private val parentFragment: Fragment,
) : RecyclerView.Adapter<SearchAdapterCreators.holderCreator>(), Filterable {
    // Creators

    lateinit var listCreatorSearchFilter: List<CreatorsResults>

    fun setData(listCharacter: List<CreatorsResults>) {
        this.listCreatorSearch = listCharacter
        this.listCreatorSearchFilter = listCharacter
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): holderCreator {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)

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
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()

                if (charSequence == null || charSequence.length < 0) {
                    filterResults.count = listCreatorSearchFilter.size
                    filterResults.values = listCreatorSearch

                }
                else{
                    val searchChar = charSequence.toString().toLowerCase(Locale.ROOT)

                    val listCharacter = ArrayList<CreatorsResults>()

                    for (item in listCreatorSearchFilter){
                        if(item.id.toString().contains(searchChar) || item.firstName.contains(searchChar)){
                            listCharacter.add(item)
                        }
                    }

                    filterResults.count =  listCharacter.size
                    filterResults.values = listCharacter
                }

                return filterResults

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                listCreatorSearch = results?.values as List<CreatorsResults>
                notifyDataSetChanged()
            }

        }
    }

}