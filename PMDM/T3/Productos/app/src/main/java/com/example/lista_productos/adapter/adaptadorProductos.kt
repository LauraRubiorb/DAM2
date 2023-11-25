package com.example.lista_productos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lista_productos.R
import com.example.lista_productos.model.Producto

class adaptadorProductos(var lista: ArrayList<Producto>, var context: Context) :
    RecyclerView.Adapter<adaptadorProductos.MyHolder>() {

    var listener: OnRecyclerProductosListener
    init {
    listener = context as OnRecyclerProductosListener
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var carta: CardView
        var nombre: TextView
        var imagen: ImageView
        var compra : ImageButton

        init {
            carta = item.findViewById(R.id.carta)
            nombre = item.findViewById(R.id.nombre_producto)
            imagen = item.findViewById(R.id.imagen_producto)
            compra = item.findViewById(R.id.botonComprar)
        }
    }
    //RELLENAR DATOS:
    fun addProductos(item:Producto){
        lista.add(item)
        notifyItemInserted(lista.size-1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = lista[position]
        holder.nombre.text = item.nombre
        //utilizar la libreria glide
        Glide.with(context).load(item.imagen).placeholder(R.drawable.generica).into(holder.imagen)

        //dar funcion al boton
        holder.compra.setOnClickListener{
            //le pasamos la iterfaz cuando click
            listener.onProductoSelected(item)

        }

    }

    //me creo una interfaz
    interface OnRecyclerProductosListener{
        fun onProductoSelected(item : Producto)

    }
}