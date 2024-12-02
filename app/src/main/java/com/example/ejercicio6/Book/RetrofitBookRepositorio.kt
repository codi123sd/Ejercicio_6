package com.example.ejercicio6.Book

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RetrofitBookRepositorio (private val BookApi: BookApi) : Repositorio{


    override fun getAllBooks(): Flow<List<Book>> = flow {
        try {
            val book = BookApi.getAllBooks()
            emit(book)
        } catch (e: IOException) {
            // Manejo de error de red (sin conexión)
            emit(emptyList())
            // Registrar el error o mostrarlo de alguna forma
            println("Error de red: ${e.localizedMessage}")
        } catch (e: HttpException) {
            // Manejo de error HTTP (errores 4xx, 5xx)
            emit(emptyList())
            // Registrar el error o mostrarlo de alguna forma
            println("Error HTTP: ${e.localizedMessage}")
        } catch (e: Exception) {
            // Manejo de errores generales
            emit(emptyList())
            // Registrar el error o mostrarlo de alguna forma
            println("Error desconocido: ${e.localizedMessage}")
        }
    }

    override fun getBookId(id: Int): Flow<Book?> = flow {
        try {
            val book = BookApi.getBookId(id)
            emit(book)
        } catch (e: IOException) {
            // Manejo de error de red (sin conexión)
            emit(null)
            println("Error de red: ${e.localizedMessage}")
        } catch (e: HttpException) {
            // Manejo de error HTTP
            emit(null)
            println("Error HTTP: ${e.localizedMessage}")
        } catch (e: Exception) {
            // Manejo de errores generales
            emit(null)
            println("Error desconocido: ${e.localizedMessage}")
        }
    }

    override suspend fun insertBook(book: Book) {
        try {
            BookApi.insertBook(book)
        } catch (e: IOException) {
            // Manejo de error de red (sin conexión)
            println("Error de red: ${e.localizedMessage}")
        } catch (e: HttpException) {
            // Manejo de error HTTP
            println("Error HTTP: ${e.localizedMessage}")
        } catch (e: Exception) {
            // Manejo de errores generales
            println("Error desconocido: ${e.localizedMessage}")
        }
    }

    override suspend fun deleteBook(book: Book) {
        try {
            BookApi.deleteBook(book.id)
        } catch (e: IOException) {
            // Manejo de error de red (sin conexión)
            println("Error de red: ${e.localizedMessage}")
        } catch (e: HttpException) {
            // Manejo de error HTTP
            println("Error HTTP: ${e.localizedMessage}")
        } catch (e: Exception) {
            // Manejo de errores generales
            println("Error desconocido: ${e.localizedMessage}")
        }
    }

    override suspend fun updateBook(book: Book) {
        try {
            BookApi.updateBook(book.id, book)
        } catch (e: IOException) {
            // Manejo de error de red (sin conexión)
            println("Error de red: ${e.localizedMessage}")
        } catch (e: HttpException) {
            // Manejo de error HTTP
            println("Error HTTP: ${e.localizedMessage}")
        } catch (e: Exception) {
            // Manejo de errores generales
            println("Error desconocido: ${e.localizedMessage}")
        }
    }





}