package com.example.proyectojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectojson.adaptador.AdaptadorUsers
import com.example.proyectojson.databinding.ActivityMainBinding
import com.example.proyectojson.model.User
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader

class MainActivity : AppCompatActivity() , OnItemSelectedListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdaptadorUsers
    private lateinit var listaUsers: ArrayList<User>
    private lateinit var adapatadorResultados: ArrayAdapter<Int>
    private lateinit var genero : String
    private var resultado : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaUsers = ArrayList()

        adapter = AdaptadorUsers(listaUsers, this)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        adapatadorResultados = ArrayAdapter(this,android.R.layout.simple_spinner_item,(1..100).toList())
        adapatadorResultados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerNumeros.adapter = adapatadorResultados

        //creamos la peticion


        val url = "https://randomuser.me/api/?results=50"

        //activar el internet

        val peticion: JsonObjectRequest = JsonObjectRequest(url,
            {
                Log.v("conexion", "conexion correcta")
                getUsers(it)
            }, {
                Log.v("conexion", "conexion incorrecta")

            }) //url+primerObjeto+errores

        //lanzamos la peticion

        Volley.newRequestQueue(applicationContext).add(peticion)


        //otra peticion para configurar parametros
        //val peticion2 : JsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,{},{})

    }



    fun getUsers(response: JSONObject): Unit {
        val results = response.getJSONArray("results")
        for (i in (0..results.length() - 1)) {
            val user = results.getJSONObject(i)
            val first = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val phone = user.getString("phone")
            val email = user.getString("email")
            val image = user.getJSONObject("picture").getString("medium")
            val country = user.getJSONObject("location").getString("country")
            val city = user.getJSONObject("location").getString("city")


            listaUsers.add(User(first, last, phone, country, city,  email, image))
            adapter.notifyItemInserted(listaUsers.size-1)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //traer el menu -> xml
        menuInflater.inflate(R.menu.main_menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    //gestionar la pulsacion del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_reset->{
                //cambiar spinners
                //cambiar url
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    //HACER: si pulsas en cualquier lado longclick: sale un snacbar -> quieres ver los detalles del usuario OK
    //segunda pantalla con la imagen del user, icono de email y sale email, lo mismo con telefono, y abajo cargamos la
    //direccion completa
    //si pulsa en el text de email arranca email poniendo PARA: y el nombre de email sendTo()
    // y el de telefono actionCall()
}