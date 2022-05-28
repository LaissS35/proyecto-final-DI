package com.example.recicle.comentarios

import android.content.Context
import androidx.room.Database;
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.recicle.comentarios.ComentarioDAO
import com.example.recicle.comentarios.Comentario

@Database(entities = arrayOf(Comentario::class), version =1, exportSchema=false)
abstract class ComentarioAbstract : RoomDatabase(){

    abstract fun miDAOC(): ComentarioDAO

    companion object{
        @Volatile
        private var INSTANCE: ComentarioAbstract?=null

        fun getDatabase(context: Context): ComentarioAbstract{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComentarioAbstract::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}