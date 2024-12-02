package com.example.ejercicio6.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ejercicio6.Book.BookApi
import com.example.ejercicio6.Book.RetrofitBookRepositorio
import com.example.ejercicio6.Book.RetrofitInstance


object BookViewModelProvider{
    val Factory = viewModelFactory{


        initializer {
            BookViewModel(
                //RetrofitInstance.Api
                RetrofitInstance.Api
            )
        }

    }
    /*val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            val repositorio = RetrofitInstance.Api //Repositorio()
            return BookViewModel(repositorio) as T
        }
    }*/

}