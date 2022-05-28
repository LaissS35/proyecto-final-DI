package com.example.recicle.comentarios


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Comentario")
data class Comentario(@PrimaryKey(autoGenerate = true)var id:Int = 0,
                     @NonNull @ColumnInfo(name ="titulo") val titulo: String = "",
                     @NonNull @ColumnInfo(name ="comentario") val comentario: String = ""){}