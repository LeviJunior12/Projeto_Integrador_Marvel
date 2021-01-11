package com.example.projetointegradormarvel.search.modelTESTE

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<ResultModel>,
    @SerializedName("total")
    val total: Int
)