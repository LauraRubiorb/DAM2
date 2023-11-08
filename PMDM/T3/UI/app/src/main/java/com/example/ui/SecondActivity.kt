package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ui.databinding.ActivitySecondBinding
import com.example.ui.model.Marca
import com.example.ui.model.Usuario
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class SecondActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivitySecondBinding
    private  var usuario : Usuario? = null
    private  var marca : Marca? = null
    private lateinit var listaMarcas : ArrayList<Marca>
    private lateinit var adapatadorMarcas : ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList()
        val m1 = Marca("Ford",3.5,R.drawable.ford)
        val m2 = Marca("Mercedes",4.8,R.drawable.mercedes)
        val m3 = Marca("Mini",4.5,R.drawable.mini)
        listaMarcas.add(m1)
        listaMarcas.add(m2)
        listaMarcas.add(m3)
        adapatadorMarcas = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaMarcas)

    }

    override fun onStart() {
        super.onStart()
        //cambios graficos
            //poner el correo en su sitio
        binding.textNombre.text = usuario?.email?: "Invitado"
        binding.spinnerMarcas.adapter = adapatadorMarcas
        adapatadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        //cambio imagen segun la marca
        if (marca?.nombre.equals("ford",true)){
            binding.imagenCoche.setImageResource(R.drawable.ford)
        }else if (marca?.nombre.equals("mini",true)){
            binding.imagenCoche.setImageResource(R.drawable.mini)
        }else if (marca?.nombre.equals("mercedes",true)){
            binding.imagenCoche.setImageResource(R.drawable.mercedes)
        }

    }

    override fun onResume() {
        super.onResume()
        //acciones
        binding.imagenOut.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.imagenOut.id->{
                finish()
            }
        }
    }

}