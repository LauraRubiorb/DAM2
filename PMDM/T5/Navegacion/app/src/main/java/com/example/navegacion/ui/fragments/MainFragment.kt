package com.example.navegacion.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.adapter.AdapterProductos
import com.example.model.Producto
import com.example.navegacion.databinding.FragmentMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class MainFragment : Fragment() {
    private var binding: FragmentMainBinding? = null
    private lateinit var adatador: AdapterProductos
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = Firebase.auth
        adatador = AdapterProductos(context)
        database =
            FirebaseDatabase.getInstance("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return this.binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerMainFragment?.adapter = adatador
        binding?.recyclerMainFragment?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding!!.editFragmentMainNombre.setText(arguments?.getString("nombre"))

        //getAllProducts()
        //database.getReference("nombre").setValue("Prueba")
        //database.getReference("apellido").setValue("Prueba")

        binding!!.buttonEscuchar.setOnClickListener {
            val referece =
                database.getReference("usuarios").child(auth.currentUser!!.uid).child("favoritos")

            referece.addListenerForSingleValueEvent(object :
                ValueEventListener { //le ponemos un objeto anonimo y creamos la interfaz
                override fun onDataChange(snapshot: DataSnapshot) {
                    //el datasanpshot es cada uno de los hijos
                    val hijos = snapshot.children
                    hijos.forEach {
                        //Log.v("datos",it.value.toString())
                        val producto = it.getValue(Producto::class.java)
                        val itemProducto = Producto(producto?.title,producto?.price,producto?.description,producto?.category,producto?.thumbnail,producto?.id,producto?.images)
                        adatador.addProducto(itemProducto)

                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

        }


    }

    //"https://dummyjson.com/products"
    /*
    private fun getAllProducts() {
        val peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products", {
            val productos = it.getJSONArray("products")
            for (i in 0 until productos.length()) {
                var lista_images: ArrayList<String> = ArrayList()
                val item = productos.getJSONObject(i)
                val imagenes = item.getJSONArray("images")
                for (j in 0..imagenes.length()) {
                    val imagen = imagenes.getJSONObject(j)
                    lista_images.add(imagen.toString())
                }
                val itemProducto = Producto(
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("description"),
                    item.getString("category"),
                    item.getString("thumbnail"),
                    item.getInt("id"),
                    imagenes = lista_images
                )
                adatador.addProducto(itemProducto)
            }
        }, {})
        Volley.newRequestQueue(context).add(peticion)


    }*/
}