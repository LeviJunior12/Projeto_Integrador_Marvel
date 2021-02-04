package com.example.projetointegradormarvel.characters

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projetointegradormarvel.Thumbnail
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "characters")
data class CharactersResults(

    @PrimaryKey
    val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @Embedded
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
//    @Embedded
//    val comics: Comics
//    @SerializedName("series") val series : Series,
//    @SerializedName("stories") val stories : Stories,
//    @SerializedName("events") val events : Events,
//    @SerializedName("urls") val urls : List<Urls>
): Serializable