package com.example.projetointegradormarvel.api

import com.example.projetointegradormarvel.characters.Characters
import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.creators.Creators
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    //  @GET("characters?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    @GET("characters?ts=1&limit=9&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getCharactersRepo(
        @Query("offset") offset: Int
    ): Characters

    //  @GET("comics?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    @GET("comics?formatType=comic&ts=1&limit=9&orderBy=-focDate&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getComicsRepo(
        @Query("offset") offset: Int
    ): Comics

    //  @GET("creators?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    @GET("creators?ts=1&limit=9&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getCreatorsRepo(
        @Query("offset") offset: Int
    ): Creators

    //Busca

    @GET("characters?ts=1&limit=9&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getCharactersSearch(): Characters

    @GET("comics?formatType=comic&ts=1&limit=9&orderBy=-focDate&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getComicsSearch(): Comics

    @GET("creators?ts=1&limit=9&apikey=f0d3d6558f5fac5abf6f59784dc534de&hash=9117113700bd92c2c9a3fb4bf4455d5f")
    suspend fun getCreatorsSearch(): Creators
}

const val urlApiMarvel = "https://gateway.marvel.com:443/v1/public/"

val retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(urlApiMarvel)
    .build()

val webService: WebService = retrofit.create(WebService::class.java)