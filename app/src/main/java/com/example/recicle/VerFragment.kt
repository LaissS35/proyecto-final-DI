package com.example.recicle

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.recicle.databinding.FragmentEditarEliminarBinding
import com.example.recicle.databinding.FragmentVerBinding


class VerFragment : Fragment() {
    private var _binding: FragmentVerBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentVerBinding.inflate(inflater, container, false)
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
        activity?.setTitle("Comentario")



        val id:Int=arguments?.getInt("id") ?:-1
        if(id!=-1) {
            (activity as MainActivity).miViewModel.BuscarIdComentario(id)
            (activity as MainActivity).miViewModel.miComentario.observe(activity as MainActivity){
                it?.let{

                    binding.textotitulocomentario.setText(it.titulo)
                    binding.textocomentariover.setText(it.comentario)


                }
            }


        }

    }


}