package com.example.projetointegradormarvel.search.modelTESTE.url

import com.google.gson.annotations.SerializedName

data class UrlModel(
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)
