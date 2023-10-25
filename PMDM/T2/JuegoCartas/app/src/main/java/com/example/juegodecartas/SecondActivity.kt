package com.example.juegodecartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

class SecondActivity : AppCompatActivity(), OnClickListener {
    private lateinit var botonUp: ImageButton
    private lateinit var botonDown: ImageButton
    private lateinit var imagenFondo: ImageView
    private lateinit var editPuntuacion : EditText
    private var nombre: String? = null
    private var puntuacion: Int = 0
    private var aleatorio1: Int = 0
    private var aleatorio2: Int = 0
    private var listaCartas = arrayOf(
        R.drawable.c1, R.drawable.c2, R.drawable.c3,
        R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9,
        R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c13
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        nombre = intent.extras?.getString("nombre")
        empezar()
        acciones()
        puntuacion = savedInstanceState?.getInt("puntuacion")?:0
        editPuntuacion.setText(puntuacion.toString())

    }

    private fun acciones() {
        botonUp.setOnClickListener(this)
        botonDown.setOnClickListener(this)
    }

    private fun empezar() {
        var noti = Snackbar.make(botonUp, "Bienvenido $nombre", Snackbar.LENGTH_INDEFINITE)
        noti.setAction(R.string.boton_empezar) {
            noti.dismiss()
            aleatorio1 = Random.nextInt(13)
            imagenFondo.setImageResource(listaCartas[aleatorio1])
        }
        noti.show()

    }
    private fun instancias() {
        botonUp = findViewById(R.id.buttonUp)
        botonDown = findViewById(R.id.buttonDown)
        imagenFondo = findViewById(R.id.imagenFondo)
        editPuntuacion = findViewById(R.id.edit_puntuacion)
    }
    

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonUp -> {
                aleatorio2 = Random.nextInt(13)//aleatorio dos cuando click
                if (aleatorio1 < aleatorio2) {
                    puntuacion++
                    editPuntuacion.setText(puntuacion.toString())
                    imagenFondo.setImageResource(listaCartas[aleatorio2])
                } else if (aleatorio1 == aleatorio2) {
                    var noti = Snackbar.make(p0,"Carta igual",Snackbar.LENGTH_SHORT).show()
                } else {
                    var noti2 = Snackbar.make(p0,"Has perdido, puntuación : ${puntuacion}",Snackbar.LENGTH_INDEFINITE)
                    noti2.setAction("Atrás"){
                        noti2.dismiss()
                        finish()
                    }
                    noti2.show()
                }
            }
            R.id.buttonDown -> {
                aleatorio2 = Random.nextInt(13)//aleatorio dos cuando click
                if (aleatorio1 > aleatorio2) {
                    puntuacion++
                    editPuntuacion.setText(puntuacion.toString())
                    imagenFondo.setImageResource(listaCartas[aleatorio2])
                }else if (aleatorio1 == aleatorio2){
                    var noti = Snackbar.make(p0,"Carta igual",Snackbar.LENGTH_INDEFINITE).show()
                }else{
                    var noti2 = Snackbar.make(p0,"Has perdido, puntuación : ${puntuacion}",Snackbar.LENGTH_SHORT)
                    noti2.setAction("Atrás"){
                        noti2.dismiss()
                        finish()
                    }
                    noti2.show()
                }
            }
        }
    }


}