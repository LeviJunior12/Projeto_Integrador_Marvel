package com.example.projetointegradormarvel.search.modelTESTE

import com.example.projetointegradormarvel.search.modelTESTE.comicmodel.ComicsModel
import com.example.projetointegradormarvel.search.modelTESTE.eventomodel.EventoModel
import com.example.projetointegradormarvel.search.modelTESTE.seriemodel.SeriesModel
import com.example.projetointegradormarvel.search.modelTESTE.storiemodel.StoriesModel
import com.example.projetointegradormarvel.search.modelTESTE.thumbnail.ThumbnailModel
import com.example.projetointegradormarvel.search.modelTESTE.url.UrlModel
import com.google.gson.annotations.SerializedName

class ResultModel(
    @SerializedName("comics")
val comics: ComicsModel,
    @SerializedName("description")
val description: String,
    @SerializedName("events")
val events: EventoModel,
    @SerializedName("id")
val id: Int,
    @SerializedName("modified")
val modified: String,
    @SerializedName("name")
val name: String,
    @SerializedName("resourceURI")
val resourceURI: String,
    @SerializedName("series")
val series: SeriesModel,
    @SerializedName("stories")
val stories: StoriesModel,
    @SerializedName("thumbnail")
val thumbnail: ThumbnailModel,
    @SerializedName("urls")
val urls: List<UrlModel>
)