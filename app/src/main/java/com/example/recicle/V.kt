package com.example.recicle

import androidx.lifecycle.ViewModel

class V: ViewModel() {
    //inactivo
    var listaPelis:MutableList<Peliculas> = mutableListOf()

    init{listaPelis = cargarDatos()}


    private fun cargarDatos():MutableList<Peliculas>{
        val lista:MutableList<Peliculas> = mutableListOf()
        lista.add(Peliculas(0,"","Tarzan","animación",1990))
        lista.add(Peliculas(1,"","sonic","accion",2020))
        lista.add(Peliculas(2,"","Goku","anime",1999))
        lista.add(Peliculas(3,"","JOJO","lucha",2022))
        lista.add(Peliculas(4,"","mononoke","fantasia",1998))
        lista.add(Peliculas(5,"","el gigante de hierro","conmovedor",2000))
        lista.add(Peliculas(6,"","los gatos no bailan","musical",2003))

        return lista
    }



}