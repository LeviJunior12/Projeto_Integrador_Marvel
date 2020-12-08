package com.example.projetointegradormarvel.repository


import com.example.projetointegradormarvel.comics.Comics
import com.example.projetointegradormarvel.characters.Personagens
import com.example.projetointegradormarvel.creators.Creators
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {


    //Função para pegar os quadrinhos
    @GET("comics?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    suspend fun getAllComicsRepo(
        @Query("offset") offset: Int
    ) : Comics


    //Função para pegar os criadores
    @GET("creators?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
        suspend fun getAllCreatorsRepo(
            @Query("offset") offset: Int
    ): Creators

        //Função para pegar os personagens
    @GET("characters?ts=1&apikey=6eb7e8896ec5850c52515a8a23ee97f0&hash=40a3aa568bb269dfad85ae0c4a297181")
    suspend fun getAllCharactersRepo(
        @Query("offset") offset: Int
    ): Personagens.Characters

}

//Criação do RetroFit
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://gateway.marvel.com:443/v1/public/characters/1009610/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//Criação da variável Service para usar no MainViewModel
val serv: Service = retrofit.create(Service::class.java)