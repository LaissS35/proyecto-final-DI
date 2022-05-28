package com.example.recicle

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recicle.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {



    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var miRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)



        setHasOptionsMenu(true)
        activity?.setTitle("Lista Peliculas")

        miRecyclerView = binding.SecondFragment
        miRecyclerView.layoutManager = LinearLayoutManager(activity)
        //miRecyclerView.adapter = Adaptador(( activity as MainActivity).vivi.listaPelis,this)


        var misPeliculas: List<Peliculas> = listOf()
        (activity as MainActivity).miViewModel.listaPelis.observe(activity as MainActivity){
            Peliculas -> Peliculas?.let{misPeliculas= it
            miRecyclerView.adapter = Adaptador( misPeliculas,this,activity as MainActivity)}//pasarle el main activity junto al fragmento y la lista de peliculas
        }//actualiza la lista cada vez que se añade algo




    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.frameLayout)?.isVisible=true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when (item.itemId) {
            R.id.frameLayout-> findNavController().navigate(R.id.editar_eliminar)
             R.id.frameLayout2->findNavController().navigate(R.id.FirstFragment)
             R.id.atras->findNavController().navigate(R.id.action_SecondFragment_to_comentario_fragment)
             R.id.action_settings->findNavController().navigate(R.id.segundo_a_informacion)

        }
        return true


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//boton atras


}