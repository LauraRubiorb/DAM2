package com.example.estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private var contador:Int = 0
    private lateinit var textoRecepcion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        contador = intent.extras?.getInt("resultado",7)?:0
        textoRecepcion.setText(contador.toString())

    }

    private fun instancias() {
        textoRecepcion = findViewById(R.id.texto_recepcion)
    }
}