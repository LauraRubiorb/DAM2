package com.example.recetas.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recetas.R
import com.example.recetas.databinding.FragmentRegistrarBinding
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegistrarFragment : Fragment() {

    private var binding: FragmentRegistrarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    // private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegistrarBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding!!.textEmailFragment2.text!!.isEmpty() || binding!!.textPasswFragment2.text!!.isEmpty() || binding!!.textPassw2Fragment2.text!!.isEmpty()) {
            Snackbar.make(binding!!.root, "FALTAN DATOS", Snackbar.LENGTH_SHORT).show()
        } else {
            if (!(binding!!.textPasswFragment2.text!!.equals(binding!!.textPassw2Fragment2.text!!))) {
                Snackbar.make(binding!!.root, "Las contraseñas no coinciden", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                binding!!.botonIniciarRegistroFragment2.setOnClickListener {
                    findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}