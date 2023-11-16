package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui.adapter.AdaptadorModelos
import com.example.ui.adapter.AdaptadorRecycler
import com.example.ui.data.DataSet
import com.example.ui.databinding.ActivitySecondBinding
import com.example.ui.model.Marca
import com.example.ui.model.Modelo
import com.example.ui.model.Usuario
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

/*           RELLENAR UN SPINNER
    1-ENTRIES:XML -> datos estaticos
    2-Simple: ArrayAdapter -> datos dinámicos y con la vista vase
    3-Personalizado-> dinamico y con dif vista: necesitare:
        -xml
        -fichero que indique como se rellena el xml : BASEADAPTER
        */

class SecondActivity : AppCompatActivity(), OnClickListener,AdapterView.OnItemSelectedListener, AdaptadorRecycler.OnModeloListener {
    private lateinit var binding: ActivitySecondBinding
    private  var usuario : Usuario? = null
    private lateinit var listaMarcas : ArrayList<Marca>
    private lateinit var adapatadorMarcas : ArrayAdapter<Marca>
    private lateinit var adapadorModelos : AdaptadorModelos
    private lateinit var listaModelos : ArrayList<Modelo>
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private var  modelo1 : Modelo ? = null
    private var  modelo2 : Modelo ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList()

        listaMarcas.add(Marca("Audi",4.5,R.drawable.audi))
        listaMarcas.add(Marca("Mercedes",4.8,R.drawable.mercedes))
        listaMarcas.add(Marca("Ford",3.5,R.drawable.ford))

        adapatadorMarcas = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaMarcas)
        listaModelos = ArrayList()
        adapadorModelos = AdaptadorModelos(DataSet.getListaModelos(),this)


        //pasos para trabajar con un recyclerView
        adaptadorRecycler = AdaptadorRecycler(DataSet.getListaModelos(),this)

    }

    override fun onStart() {
        super.onStart()
        //cambios graficos
            //poner el correo en su sitio
        binding.textNombre.text = usuario?.email?: "Invitado"
        binding.spinnerMarcas.adapter = adapatadorMarcas


        adapatadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner2.adapter = adapadorModelos

        binding.recyclerModelos.adapter = adaptadorRecycler
        binding.recyclerModelos.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)


    }

    override fun onResume() {
        super.onResume()
        //acciones
        binding.imagenOut.setOnClickListener(this)
        binding.spinnerMarcas.onItemSelectedListener = this
        binding.spinner2.onItemSelectedListener = this
        binding.botonAdd.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.imagenOut.id->{
                finish()
            }
            binding.botonAdd.id->{
                //añadir un modelo ->adaptador
               // adapadorModelos.addModelo(Modelo ("E-tron","Mercedes",400,150000,"Electruco",R.drawable.mercedesbenz))
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id){
            binding.spinnerMarcas.id->{
                val marca1 = binding.spinnerMarcas.selectedItem as Marca
                var lista : ArrayList<Modelo> = ArrayList()
                if (marca1.nombre.equals("Mercedes")){
                    //DataSet.getListaModelos().filter { it.marca.equals("Mercedes",true) }as ArrayList<Modelo>


                    //lista.add(Modelo("Benz","Mercedes",300,40000,"Familiar",R.drawable.mercedesbenz))
                    //lista.add(Modelo("220","Mercedes",400,250000,"Deportivo",R.drawable.mercedes220))
                }else if (marca1.nombre.equals("Audi")){
                    //lista.add(Modelo("RS6","Audi",340,150500,"Deportivo",R.drawable.audirs6))
                    //lista.add(Modelo("Etron","Audio",450,600000,"Clasico",R.drawable.audietron))

                }else if (marca1.nombre.equals("Ford")){
                    //lista.add(Modelo("GT40","Ford",300,100000,"Clasico",R.drawable.fordgt))
                    //lista.add(Modelo("Mustang","Ford",400,500000,"Deportivo",R.drawable.fordmust))

                }
                adapadorModelos.setLista(lista)


            }
            binding.spinner2.id->{
                val modelo = binding.spinner2.selectedItem as Modelo

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.adapter?.getItem(binding.spinner2.selectedItemPosition)
    }

    override fun onModeloSelected(modelo: Modelo) {
        if (modelo1==null){
            binding.imagenComparar1.setImageResource(modelo.imagen)
            modelo1 = modelo
        }
        else if (modelo1!=null && modelo2 == null){
            modelo2 = modelo
            binding.imagenComparar2.setImageResource(modelo.imagen)
        }else{
            modelo1 = modelo2
            binding.imagenComparar1.setImageResource(modelo1!!.imagen)
            modelo2 = modelo
            binding.imagenComparar2.setImageResource(modelo.imagen)

        }
    }

}