package com.example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Producto
import com.example.navegacion.R

class AdaptadorDetalles(var context: Context): RecyclerView.Adapter<AdaptadorDetalles.MyHolder>() {
    private var lista: ArrayList<Producto>
    init {
        lista = ArrayList()
    }


    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.item_detail, parent, false)
        return AdaptadorDetalles.MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Producto = lista[position]
    }
}