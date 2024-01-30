package com.example.laura_rubio_dam2.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.laura_rubio_dam2.R
import com.example.laura_rubio_dam2.databinding.FragmentSecondBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    var database = Firebase.database

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        database =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textEmailFg2.text = arguments?.getString("email")
        binding.buttonAddFg2.setOnClickListener {
            binding.editDescripcionFg2.text?.clear()
            binding.editIdFg2.text?.clear()
            binding.editNombreFg2.text?.clear()
            binding.editPrecioFg2.text?.clear()
            binding.editStockFg2.text?.clear()
            binding.radioGrupo.clearCheck()

            val ref = database.getReference("Productos").child(binding.editIdFg2.text.toString())
            ref.child(binding.editNombreFg2.text.toString())
            ref.child(binding.editDescripcionFg2.text.toString())
            ref.child(binding.editStockFg2.text.toString())

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}