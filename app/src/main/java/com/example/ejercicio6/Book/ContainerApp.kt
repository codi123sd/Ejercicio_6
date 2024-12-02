package com.example.ejercicio6.Book

/**
  Contenedor de aplicaciones para inyección de dependencias.
 */
interface ContainerApp {
    val BookRepository: Repositorio
}

class ContainerDataApp : ContainerApp {

    override val BookRepository: Repositorio by lazy {
        RetrofitBookRepositorio(RetrofitInstance.Api)
    }
}