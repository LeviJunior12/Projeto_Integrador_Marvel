package com.example.projetointegradormarvel.search.modelTESTE

import com.google.gson.annotations.SerializedName


data class CharacterModel(
    @SerializedName("attributionHTML")
    val attributionHTML: String,
    @SerializedName("attributionText")
    val attributionText: String,
    @SerializedName("code")
    val code: Int,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("data")
    val `data`: DataModel,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("status")
    val status: String
)


