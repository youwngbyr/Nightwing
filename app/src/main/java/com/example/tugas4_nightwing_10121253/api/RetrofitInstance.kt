package com.example.tugas4_nightwing_10121253.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.superheroapi.com/api/4b63c7295affaa25d00973deebb055ae/"

    val api: SuperHeroAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperHeroAPI::class.java)
    }
}