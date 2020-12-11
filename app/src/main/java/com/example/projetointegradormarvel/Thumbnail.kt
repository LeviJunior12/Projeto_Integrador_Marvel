package com.example.projetointegradormarvel

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Thumbnail(

    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)