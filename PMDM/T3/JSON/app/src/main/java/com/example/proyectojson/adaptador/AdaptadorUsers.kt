package com.example.proyectojson.adaptador

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectojson.R
import com.example.proyectojson.model.User

class AdaptadorUsers(var listaUsers: ArrayList<User>, var context: Context) :
    RecyclerView.Adapter<AdaptadorUsers.MyHolder>() {

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var textoNombre: TextView
        var textoApellido: TextView
        var imagen : ImageView

        init {
            textoNombre = item.findViewById(R.id.textName)
            textoApellido = item.findViewById(R.id.textSurname)
            imagen = item.findViewById(R.id.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaUsers.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = listaUsers[position]
        holder.textoNombre.setText(item.first)
        holder.textoApellido.setText(item.last)
        Glide.with(context).load(item.picture).into(holder.imagen)

    }
}