package com.example.recicle.comentarios

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
import com.example.recicle.MainActivity
import com.example.recicle.comentarios.Comentario
import com.example.recicle.R


class AdaptadorC(
    private var lista: List<Comentario>,
    var fragmento: Fragment,
    var mainActivity: MainActivity
): RecyclerView.Adapter<AdaptadorC.ViewHolder>() {

    inner class ViewHolder (v: View):RecyclerView.ViewHolder(v){//contenedor

        var titulo:TextView = v.findViewById(R.id.textView)//nombre del text view, cambiarlo
        var comentario:TextView= v.findViewById(R.id.textView2)

        var id:Int=-1

        init{

            v.setOnClickListener {
                var miBundle:Bundle= bundleOf("id" to this.id)
                fragmento.findNavController().navigate(R.id.verFragment, miBundle)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        val v= LayoutInflater.from(parent.context).inflate(R.layout.layout_contenedor2,parent,false)

        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {//pasar el main activity



        holder.titulo.text=lista[position].titulo
        holder.comentario.text=lista[position].comentario

        holder.id=lista[position].id
    }

    override fun getItemCount(): Int {
        return lista.count()
    }


}