package com.example.ejercicio6.Book

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


interface BookApi {
    @GET("api/books")
    suspend fun getAllBooks(): List<Book>

    @POST("api/books")
    suspend fun insertBook(@Body book: Book): Book

    @GET("api/books/{id}")
    suspend fun getBookId(@Path("id") id: Int): Book

    @PUT("api/books/{id}")
    suspend fun updateBook(@Path("id") id: Int, @Body book: Book): Book?

    @DELETE("api/books/{id}")
    suspend fun deleteBook(@Path("id") id: Int): Response<Void>
}