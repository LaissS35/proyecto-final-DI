package com.example.recicle

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recicle.databinding.FragmentEditarEliminarBinding

class editar_eliminar : Fragment() {
    private var _binding: FragmentEditarEliminarBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentEditarEliminarBinding.inflate(inflater, container, false)
        return binding.root


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.frameLayout2->findNavController().navigate(R.id.SecondFragment)
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
        activity?.setTitle("Pelicula")



        val id:Int=arguments?.getInt("id") ?:-1
        if(id!=-1) {
            (activity as MainActivity).miViewModel.BuscarId(id)
            (activity as MainActivity).miViewModel.miPelicula.observe(activity as MainActivity){
                it?.let{
                    val imagencita = it.imagen
                    //buscar los valores, primero debe ser un observe y en el se adjuntan los valores a los campos
                   // binding.imageView2.setImag
                    Glide.with(activity as MainActivity).load(imagencita).into(binding.imageView2)
                    binding.texttitulo.setText(it.nombre)
                            binding.texttipo.setText(it.tipo)
                            binding.textanyo.setText(it.anyo.toString())
                            binding.textourl.setText(it.imagen)

                }
            }


            binding.buttonactualizar.isVisible=true
            binding.buttoninsertar.isVisible=false
        }
        else{

            binding.buttonactualizar.isVisible=false
            binding.buttoninsertar.isVisible=true

        }
        binding.buttonactualizar.setOnClickListener{

            val miPelicula = Peliculas(id,binding.textourl.text.toString(),binding.texttitulo.text.toString(),binding.texttipo.text.toString(),binding.textanyo.text.toString().toInt())
            (activity as MainActivity).miViewModel.Actualizar(miPelicula)

            findNavController().navigate(R.id.SecondFragment)

        }
       binding.buttonEliminar.setOnClickListener {
           val miPelicula = Peliculas(id,binding.textourl.text.toString(),binding.texttitulo.text.toString(),binding.texttipo.text.toString(),binding.textanyo.text.toString().toInt())
           (activity as MainActivity).miViewModel.Borrar(miPelicula )

           findNavController().navigate(R.id.SecondFragment)
       }
        binding.buttoninsertar.setOnClickListener{
            val miPelicula = Peliculas(imagen=binding.textourl.text.toString(),nombre=binding.texttitulo.text.toString(),tipo=binding.texttipo.text.toString(),anyo=binding.textanyo.text.toString().toInt())
            (activity as MainActivity).miViewModel.Insertar(miPelicula )
           //si no se le pasan los valores en orden hay que decir su nombre antes
            findNavController().navigate(R.id.SecondFragment)
        }





    }




}