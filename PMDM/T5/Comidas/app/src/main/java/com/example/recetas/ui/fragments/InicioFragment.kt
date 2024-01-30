package com.example.recetas.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recetas.R
import com.example.recetas.databinding.FragmentInicioBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InicioFragment : Fragment() {

    private var binding: FragmentInicioBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInicioBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.botonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        /*if (binding!!.textEmailFragment1.text!!.isEmpty() || binding!!.textPasswFragment1.text!!.isEmpty()) {
            /*Snackbar.make(
                binding!!.root,
                "FALTAN DATOS",
                Snackbar.LENGTH_SHORT
            ).show()*/
        } else {

        }*/
        binding!!.botonIniciar.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}