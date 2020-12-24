package com.example.projetointegradormarvel.characters

import com.google.gson.annotations.SerializedName

class CharactersData(

    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<CharactersResults>
)