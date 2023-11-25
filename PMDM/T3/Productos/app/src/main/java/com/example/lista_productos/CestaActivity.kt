package com.example.lista_productos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lista_productos.model.Producto

class CestaActivity : AppCompatActivity() {
    private lateinit var cesta: ArrayList<Producto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta)
        intent.extras?.get("lista")
        cesta = intent.getParcelableArrayListExtra("lista")!!
    }
}