package com.example.laura_rubio_dam2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laura_rubio_dam2.adapter.AdapterRestaurante
import com.example.laura_rubio_dam2.data.DataSet
import com.example.laura_rubio_dam2.databinding.ActivitySecondBinding
import com.example.laura_rubio_dam2.model.Restaurante

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var listaRestaurante: ArrayList<Restaurante>
    private lateinit var adapter : AdapterRestaurante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //inicializo binding:
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //asociar
        adapter = AdapterRestaurante(DataSet.getLista(),applicationContext)
        binding.listaRestaurantes.adapter = adapter
        binding.listaRestaurantes.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)



    }
}