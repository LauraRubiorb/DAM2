package com.example.laura_rubio_damii.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.laura_rubio_damii.R
import com.example.laura_rubio_damii.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth;
    val database =
        Firebase.database("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")

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

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //CREAR CUENTA
        binding.buttonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        //INICIAR SESION
        binding.buttonIniciar.setOnClickListener {
            if (binding.editTextEmail.text.toString()
                    .isEmpty() || binding.editTextPassw.text.toString().isEmpty()
            ) {
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(
                    binding.editTextEmail.text.toString(),
                    binding.editTextPassw.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        var reference =
                            database.getReference("users")
                        reference.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                for (i in snapshot.children) {
                                    for (j in i.children) {
                                        if (j.key.toString() == ("perfil")) {
                                            if (j.value.toString().equals("Usuario")){
                                                findNavController().navigate(R.id.action_FirstFragment_to_userFragment)
                                            }else if (j.value.toString().equals("Administrador")){
                                                findNavController().navigate(R.id.action_FirstFragment_to_adminFragment)
                                            }
                                        }
                                    }
                                }
                            }

                            override fun onCancelled(error: DatabaseError) {
                            }
                        })

                    } else {
                        Snackbar.make(binding.root, "datos incorrectos", Snackbar.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}