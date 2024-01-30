package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentSingupBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SingUpFragment : Fragment() {
    private lateinit var auth: FirebaseAuth;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentSingupBinding
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        database =
            FirebaseDatabase.getInstance("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSingupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCrear.setOnClickListener {
            if (binding.editSingupEmail.text!!.isEmpty() || binding.editSingupPassw.text!!.isEmpty() || binding.editSingupPassw2.text!!.isEmpty() || binding.editSingupDireccion.text!!.isEmpty() || binding.editSingupApellido.text!!.isEmpty() || binding.editSingupNombre.text!!.isEmpty()) {
                Snackbar.make(binding.root, "rellene todos los campos", Snackbar.LENGTH_SHORT)
                    .show()
            } else {
                if (binding.editSingupPassw.text.toString()
                        .equals(binding.editSingupPassw2.text.toString())
                ) {
                    auth.createUserWithEmailAndPassword(
                        binding.editSingupEmail.text.toString(),
                        binding.editSingupPassw.text.toString()
                    )//devuelve un task
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                val childUid =
                                    database.getReference("usuarios").child(auth.currentUser!!.uid)
                                childUid.child("nombre").setValue(binding.editSingupNombre.text.toString())
                                childUid.child("apellido").setValue(binding.editSingupApellido.text.toString())
                                childUid.child("email").setValue(binding.editSingupEmail.text.toString())
                                childUid.child("direccion").setValue(binding.editSingupDireccion.text.toString())

                                Snackbar.make(binding.root, "login correcto", Snackbar.LENGTH_SHORT)
                                    .show()
                            } else {
                                Snackbar.make(binding.root, "fallo", Snackbar.LENGTH_SHORT).show()
                            }
                        }
                    findNavController().navigate(R.id.action_singUpFragment_to_loginFragment)
                } else {
                    Snackbar.make(
                        binding.root,
                        "las contraseñas no coinciden",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }

        }
        binding.iniciar.setOnClickListener {
            findNavController().navigate(R.id.action_singUpFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}