package com.example.proyectojson

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectojson.adaptador.UsuariosAdapter
import com.example.proyectojson.databinding.ActivityMainBinding
import com.example.proyectojson.model.User
import com.example.proyectojson.ui.dialog.FiltrarDialog
import com.example.proyectojson.ui.dialog.VersionDialog
import com.google.android.material.snackbar.Snackbar


import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener, FiltrarDialog.OnFiltradoDialogListener {

    private lateinit var listaUsuario: ArrayList<User>;
    private lateinit var adaptadoUsuariosAdapter: UsuariosAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorResultados: ArrayAdapter<Int>
    private lateinit var genero: String;
    private  var resultados: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adaptadorResultados = ArrayAdapter(applicationContext,
            R.layout.simple_spinner_item,(1..100).toList())
        adaptadorResultados.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerResultados.adapter = adaptadorResultados

        listaUsuario = ArrayList();
        adaptadoUsuariosAdapter = UsuariosAdapter(listaUsuario, this)

        binding.recyclerUsuarios.adapter = adaptadoUsuariosAdapter;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // creo la peticion

    }

    fun getURLResponse(url: String): Unit {

        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            getUsers(it)
        }, {

        })
        //val peticion2: JsonObjectRequest = JsonObjectRequest(Method.GET,url,null,{},{})
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onStart() {
        super.onStart()
        binding.spinnerResultados.onItemSelectedListener = this
        binding.spinnerGenero.onItemSelectedListener = this
    }

    fun getUsers(response: JSONObject): Unit {
        // crear clase modelo User
        // obtener una lista de todos los usuarios del JSON
        val results = response.getJSONArray("results")
        for (i in (0..results.length() - 1)) {
            val user = results.getJSONObject(i);
            val name = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val phone = user.getString("phone");
            val email = user.getString("email");
            val image = user.getJSONObject("picture").getString("medium")
            val country = user.getJSONObject("location").getString("country")

            val city = user.getJSONObject("location").getString("city")
            val usuario = User(name, last, email, phone, country, city, image)
            listaUsuario.add(
                usuario
            )
            adaptadoUsuariosAdapter.notifyItemInserted(listaUsuario.size - 1)
        }
        // nombre, apellido, telefono, pais, ciudad, codigo postal, mail

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent!!.id){
            binding.spinnerResultados.id->{
                resultados = parent.adapter.getItem(position).toString().toInt()
                // peticion
            }
            binding.spinnerGenero.id->{
                genero = parent.adapter.getItem(position).toString()
                // peticion
            }
        }

        listaUsuario.clear()
        adaptadoUsuariosAdapter.notifyDataSetChanged()

        getURLResponse("https://randomuser.me/api/?results=${resultados}&gender=${genero.toLowerCase()}")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        // traer el menu -> xml
        //menuInflater.inflate(R.menu.,menu)
        menuInflater.inflate(com.example.proyectojson.R.menu.menu_main , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            com.example.proyectojson.R.id.menu_reset->{
                getURLResponse("https://randomuser.me/api/?results=50");
                binding.spinnerResultados.setSelection(49)
                binding.spinnerGenero.setSelection(0)
            }
            com.example.proyectojson.R.id.menu_version->{
                val versionDialog: VersionDialog = VersionDialog();
                versionDialog.show(supportFragmentManager,null)
            }
            com.example.proyectojson.R.id.menu_filtrar->{
                val filtroDialog : FiltrarDialog = FiltrarDialog()
                filtroDialog.show(supportFragmentManager,null)
            }
        }
        return true
    }

    override fun onGeneroSelected(genero: String) {
        Snackbar.make(binding.root,"seleccionado ${genero}",Snackbar.LENGTH_SHORT).show()

        //PARA EL JUEVES:
        /*
        el menu filtrar -> pulsar aparece un cuadro de dialogo donde te dice, porque quieres filtrar : -genero -numero
        -genero -> el cuadro de dialgoo ya hecho y hacer el filtro
        -num -> que cantidad quieres mostrar 1    50    100 y filtrar, cuadro dialgo
         */
    }
}