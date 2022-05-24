package com.example.riozulfa5190411478.tugasakhir.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Retrofit {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val instance: api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(api::class.java)
    }
}