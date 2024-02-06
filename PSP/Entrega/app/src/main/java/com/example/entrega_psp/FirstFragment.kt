package com.example.entrega_psp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.entrega_psp.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var auth: FirebaseAuth;


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonIniciar.setOnClickListener {
            if(binding.editCorreo.text.isEmpty()||binding.editClave.text.isEmpty()){
                Snackbar.make(binding.root,"Faltan Datos",Snackbar.LENGTH_SHORT)
            }else{
                auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(),binding.editClave.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            val bundle = Bundle()
                            bundle.putString("nombre", binding.editClave.text.toString())
                            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)

                        }else{
                            Snackbar.make(binding.root,"datos incorrectos",Snackbar.LENGTH_SHORT).show()
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