package com.example.comprasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.comprasapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)
        acciones()
    }

    private fun acciones() {
        bindind.botonIniciar.setOnClickListener(this)
        bindind.botonLimpiar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            bindind.botonLimpiar.id -> {
                bindind.textoEmail.text.clear()
                bindind.textoPassw.text.clear()
                bindind.checkRecordar.isChecked = false
            }

            bindind.botonIniciar.id -> {
                if(!bindind.textoEmail.text.isEmpty() && !bindind.textoPassw.text.isEmpty()){
                    val intent = Intent(applicationContext,InicioActivity::class.java)
                    intent.putExtra("email",bindind.textoEmail.text)
                    startActivity(intent)
                }else{
                    Snackbar.make(bindind.root,"FALTAN DATOS!!",Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}