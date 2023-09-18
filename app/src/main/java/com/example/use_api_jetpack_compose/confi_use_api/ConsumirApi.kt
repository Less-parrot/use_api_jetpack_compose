package com.example.use_api_jetpack_compose.confi_use_api

import com.example.use_api_jetpack_compose.api_models.models_nasa.nasa
import retrofit2.Call
import retrofit2.http.GET

interface ConsumirApi {
    //ej: v3.1/name/Colombia
   @GET("planetary/apod?api_key=X04eZMXwQLgSYD0zaUfNkgIz2gRNnOLf0OyxI2Qt&date=2021-01-05")
    //debemos llamar a la data Class que guarde todos los parametros de la API
    fun getTraer(): Call<nasa>//<resCountries>
}