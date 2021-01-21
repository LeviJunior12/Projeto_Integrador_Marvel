package com.example.projetointegradormarvel.characters

import androidx.room.*
import com.example.projetointegradormarvel.Thumbnail
import com.example.projetointegradormarvel.comics.Comics
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "characters",indices = arrayOf( Index(value = ["id"], unique = true)))
data class CharactersResults(

    @PrimaryKey val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @Embedded
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,

    // Encontrei esse comando que talvez seja útil para tratamento de imagens,checar depois
    //@Ignore val picture: Bitmap?
    //Imagem copiada em todas as XResults.kt

//    @Embedded
//    val comics: Comics
//    @SerializedName("series") val series : Series,
//    @SerializedName("stories") val stories : Stories,
//    @SerializedName("events") val events : Events,
//    @SerializedName("urls") val urls : List<Urls>
): Serializable