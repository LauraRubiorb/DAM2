package com.example.laurarubio_t2_pdmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {
    private lateinit var edit_imc : EditText
    private lateinit var imagenFondo : ImageView
    private lateinit var textoIMC : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        textoIMC = intent.extras?.getInt("imc").toString()

        edit_imc.setText(textoIMC)
        acciones()
    }

    private fun instancias() {
        edit_imc = findViewById(R.id.edit_imc)
        imagenFondo = findViewById(R.id.imagenFondo)
    }

    private fun acciones() {
        if ((edit_imc.text.toString().toInt()) < 18){
            imagenFondo.setImageResource(R.drawable.estado6)
        }else if ((edit_imc.text.toString().toInt()) >= 18 && (edit_imc.text.toString().toInt()) <=29){
            imagenFondo.setImageResource(R.drawable.estado2)
        }else if ((edit_imc.text.toString().toInt())>=30 && (edit_imc.text.toString().toInt()) <=34){
            imagenFondo.setImageResource(R.drawable.estado3)
        }else if ((edit_imc.text.toString().toInt()) <=35 && (edit_imc.text.toString().toInt()) <=39){
            imagenFondo.setImageResource(R.drawable.estado4)
        }else{
            imagenFondo.setImageResource(R.drawable.estado5)
        }
    }
}