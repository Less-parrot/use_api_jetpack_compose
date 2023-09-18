package com.example.use_api_jetpack_compose.confi_use_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.nasa.gov/")   //ej: https://restcountries.com/
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val consumirApi = retrofit.create(ConsumirApi::class.java)
}