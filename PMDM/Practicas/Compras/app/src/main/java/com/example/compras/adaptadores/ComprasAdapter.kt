package com.example.compras.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compras.R
import com.example.compras.model.Producto

class ComprasAdapter(var context: Context, var listaProductos: ArrayList<Producto>) :
    RecyclerView.Adapter<ComprasAdapter.Holder>() {

    class Holder(item: View) : RecyclerView.ViewHolder(item) {
        var imagenes: ImageView
        var nombre: TextView
        var precio: TextView

        init {
            nombre = item.findViewById(R.id.text_nombre)
            precio = item.findViewById(R.id.text_precio)
            imagenes = item.findViewById(R.id.imagen_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComprasAdapter.Holder {
        val vista = LayoutInflater.from(context).inflate(R.layout.compras_recycler, parent, false)
        return Holder(vista)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val producto = listaProductos[position]
        holder.nombre.text = producto.title
        holder.precio.text = producto.price.toString()
        Glide.with(context).load(producto.thumbnail).into(holder.imagenes)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }


}