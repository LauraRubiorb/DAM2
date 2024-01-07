package com.example.compras.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compras.R
import com.example.compras.model.Producto

class DetalleAdapter(var context: Context, var listaImagenes: ArrayList<String>) :
    RecyclerView.Adapter<ProductosAdapter.MyHolder>() {

    class Holder(item: View) : RecyclerView.ViewHolder(item) {
        var imagenes: ImageView

        init {
            imagenes = item.findViewById(R.id.imagen_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosAdapter.MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.detalle_recycler, parent, false)
        return ProductosAdapter.MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaImagenes.size
    }

    override fun onBindViewHolder(holder: ProductosAdapter.MyHolder, position: Int) {
        val item = listaImagenes[position]
       Glide.with(context).load(item).into(holder.imagenProducto)
    }
}