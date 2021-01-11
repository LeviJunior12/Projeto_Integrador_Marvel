package com.example.projetointegradormarvel.search.modelTESTE.seriemodel

import com.google.gson.annotations.SerializedName

data class SeriesModel(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemSeries>,
    @SerializedName("returned")
    val returned: Int
){
    class ItemSeries(
        @SerializedName("name")
        val name: String,
        @SerializedName("resourceURI")
        val resourceURI: String
    )
}
