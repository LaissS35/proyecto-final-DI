package com.example.recicle.comentarios

import androidx.annotation.WorkerThread
import com.example.recicle.PeliculaDAO
//import com.example.recicle.comentarios
import com.example.recicle.comentarios.Comentario
import kotlinx.coroutines.flow.Flow

class RepositorioComen (val miDAOC: ComentarioDAO) {
    val listaComentario: Flow<List<Comentario>> = miDAOC.Mostrar()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun  Insertar(miComentario: Comentario){
        miDAOC.Insertar(miComentario)
    }
    fun BuscarPorId(id:Int): Flow<Comentario>{
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
}