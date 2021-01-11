package com.example.projetointegradormarvel.search.modelTESTE.storiemodel

import com.google.gson.annotations.SerializedName

data class StoriesModel(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemStories>,
    @SerializedName("returned")
    val returned: Int
) {
    class ItemStories(
        @SerializedName("name")
        val name: String,
        @SerializedName("resourceURI")
        val resourceURI: String,
        @SerializedName("type")
        val type: String
    )
}
