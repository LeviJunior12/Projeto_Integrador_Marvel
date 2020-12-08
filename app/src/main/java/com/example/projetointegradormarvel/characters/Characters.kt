package com.example.projetointegradormarvel.comicsHQgenerica

import com.google.gson.annotations.SerializedName
import java.io.Serializable
class  Personagens {

data class Characters(
    val Title: String,
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: DataComicsTeste,
    val thumbnail: ThumbnailTeste
) : Serializable
data class DataComicsTeste(

    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ResultTeste>
) : Serializable


data class DatesTeste(
    val type: String,
) : Serializable

data class PricesTeste(
    val type: String,
    val price: String
) : Serializable

class ResultTeste(

    val id: Int,
    val title: String,
    val description: String,
    val pageCount: Int,
    val resourceURI: String,
    val dates: List<DatesTeste>,
    val prices: List<PricesTeste>
) : Serializable

data class ThumbnailTeste(
    val path: String,
    val extension: String
) : Serializable


}
