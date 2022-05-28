package com.example.recicle.comentarios

import androidx.lifecycle.*
import com.example.recicle.comentarios.RepositorioComen
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ComentarioViewModel(private val miRepositorioC: RepositorioComen): ViewModel(){
    val listaComen: LiveData<List<Comentario>> = miRepositorioC.listaComentario.asLiveData()
    lateinit var miComentario:LiveData<Comentario>

    fun Insertar (miComentario: Comentario) = viewModelScope.launch {
        miRepositorioC.Insertar(miComentario)
    }
    fun BuscarId (id:Int) = viewModelScope.launch {
        miComentario = miRepositorioC.BuscarPorId(id).asLiveData()
    }
    fun Borrar(miComentario: Comentario) = viewModelScope.launch {
        miRepositorioC.Borrar(miComentario)
    }
    fun Actualizar (miComentario: Comentario) = viewModelScope.launch {
        miRepositorioC.Actualizar(miComentario)
    }
}

class WordViewModelFactoryC(private val repository: RepositorioComen):ViewModelProvider.Factory{
    override  fun <T: ViewModel> create(modelClass: Class<T>): T{
        if (modelClass.isAssignableFrom(ComentarioViewModel::class.java)){
            @Suppress("UNCHEKED_CAST")
            return ComentarioViewModel(repository) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")
    }
}