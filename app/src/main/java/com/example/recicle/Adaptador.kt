package com.example.recicle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class Adaptador(
    private var lista: List<Peliculas>,
    var fragmento: Fragment,
    var mainActivity: MainActivity
): RecyclerView.Adapter<Adaptador.ViewHolder>() {

    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){//contenedor
        var imagen:ImageView = v.findViewById(R.id.imageView)//url de la imagen
        var tvNumber:TextView = v.findViewById(R.id.tvNumber)//nombre del text view, cambiarlo
        var tipo:TextView= v.findViewById(R.id.tvTipo)
        var anyo:TextView = v.findViewById(R.id.tvAnyo)
        var id:Int=-1

        init{

            v.setOnClickListener {
                var miBundle:Bundle= bundleOf("id" to this.id)
                fragmento.findNavController().navigate(R.id.action_SecondFragment_to_editar_eliminar, miBundle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val v= LayoutInflater.from(parent.context).inflate(R.layout.layout_contenedor,parent,false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//pasar el main activity


        Glide.with(mainActivity).load(lista[position].imagen).into(holder.imagen)
        holder.tvNumber.text=lista[position].nombre
        holder.tipo.text=lista[position].tipo
        holder.anyo.text= lista[position].anyo.toString()
        holder.id=lista[position].id
    }

    override fun getItemCount(): Int {
        return lista.count()
    }


}
