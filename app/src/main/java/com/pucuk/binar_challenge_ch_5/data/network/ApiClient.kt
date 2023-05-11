package com.pucuk.binar_challenge_ch_5.data.network

import com.pucuk.binar_challenge_ch_5.data.model.ResponseFilm
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

//    @GET("movie/popular?api_key=fba632cdd6813ba053d5c4b18722f59c")
//    suspend fun getAllFilmPopular() : ResponseFilm
    @GET("movie/22")
    suspend fun getDetailFilm(
        @Path("api_key") apiKey: String = "fba632cdd6813ba053d5c4b18722f59c"
    ): ResponseFilm
}