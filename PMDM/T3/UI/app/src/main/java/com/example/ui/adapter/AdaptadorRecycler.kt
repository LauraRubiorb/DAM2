package com.example.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ui.DetailActivity
import com.example.ui.R
import com.example.ui.model.Modelo

class AdaptadorRecycler (var lista : ArrayList<Modelo>, var contexto : Context): RecyclerView.Adapter<AdaptadorRecycler.MyHolder>(){
    private lateinit var listener: OnModeloListener
    init {
        listener = contexto as OnModeloListener
    }
    class MyHolder (item: View): ViewHolder(item){
        //sacamos los elementos
        var imagen : ImageView
        var nombre : TextView
        var precio : TextView
        var botonDetalle : Button
        var botonComparar : Button

        init{
            imagen = item.findViewById(R.id.imagen_modelo)
            nombre = item.findViewById(R.id.text_modelo)
            precio = item.findViewById(R.id.text_precio)
            botonDetalle = item.findViewById(R.id.boton_detalle)
            botonComparar = item.findViewById(R.id.boton_comparar)
        }
    }

    override fun getItemCount(): Int {
        //el numero de los elementos a pintar

        return lista.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //crea un patron
        val view : View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        //especificar los patrones y juntar los datos
        val item : Modelo = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.nombre.text = item.nombre
        holder.precio.text = item.precio.toString()
        holder.botonComparar.setOnClickListener{
            listener.onModeloSelected(item)
        }
        holder.botonDetalle.setOnClickListener{
            val intent = Intent(contexto, DetailActivity::class.java)
            intent.putExtra("modelo",item)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }
        holder.imagen.setOnLongClickListener{
            lista.removeAt(position)
            notifyDataSetChanged()
            return@setOnLongClickListener true
        }

    }
    interface OnModeloListener{
        fun onModeloSelected(modelo: Modelo)
    }
}