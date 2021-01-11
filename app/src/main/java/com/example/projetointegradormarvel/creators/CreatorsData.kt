package com.example.projetointegradormarvel.creators

import com.google.gson.annotations.SerializedName

class CreatorsData(

    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<CreatorsResults>
)