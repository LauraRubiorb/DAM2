package com.example.comprasapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comprasapp.R
import com.example.comprasapp.model.Producto

class AdaptadorMarcas(var listaProductos: ArrayList<Producto>, var context: Context) :
    RecyclerView.Adapter<AdaptadorMarcas.MyHolder>() {

    var listener: OnRecyclerProductoSelected

    init {
        listener = context as OnRecyclerProductoSelected

    }


    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var logoMarca: ImageView
        var textNombre: TextView
        var botonAdd: ImageButton

        init {
            logoMarca = item.findViewById(R.id.imagenProducto)
            textNombre = item.findViewById(R.id.nombreProducto)
            botonAdd = item.findViewById(R.id.botonAdd)
        }
    }
    fun addProducto(item: Producto): Unit {
        listaProductos.add(item)
        notifyItemInserted(listaProductos.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = listaProductos[position]
        if (item.marca == "Nike"){
            holder.textNombre.setText(item.nombre)
            Glide.with(context).load(item.imagen).into(holder.logoMarca)

            holder.botonAdd.setOnClickListener {
                listener.OnItemSelected(item)

            }
        }else if (item.marca == "Adidas"){
            holder.textNombre.setText(item.nombre)
            Glide.with(context).load(item.imagen).into(holder.logoMarca)

            holder.botonAdd.setOnClickListener {
                listener.OnItemSelected(item)

            }
        }else{
            holder.textNombre.setText(item.nombre)
            Glide.with(context).load(item.imagen).into(holder.logoMarca)

            holder.botonAdd.setOnClickListener {
                listener.OnItemSelected(item)

            }
        }

    }

    interface OnRecyclerProductoSelected {
        fun OnItemSelected(item: Producto)

    }




}