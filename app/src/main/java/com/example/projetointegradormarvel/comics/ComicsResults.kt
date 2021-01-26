package com.example.projetointegradormarvel.comics

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.projetointegradormarvel.Thumbnail
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "comics")
data class ComicsResults(
    @PrimaryKey
    val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("pageCount") val pageCount: Int,
    @SerializedName("resourceURI") val resourceURI: String,
    @Embedded
    @SerializedName("thumbnail") val thumbnail: Thumbnail

): Serializable
