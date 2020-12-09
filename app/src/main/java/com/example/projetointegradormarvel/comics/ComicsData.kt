package com.example.projetointegradormarvel.comics

import com.google.gson.annotations.SerializedName

data class ComicsData(

    @SerializedName("offset") val offset: Int,
    @SerializedName("limit") val limit: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("count") val count: Int,
    @SerializedName("results") val results: List<ComicsResults>
)