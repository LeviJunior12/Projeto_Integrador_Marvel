package com.example.projetointegradormarvel.search.modelTESTE.thumbnail

import com.google.gson.annotations.SerializedName

data class ThumbnailModel(
    @SerializedName("extension")
    val extension: String,
    @SerializedName("path")
    val path: String
)
