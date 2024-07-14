package com.example.tugas4_nightwing_10121253.api

import com.example.tugas4_nightwing_10121253.model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperHeroAPI {
    @GET("491")
    fun getSuperHero(): Call<Superhero>
}