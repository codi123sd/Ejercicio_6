package com.example.ejercicio6.Book

import kotlinx.coroutines.flow.Flow

interface Repositorio {

    fun  getAllBooks(): Flow<List<Book>>

    fun getBookId(id: Int): Flow<Book?>

    suspend fun insertBook(book: Book)

    suspend fun deleteBook(book: Book)

    suspend fun updateBook(book: Book)

}
/*class Repositorio {
    private val api = RetrofitBase.BookApi

    suspend fun getAllBooks() = api.getAllBooks()
    suspend fun insertBook(book: Book) = api.insertBook(book)
    suspend fun updateBook(book: Book) = api.updateBook(book.id, book)
    suspend fun deleteBook(id: Int) = api.deleteBook(id)
}*/
