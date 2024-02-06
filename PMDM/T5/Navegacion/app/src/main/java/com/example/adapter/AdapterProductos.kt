package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.example.model.Producto
import com.example.navegacion.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import org.json.JSONObject

class AdapterProductos(var context: Context) : RecyclerView.Adapter<AdapterProductos.MyHolder>() {

    private var lista: ArrayList<Producto?>
    private lateinit var auth: FirebaseAuth;


    init {
        lista = ArrayList()
        auth = Firebase.auth
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        //crear el xml de las filas
        var toolbar: androidx.appcompat.widget.Toolbar
        var imagen: ImageView

        init {
            toolbar = view.findViewById(R.id.toolbar_carta)
            toolbar.inflateMenu(R.menu.item_menu)
            imagen = view.findViewById(R.id.imagen_producto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_producto, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Producto = lista[position]!!

        holder.toolbar.title = item.title

        //poner un menu en el toolbar
        //holder.toolbar.inflateMenu(R.menu.item_menu)
        //escuchamos al menu
        holder.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu_fav_item->{
                    val database = FirebaseDatabase.getInstance("https://lrr-ces-default-rtdb.europe-west1.firebasedatabase.app/")
                    var  user_producto = database.getReference("usuarios").child(auth.currentUser!!.uid).child("favoritos")
                    user_producto.child(item.id.toString()).setValue(item)
                }
            }
            return@setOnMenuItemClickListener true
        }
        Glide.with(context).load(item.thumbnail).into(holder.imagen)
    }

        fun addProducto(item:Producto?){
            lista.add(item)
            notifyItemInserted(lista.size-1)
        }

}