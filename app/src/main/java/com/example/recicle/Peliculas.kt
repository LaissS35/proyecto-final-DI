package com.example.recicle

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Peliculas")
data class Peliculas(@PrimaryKey(autoGenerate = true)var id:Int = 0,
                     @NonNull @ColumnInfo(name ="imagen") val imagen: String = "",
                    @NonNull @ColumnInfo(name ="nombre") val nombre: String = "",
                    @NonNull @ColumnInfo (name ="tipo") val tipo: String = "",
                    @NonNull @ColumnInfo (name ="año") val anyo: Int = 0){}