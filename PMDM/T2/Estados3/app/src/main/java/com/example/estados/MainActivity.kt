package com.example.estados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var botonSuma: Button
    private lateinit var botonResta: Button
    private var botonReset: ImageButton? = null
    private lateinit var textoContador: TextView
    private var resultado: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v("ciclo_vida", "ejecutando metodo onCreate")
        instancias()
        acciones()
        resultado = savedInstanceState?.getInt("resultado")
            ?: 0 //si esto es nulo no ejecutas lo detras y tomas el valor 0
        textoContador.setText(resultado.toString())
    }

    private fun acciones() {
        botonResta.setOnClickListener(this)
        botonSuma.setOnClickListener(this)
        botonReset?.setOnClickListener(this)
        //application.applicationContext.
    }

    private fun instancias() {
        textoContador = findViewById(R.id.textoContador)
        botonSuma = findViewById(R.id.botonSuma)
        botonResta = findViewById(R.id.botonResta)
        botonReset = findViewById(R.id.botonReset)
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

    override fun onSaveInstanceState(outState: Bundle) {
        //guardar antes de que se destruya
        super.onSaveInstanceState(outState)
        outState.putInt("resultado", resultado!!)
    }

    override fun onClick(p0: View?) {
        if (resultado!! < 15) {
            when (p0!!.id) {//buscamos quien clica con el when .id
                R.id.botonSuma -> {
                    resultado = resultado!! + 1
                }
                R.id.botonResta -> {
                    resultado = resultado!! - 1
                }
                R.id.botonReset ->{
                    val intent = Intent(applicationContext,SecondActivity::class.java)
                    intent.putExtra("resultado",resultado)
                    startActivity(intent)
                }
            }
        }
        if (!comprobarLimite(p0!!)) {
            textoContador.setText(resultado.toString())
        }
    }

    fun comprobarLimite(view: View): Boolean {
        if (resultado == 15) {
            //notificacion que ve si has llegado a 15,
            //le pasas una vista, un texto, y la longitud
            //queremos que la noti tenga un boton de resetear .setAct
            //mostramos
            Snackbar.make(view, "Limite alcanzado", Snackbar.LENGTH_LONG)
                .setAction("RESETEAR") {
                    resultado = 0
                    textoContador.setText(resultado!!.toString())
                }
                .show()
            return true
        }
        return false
    }
}
