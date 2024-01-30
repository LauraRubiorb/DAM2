package com.example.laura_rubio_dam2.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.laura_rubio_dam2.R
import com.example.laura_rubio_dam2.databinding.FragmentFirstBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private lateinit var auth: FirebaseAuth;
    var database = Firebase.database


    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!
    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        database =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.buttonIniciarFg1.setOnClickListener {

            /*val bundle = Bundle();
            bundle.putString("email",binding.textEmailFg1.text.toString())
            findNavController().navigate(
                R.id.action_FirstFragment_to_SecondFragment,
                bundle
            )*/
            if (binding!!.textEmailFg1.text!!.isEmpty() || binding!!.textPasswFg1.text!!.isEmpty()) {
                Snackbar.make(binding!!.root, "faltan datos", Snackbar.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(
                    binding!!.textEmailFg1.text.toString(),
                    binding!!.textPasswFg1.text.toString()
                ).addOnCompleteListener {

                    if (it.isSuccessful) {
                        Log.v("prueba", "loginCorrecto")
                        val bundle = Bundle();
                        bundle.putString("email", binding!!.textEmailFg1.text.toString())
                        findNavController().navigate(
                            R.id.action_FirstFragment_to_SecondFragment,
                            bundle
                        )

                    } else {
                        Log.v("prueba", "login incorrecto")
                        auth.createUserWithEmailAndPassword(
                            binding!!.textEmailFg1.text.toString(),
                            binding!!.textPasswFg1.text.toString()

                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                Log.v("prueba", "creacion Correcto")
                                val bundle = Bundle();
                                findNavController().navigate(
                                    R.id.action_FirstFragment_to_SecondFragment,
                                    bundle
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}