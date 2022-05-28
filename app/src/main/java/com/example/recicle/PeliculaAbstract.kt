package com.example.recicle

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recicle.comentarios.Comentario
import com.example.recicle.comentarios.ComentarioDAO

@Database(entities = arrayOf(Peliculas::class, Comentario::class), version =1, exportSchema=false)
abstract class PeliculaAbstract : RoomDatabase(){

    abstract fun miDAO(): PeliculaDAO
    abstract fun miDAOComentarios(): ComentarioDAO

    companion object{
        @Volatile
        private var INSTANCE: PeliculaAbstract?=null

        fun getDatabase(context: Context): PeliculaAbstract{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeliculaAbstract::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}