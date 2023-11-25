package com.example.laura_rubio_dam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.laura_rubio_dam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inicializar binding:
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()

    }

    private fun acciones() {

        binding.spinnerUbicacion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                intent.putExtra("lugar",id)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
        binding.spinnerPuntuacion.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                intent.putExtra("puntos",id)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
        binding.spinnerComida.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                intent.putExtra("comida",id)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.botonBuscar.setOnClickListener {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
    }


}
