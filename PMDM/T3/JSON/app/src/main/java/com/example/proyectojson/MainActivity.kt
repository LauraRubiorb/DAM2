package com.example.proyectojson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.proyectojson.adaptador.UsuariosAdapter
import com.example.proyectojson.databinding.ActivityMainBinding
import com.example.proyectojson.model.User
import com.example.proyectojson.ui.dialog.GeneroSimpleDialog
import com.example.proyectojson.ui.dialog.ListaGeneroDialog
import com.example.proyectojson.ui.dialog.NacionalidadDialog
import com.example.proyectojson.ui.dialog.NumerosDialog
import com.example.proyectojson.ui.dialog.Personalizado_Dialog
import com.example.proyectojson.ui.dialog.VersionDialog
import com.example.t3_listajson.ui.dialog.GeneralDialog
import com.google.android.material.snackbar.Snackbar


import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener,
    GeneroSimpleDialog.OnGeneroSimpleListener,
    NumerosDialog.OnNumerosDialogListener,
    ListaGeneroDialog.OnGeneroListaListener, GeneralDialog.OnGeneralDialogListener,
    NacionalidadDialog.OnNacionalidadListener, Personalizado_Dialog.OnDialogoPersoListener {

    private lateinit var listaUsuario: ArrayList<User>;
    private lateinit var adaptadoUsuariosAdapter: UsuariosAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorResultados: ArrayAdapter<Int>
    private lateinit var genero: String;
    private var resultados: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorResultados = ArrayAdapter(
            applicationContext,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, (1..100).toList()
        )
        adaptadorResultados.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
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
        listaUsuario.clear()
        adaptadoUsuariosAdapter.notifyDataSetChanged()
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
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent!!.id) {
            binding.spinnerResultados.id -> {
                resultados = parent.adapter.getItem(position).toString().toInt()
                // peticion
            }

            binding.spinnerGenero.id -> {
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
        menuInflater.inflate(com.example.proyectojson.R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_reset -> {
                getURLResponse("https://randomuser.me/api/?results=50");
                binding.spinnerResultados.setSelection(49)
                binding.spinnerGenero.setSelection(0)
            }

            R.id.menu_version -> {
                val versionDialog: VersionDialog = VersionDialog();
                versionDialog.show(supportFragmentManager, null)
            }

            R.id.menu_filtrar -> {
                //val filtroDialog = GeneralDialog()
                //filtroDialog.show(supportFragmentManager, null)
                val persoDialog = Personalizado_Dialog()
                persoDialog.show(supportFragmentManager,null)

            }

            R.id.menu_nacionalidad -> {
                val dialog = NacionalidadDialog()
                dialog.show(supportFragmentManager, null)
            }
        }
        return true
    }

    override fun onNumeroSelected(i: String) {
        getURLResponse("https://randomuser.me/api/?results=$=${i}")
        if (i.equals("1")) {
            binding.spinnerResultados.setSelection(0)
        } else if (i.equals("50")) {
            binding.spinnerResultados.setSelection(49)
        } else if (i.equals("100")) {
            binding.spinnerResultados.setSelection(99)
        }

    }


    override fun onGeneroSimpleSelected(genero: String) {
        TODO("Not yet implemented")
    }

    override fun onGeneroListaSelected(genero: String) {
        TODO("Not yet implemented")
    }

    override fun onGeneralSelected(filtro: String) {
        lateinit var dialog: DialogFragment
        when (filtro) {
            "genero" -> {
                dialog = GeneroSimpleDialog()
            }

            "numero" -> {
                dialog = NumerosDialog()
            }
        }
        dialog.show(supportFragmentManager, null)
    }

    override fun onDialogoNacionalidadSelected(nacionalidades: ArrayList<String>) {
        var nac = ""
        nacionalidades.forEachIndexed { index, item ->
            if (index != nacionalidades.size-1){
                nac +="$item,"
            }else{
                nac+=item
            }
        }
        getURLResponse("https://randomuser.me/api/?results=${resultados}&gender=${genero.toLowerCase()}&nat=${nac}")
        Snackbar.make(binding.root, nac.toString(), Snackbar.LENGTH_SHORT).show()


    }

    override fun onPersonalizadoSelected(genero: String, resultados: Int) {
        getURLResponse("https://randomuser.me/api/?results=${resultados}&gender=${genero.toLowerCase()}")

    }
}


