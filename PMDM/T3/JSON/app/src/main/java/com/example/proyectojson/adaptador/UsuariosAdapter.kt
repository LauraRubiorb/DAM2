package com.example.proyectojson.adaptador

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.proyectojson.DetailActivity
import com.example.proyectojson.R
import com.example.proyectojson.model.User
import com.google.android.material.snackbar.Snackbar

class UsuariosAdapter(var listaUsers: ArrayList<User>, var context: Context) :
    RecyclerView.Adapter<UsuariosAdapter.MyHolder>() {

    private lateinit var listener: OnUserListener
    init {
        listener = context as OnUserListener
    }

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

    fun vaciarLista(): Unit {
        listaUsers.clear();
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = listaUsers[position]
        holder.textoNombre.setText(item.first)
        holder.textoApellido.setText(item.last)
        Glide.with(context).load(item.picture).into(holder.imagen)
        holder.textoNombre.setOnClickListener {
            listener.onUserSelected(item)
        }
        holder.imagen.setOnLongClickListener {

            Snackbar.make(
                holder.imagen,
                "Quieres ver los detalles del usuario",
                Snackbar.LENGTH_SHORT
            ).setAction("OK") {
                val intent = Intent(context, DetailActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("usuario",item)
                context.startActivity(intent)
            }.show()

            return@setOnLongClickListener true
        }

    }
    interface OnUserListener{
        fun onUserSelected(user : User)
    }
}