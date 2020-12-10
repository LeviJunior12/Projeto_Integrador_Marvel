package com.example.projetointegradormarvel.characters

import com.example.projetointegradormarvel.Thumbnail
import com.example.projetointegradormarvel.comics.Comics
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class CharactersResults(

    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comics: Comics
//    @SerializedName("series") val series : Series,
//    @SerializedName("stories") val stories : Stories,
//    @SerializedName("events") val events : Events,
//    @SerializedName("urls") val urls : List<Urls>
): Serializable