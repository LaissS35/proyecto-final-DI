package com.example.recicle

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.recicle.comentarios.Comentario
import com.example.recicle.databinding.FragmentCrearCBinding
import com.example.recicle.databinding.FragmentEditarEliminarBinding

class CrearCFragment : Fragment() {
    private var _binding: FragmentCrearCBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentCrearCBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.frameLayout2->findNavController().navigate(R.id.Comentario_fragment)
            R.id.atras->findNavController().navigate(R.id.Comentario_fragment)
            R.id.action_settings->findNavController().navigate(R.id.informacionFragment)

        }
        return true


    }
    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.frameLayout)?.isVisible=false


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        activity?.setTitle("Crear Comentario")


        binding.buttonComentario.isVisible=true


        binding.buttonComentario.setOnClickListener{
            val miComentario = Comentario(titulo=binding.titulocomentario.text.toString(),comentario=binding.comentarioentero.text.toString())
            (activity as MainActivity).miViewModel.InsertarComentario(miComentario )
            //si no se le pasan los valores en orden hay que decir su nombre antes
            findNavController().navigate(R.id.Comentario_fragment)
        }





    }
}