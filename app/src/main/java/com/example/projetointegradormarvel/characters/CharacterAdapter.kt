package com.example.projetointegradormarvel.characters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetointegradormarvel.R
import com.squareup.picasso.Picasso

// no val listener, deve chamar o Fragment da classe correspondente e apos isso, ir para o fragment
class CharacterAdapter(val listCharacters: ArrayList<Personagens.ResultTeste>, val listener: CharacterFragment) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    //Cria a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card, parent, false)
        return CharacterViewHolder(view)
    }

    //Lista HQs e joga a imagem e texto no Recycler Card
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val hq = listCharacters[position]

        holder.TextView.text = hq.title
        Picasso.get().load(hq.thumbnail.path.replace("http://", "https://")
                +"."+ hq.thumbnail.extension)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            listener.hqClick(position)
        }
    }

    //Função do click
    interface onClickHQ{
        fun hqClick(position: Int)
    }

    //Pega o tamanho da lista
    override fun getItemCount(): Int {
        return listCharacters.size
    }


    //Classe pra pegar os valores que serão substituídos
    inner class CharacterViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.iv_recycler_card)
        val TextView: TextView = itemView.findViewById(R.id.tv_recycler_card)
    }
}