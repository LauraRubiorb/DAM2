package com.example.laura_rubio_dam2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laura_rubio_dam2.R
import com.example.laura_rubio_dam2.data.DataSet
import com.example.laura_rubio_dam2.model.Restaurante
import com.google.android.material.snackbar.Snackbar

class AdapterRestaurante(var lista: ArrayList<Restaurante>, var context: Context) :
    RecyclerView.Adapter<AdapterRestaurante.MyHolder>() {


    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imagen : ImageView
        val textoNombre : TextView
        val textoPuntos : TextView

        init {
            imagen = item.findViewById(R.id.imagenComida)
            textoNombre = item.findViewById(R.id.textView)
            textoPuntos  = item.findViewById(R.id.textoPuntuacion)
        }
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
        //holder.textoNombre.setText(item.nombre)
        //holder.textoPuntos.setText(item.puntuacion)

        holder.imagen.setOnClickListener{
            Snackbar.make(holder.imagen,"Telefono : ",Snackbar.LENGTH_LONG).show()
        }

    }




}