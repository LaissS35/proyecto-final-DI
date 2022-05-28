package com.example.recicle.comentarios

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recicle.MainActivity
import com.example.recicle.R
import com.example.recicle.databinding.FragmentComentarioFragmentBinding


class Comentario_fragment : Fragment() {


    private var _binding: FragmentComentarioFragmentBinding? = null

    private val binding get() = _binding!!
    lateinit var miRecyclerViewC: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentComentarioFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        setHasOptionsMenu(true)
        activity?.setTitle("Comentarios")


        miRecyclerViewC = binding.ComentarioFragment//recycleview en el fragmento, si no esta no funciona ojo
        miRecyclerViewC.layoutManager = LinearLayoutManager(activity)



        var misComentario: List<Comentario> = listOf()
        (activity as MainActivity).miViewModel.listaComen.observe(activity as MainActivity){
                Comentario ->
            Log.d("comentqrios","llega")
            Comentario?.let{misComentario= it
            miRecyclerViewC.adapter = AdaptadorC( misComentario,this,activity as MainActivity)
        }//pasarle el main activity junto al fragmento y la lista de comentario
        }//actualiza la lista cada vez que se añade algo




    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.frameLayout)?.isVisible=true
        menu.findItem(R.id.atras)?.isVisible=false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.frameLayout->findNavController().navigate(R.id.crearCFragment)
            R.id.frameLayout2 ->findNavController().navigate(R.id.FirstFragment)
            R.id.action_settings ->findNavController().navigate(R.id.comentarios_a_informacion)

        }
        return true


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//boton atras

}