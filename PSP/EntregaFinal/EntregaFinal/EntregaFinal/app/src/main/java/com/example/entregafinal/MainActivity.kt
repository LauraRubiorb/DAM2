package com.example.entregafinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.entregafinal.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        binding.botonIniciar.setOnClickListener {
            if (binding.editCorreo.text.toString() != "" && binding.editClave.text.toString() != ""){
                auth.signInWithEmailAndPassword(binding.editCorreo.text.toString(), binding.editClave.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful){
                            var intent = Intent(applicationContext, ChatActivity::class.java)
                            startActivity(intent)
                        } else {
                            Snackbar.make(binding.root, "Datos incorrectos", Snackbar.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Snackbar.make(binding.root, "Por favor introduce datos", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}