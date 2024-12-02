package com.example.ejercicio6.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.ejercicio6.Book.Book
import com.example.ejercicio6.Book.BookApi

class BookViewModel(private val bookapi: BookApi) : ViewModel(){

    // Estado que contiene la lista de libros
    private val list_books = MutableStateFlow<List<Book>>(emptyList())
    val books: StateFlow<List<Book>> = list_books

    //val allBooks: LiveData<List<Book>> = Repositorio.getAllBooks

    init {
        loadBooks()
    }

    private fun loadBooks() {
        viewModelScope.launch {
            //list_books.value = Repositorio.getAllBooks()
            try {
                list_books.value = bookapi.getAllBooks() // Aquí debe estar la llamada a Retrofit
            } catch (e: Exception) {
                // Maneja el error apropiadamente, loguea o muestra un mensaje de error
                Log.e("BookViewModel", "Error loading books", e)
            }


        }
    }

    fun addBook(book: Book) {
        viewModelScope.launch {
            //bookapi.insertBook(book)
            //loadBooks()
            try {
                // Obtén la lista actual de libros
                val currentBooks = bookapi.getAllBooks()
                // Encuentra el ID máximo en la lista existente
                val maxId = currentBooks.maxByOrNull { it.id }?.id ?: 0
                // Asigna un nuevo ID incrementado
                val newBook = book.copy(id = maxId + 1)
                // Inserta el libro con el nuevo ID
                bookapi.insertBook(newBook)
                // Recarga la lista de libros
                loadBooks()
            } catch (e: Exception) {
                Log.e("BookViewModel", "Error al agregar el libro", e)
            }
        }
    }

    fun updateBook(book: Book) {
        viewModelScope.launch {
            try {
                val updatedBook = bookapi.updateBook(book.id, book)
                if (updatedBook != null) {
                    loadBooks()  // Recarga la lista solo si la actualización fue exitosa
                } else {

                    Log.e("BookViewModel", "Error: El servidor devolvió una respuesta nula")
                }
            } catch (e: Exception) {
                loadBooks()
                Log.e("BookViewModel", "Error al actualizar el libro", e)
            }
        }
    }

    fun deleteBook(book: Book) {
        viewModelScope.launch {
            //bookapi.deleteBook(book.id)
            //loadBooks()
            try {
                val response = bookapi.deleteBook(book.id)
                if (response.isSuccessful) {
                    loadBooks()  // Recarga la lista solo si la eliminación fue exitosa
                } else {
                    Log.e("BookViewModel", "Error en la eliminación: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("BookViewModel", "Error al eliminar el libro", e)
            }
        }
    }
}