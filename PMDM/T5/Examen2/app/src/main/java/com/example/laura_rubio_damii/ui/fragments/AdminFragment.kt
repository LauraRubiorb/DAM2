package com.example.laura_rubio_damii.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laura_rubio_damii.R
import com.example.laura_rubio_damii.databinding.FragmentAdminBinding
import com.example.laura_rubio_damii.databinding.FragmentLoginBinding
import com.example.laura_rubio_damii.ui.adapters.adaptadorPost
import com.example.laura_rubio_damii.ui.adapters.adaptadorUser
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AdminFragment : Fragment() {

    private var _binding: FragmentAdminBinding? = null
    private lateinit var auth: FirebaseAuth;
    private lateinit var adapterUser: adaptadorUser


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        binding.recyclerViewAdmin.adapter = adapterUser
        binding.recyclerViewAdmin.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAdminBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}