package com.example.recicle

import androidx.annotation.WorkerThread
import com.example.recicle.comentarios.Comentario
import com.example.recicle.comentarios.ComentarioDAO
//import com.example.recicle.peliculass.Peliculas
import kotlinx.coroutines.flow.Flow

class Repositorio (val miDAO: PeliculaDAO, val miDAOC: ComentarioDAO) {
    val listaPeliculas: Flow<List<Peliculas>> = miDAO.Mostrar()

    val listaComentario: Flow<List<Comentario>> = miDAOC.Mostrar()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun  Insertar(miComentario: Comentario){
        miDAOC.Insertar(miComentario)
    }
    fun BuscarPorIdComentario(id:Int): Flow<Comentario>{
        return miDAOC.BuscarId(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miComentario: Comentario){
        miDAOC.Borrar(miComentario)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miComentario: Comentario){
        miDAOC.Actualizar(miComentario)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun  Insertar(miPelicula: Peliculas){
        miDAO.Insertar(miPelicula)
    }
    fun BuscarPorId(id:Int): Flow<Peliculas>{
        return miDAO.BuscarId(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Borrar(miPelicula: Peliculas){
        miDAO.Borrar(miPelicula)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun Actualizar(miPelicula: Peliculas){
        miDAO.Actualizar(miPelicula)
    }
}