package com.example.compras.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.compras.R
import com.example.compras.adaptadores.DetalleAdapter
import com.example.compras.adaptadores.ProductosAdapter
import com.example.compras.databinding.ActivityDetalleBinding
import com.example.compras.model.Producto

class DetalleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalleBinding
    private lateinit var adapter: DetalleAdapter
    private lateinit var lista: ArrayList<String>
    private lateinit var producto: Producto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = ArrayList()

        adapter = DetalleAdapter(this, lista)
        binding.recyclerImagenesDetalle.adapter = adapter
        binding.recyclerImagenesDetalle.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)

        producto = intent.getSerializableExtra("producto") as Producto

        binding.textNombre.text = producto.title
        binding.textPrecio.text = producto.price.toString()
        binding.textStock.text = producto.stock.toString()
        binding.textDescripcion.text = producto.description
    }
}