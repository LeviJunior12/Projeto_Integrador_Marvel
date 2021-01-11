package com.example.projetointegradormarvel.search.modelTESTE.comicmodel

import com.google.gson.annotations.SerializedName

data class ComicsModel(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemComics>,
    @SerializedName("returned")
    val returned: Int
) {
    class ItemComics(
        @SerializedName("name")
        val name: String,
        @SerializedName("resourceURI")
        val resourceURI: String
    )
}