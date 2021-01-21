package com.example.projetointegradormarvel.creators

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projetointegradormarvel.Thumbnail
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "creators")
data class CreatorsResults(

    @PrimaryKey
    val id: Int,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("middleName") val middleName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("suffix") val suffix: String,
    @SerializedName("fullName") val fullName: String,
    @SerializedName("modified") val modified: String,
    @Embedded
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String
//    @SerializedName("comics") val comics : Comics,
//    @SerializedName("series") val series : Series,
//    @SerializedName("stories") val stories : Stories,
//    @SerializedName("events") val events : Events,
//    @SerializedName("urls") val urls : List<Urls>

): Serializable
