package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var auth: FirebaseAuth;


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

        binding.botonLoginInicio.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.editLoginUser.text.toString(),binding.editLoginPassw.text.toString())
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val bundle = Bundle()
                        bundle.putString("nombre", binding.editLoginUser.text.toString())
                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment, bundle)

                    }else{
                        Snackbar.make(binding.root,"datos incorrectos",Snackbar.LENGTH_SHORT).show()
                    }
                }
        }
        binding.botonLoginCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_singUpFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}