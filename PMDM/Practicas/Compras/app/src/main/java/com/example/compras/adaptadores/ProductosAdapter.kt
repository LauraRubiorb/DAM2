package com.example.compras.adaptadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.compras.R
import com.example.compras.model.Producto

class ProductosAdapter(
    var listaProductos: ArrayList<Producto>,
    var context: Context
) :
    RecyclerView.Adapter<ProductosAdapter.MyHolder>() {

    private var listener: OnProductoSelected

    init {
        listener = context as OnProductoSelected
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var nombre: TextView
        var imagenProducto: ImageView
        var botonDetalle: Button
        var botonComprar: Button

        init {
            nombre = item.findViewById(R.id.text_nombre)
            imagenProducto = item.findViewById(R.id.imagen_producto)
            botonDetalle = item.findViewById(R.id.button_detalle)
            botonComprar = item.findViewById(R.id.button_comprar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(context).inflate(R.layout.productos_recycler, parent, false)
        return MyHolder(vista)

    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item = listaProductos[position]
        holder.nombre.text = item.title
        Glide.with(context).load(item.thumbnail).into(holder.imagenProducto)

        holder.botonComprar.setOnClickListener {
            //comunicar al main
            listener.onButtonComprarClicked(item)

        }
        holder.botonDetalle.setOnClickListener {
            //comunicar a la pantalla detalle
            listener.onButtonDetalleClicked(item)
        }
    }

    interface OnProductoSelected {
        fun onButtonComprarClicked(producto: Producto)
        fun onButtonDetalleClicked(producto: Producto)
    }
}