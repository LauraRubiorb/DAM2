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
import com.example.laura_rubio_damii.databinding.FragmentLoginBinding
import com.example.laura_rubio_damii.databinding.FragmentUserBinding
import com.example.laura_rubio_damii.ui.adapters.adaptadorPost
import com.example.laura_rubio_damii.ui.model.Post
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
class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    private lateinit var auth: FirebaseAuth;
    private lateinit var adatadorPost: adaptadorPost
    val database = Firebase.database("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        binding.recyclerViewUsers.adapter = adatadorPost
        binding.recyclerViewUsers.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reference = database.getReference("post").orderByChild("reactions")

        reference.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val hijos = snapshot.children
                hijos.forEach {
                    val post = it.getValue(Post::class.java)
                    val itemPost = Post(
                        post?.body,
                        post?.id,
                        post?.reactions,
                        post?.tags,
                        post?.title,
                        post?.userId,
                    )
                    adatadorPost.addPost(itemPost)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}