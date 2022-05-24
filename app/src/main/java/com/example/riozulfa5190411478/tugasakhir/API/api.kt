package com.example.riozulfa5190411478.tugasakhir.API

import retrofit2.Call
import retrofit2.http.GET

interface api {
    @GET("posts")
    fun getApi(): Call<ArrayList<ResponseApi>>
}