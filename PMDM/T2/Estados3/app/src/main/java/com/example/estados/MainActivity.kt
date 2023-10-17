package com.example.estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var botonSuma: Button
    private lateinit var botonResta: Button
    private lateinit var textoContador: TextView
    private var resultado: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida", "ejecutando metodo onCreate")
        instancias()
        acciones()
    }

    private fun acciones() {
        botonResta.setOnClickListener(this)
        botonSuma.setOnClickListener(this)
    }

    private fun instancias() {
        textoContador = findViewById(R.id.textoContador)
        botonSuma = findViewById(R.id.botonSuma)
        botonResta = findViewById(R.id.botonResta)
        resultado = 0
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "ejecutando metodo onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "ejecutando metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "ejecutando metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "ejecutando metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "ejecutando metodo onDestroy")
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {//buscamos quien clica con el when .id
            R.id.botonSuma -> {
                resultado = resultado!! + 1
            }
            R.id.botonResta -> {
                resultado = resultado!! - 1
            }
        }
        textoContador.setText(resultado.toString())

    }
}
