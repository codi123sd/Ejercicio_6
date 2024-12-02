package com.example.ejercicio6.Book

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val Path_Base = "http://10.0.2.2:5031/"

    val Api: BookApi by lazy {
        Retrofit.Builder()
        .baseUrl(Path_Base)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BookApi::class.java)

    }

    /*val BookApi: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }*/

}