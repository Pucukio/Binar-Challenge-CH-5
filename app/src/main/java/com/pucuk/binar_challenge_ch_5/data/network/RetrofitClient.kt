package com.pucuk.binar_challenge_ch_5.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val  BASE_URL ="https://api.themoviedb.org/3/"

    val instance : ApiClient by lazy {
        val retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiClient::class.java)
    }
}