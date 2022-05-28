package com.example.recicle

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface PeliculaDAO {

@Query("select * from Peliculas ")
fun Mostrar(): Flow<List<Peliculas>>

@Insert (onConflict = OnConflictStrategy.IGNORE)
suspend fun Insertar(word:Peliculas)


@Query("delete from Peliculas")
suspend fun BorrarT()

@Query ("select * from Peliculas where id like :id")
fun BuscarId(id:Int): Flow<Peliculas>

@Update
suspend fun Actualizar (word:Peliculas)

@Delete
suspend fun Borrar(word: Peliculas)
}