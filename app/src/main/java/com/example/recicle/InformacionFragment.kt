package com.example.recicle

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recicle.comentarios.Comentario
import com.example.recicle.databinding.FragmentCrearCBinding
import com.example.recicle.databinding.FragmentInformacionBinding


class InformacionFragment : Fragment() {
    private var _binding: FragmentInformacionBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentInformacionBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.frameLayout)?.isVisible=false
        menu.findItem(R.id.action_settings)?.isVisible=false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.frameLayout2->findNavController().navigate(R.id.FirstFragment)
            R.id.atras->findNavController().navigate(R.id.Comentario_fragment)


        }
        return true


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        activity?.setTitle("Información")






    }
}