package com.example.laura_rubio_damii.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isEmpty
import androidx.navigation.fragment.findNavController
import com.example.laura_rubio_damii.R
import com.example.laura_rubio_damii.databinding.FragmentRegistrarBinding
import com.example.laura_rubio_damii.ui.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegistrarFragment : Fragment() {

    private var _binding: FragmentRegistrarBinding? = null
    private lateinit var auth: FirebaseAuth;
    val database = Firebase.database("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegistrarBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRegistrar.setOnClickListener {

            if (binding.editTextEmail.text.toString()
                    .isEmpty() || binding.editTextPassw.text.toString().isEmpty()
            ) {
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_LONG).show()
            } else {
                auth.createUserWithEmailAndPassword(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassw.text.toString()
                )

                val reference = database.getReference("users").child(auth.currentUser!!.uid)
                reference.child("email").setValue(binding.editTextEmail.text.toString())
                reference.child("perfil").setValue(binding.spinnerPerfiles.selectedItem.toString())


                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}