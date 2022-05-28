package com.example.recicle

import androidx.lifecycle.*
import com.example.recicle.comentarios.Comentario
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class PeliculaViewModel(private val miRepositorio:Repositorio): ViewModel(){
    val listaPelis: LiveData<List<Peliculas>> = miRepositorio.listaPeliculas.asLiveData()
    lateinit var miPelicula:LiveData<Peliculas>

    fun Insertar (miPelicula: Peliculas) = viewModelScope.launch {
        miRepositorio.Insertar(miPelicula)
    }
    fun BuscarId (id:Int) = viewModelScope.launch {
        miPelicula = miRepositorio.BuscarPorId(id).asLiveData()
    }
    fun Borrar(miPelicula: Peliculas) = viewModelScope.launch {
        miRepositorio.Borrar(miPelicula)
    }
    fun Actualizar (miPelicula: Peliculas) = viewModelScope.launch {
        miRepositorio.Actualizar(miPelicula)
    }


    val listaComen: LiveData<List<Comentario>> = miRepositorio.listaComentario.asLiveData()
    lateinit var miComentario:LiveData<Comentario>

    fun InsertarComentario (miComentario: Comentario) = viewModelScope.launch {
        miRepositorio.Insertar(miComentario)
    }
    fun BuscarIdComentario (id:Int) = viewModelScope.launch {
        miComentario = miRepositorio.BuscarPorIdComentario(id).asLiveData()
    }
    fun Borrar(miComentario: Comentario) = viewModelScope.launch {
        miRepositorio.Borrar(miComentario)
    }
    fun Actualizar (miComentario: Comentario) = viewModelScope.launch {
        miRepositorio.Actualizar(miComentario)
    }
}

class WordViewModelFactory(private val repository: Repositorio):ViewModelProvider.Factory{
    override  fun <T: ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(PeliculaViewModel::class.java)){
            @Suppress("UNCHEKED_CAST")
            return PeliculaViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }
}