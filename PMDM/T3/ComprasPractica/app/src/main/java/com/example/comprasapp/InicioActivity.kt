package com.example.comprasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.comprasapp.adapter.AdaptadorMarcas
import com.example.comprasapp.data.DataSet
import com.example.comprasapp.databinding.ActivityInicioBinding
import com.example.comprasapp.model.Producto

class InicioActivity : AppCompatActivity() , AdaptadorMarcas.OnRecyclerProductoSelected{
    private lateinit var binding: ActivityInicioBinding
    private lateinit var adapter: AdaptadorMarcas
    private lateinit var listaProductos: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)

       

        listaProductos = ArrayList()

        //asociamos el recycler
        adapter = AdaptadorMarcas(DataSet.getProductos(), this)
        binding.recyclerProductos.adapter = adapter
        binding.recyclerProductos.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)



    }

    override fun OnItemSelected(item: Producto) {
        val intent = Intent(this,DetalleActivity::class.java)
        intent.putExtra("nombre",item.nombre)
        startActivity(intent)
    }
}