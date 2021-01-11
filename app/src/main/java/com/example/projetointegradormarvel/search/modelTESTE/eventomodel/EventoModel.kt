package com.example.projetointegradormarvel.search.modelTESTE.eventomodel


import com.google.gson.annotations.SerializedName

data class EventoModel(
    @SerializedName("available")
    val available: Int,
    @SerializedName("collectionURI")
    val collectionURI: String,
    @SerializedName("items")
    val items: List<ItemEvents>,
    @SerializedName("returned")
    val returned: Int
) {
    class ItemEvents(
        @SerializedName("name")
        val name: String,
        @SerializedName("resourceURI")
        val resourceURI: String
    )
}
