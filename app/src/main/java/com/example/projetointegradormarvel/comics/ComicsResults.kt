package com.example.projetointegradormarvel.comics

import com.example.projetointegradormarvel.Thumbnail
import com.google.gson.annotations.SerializedName

data class ComicsResults(

    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail
)