package com.example.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.ui.R
import com.example.ui.model.Modelo

//extiendo de baseAdapter
class AdaptadorModelos (var listaModelos:ArrayList<Modelo>, var contexto : Context): BaseAdapter(){

    override fun getCount(): Int {
        //cuantos elementos tiene el elemento grafico
        return listaModelos.size
    }

    override fun getItem(position: Int): Modelo {
        //el elemento que esta en el spinner en una posicion concreta (position)
        return listaModelos[position]
    }

    override fun getItemId(position: Int): Long {
        // devuelve el id del elemento seleccionado en el spinner en una posicion (position)
        return position.toLong()
    }
    fun addModelo(modelo : Modelo){
        listaModelos.clear()
        listaModelos.add(modelo)
        notifyDataSetChanged()
    }
    fun setLista(lista: ArrayList<Modelo>){
        listaModelos.clear()
        listaModelos.addAll(lista)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    //retorna: la vista de cada fila
        //rellena la fila con los datos que le corresponden
            //posicion de la fila
            //convertView: la vista base: el xml
            //parent: conjunto de vistas: la fila
        //necesito el xml -> layout->id(elementos
        //objeto de la posicion
                          //convierte el xml en layout, le pasas el parent y le dices si va a ser siempre igual o no
        val view : View = LayoutInflater.from(contexto).inflate(R.layout.modelo_item,parent,false)
        val modelo = listaModelos[position]
        val imagenView : ImageView = view.findViewById(R.id.imagen_modelo)
        val nombreText : TextView = view.findViewById(R.id.nombre_modelo)

        imagenView.setImageResource(modelo.imagen)
        nombreText.text = modelo.nombre

        return view
    }

}