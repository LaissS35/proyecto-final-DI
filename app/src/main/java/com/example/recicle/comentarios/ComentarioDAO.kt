package com.example.recicle.comentarios

import androidx.room.*
//import com.example.recicle.comentarios
import kotlinx.coroutines.flow.Flow


@Dao
interface ComentarioDAO {

    @Query("select * from Comentario ")
    fun Mostrar(): Flow<List<Comentario>>

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun Insertar(word: Comentario)


    @Query("delete from Comentario")
    suspend fun BorrarT()

    @Query ("select * from Comentario where id like :id")
    fun BuscarId(id:Int): Flow<Comentario>

    @Update
    suspend fun Actualizar (word: Comentario)

    @Delete
    suspend fun Borrar(word: Comentario)
}