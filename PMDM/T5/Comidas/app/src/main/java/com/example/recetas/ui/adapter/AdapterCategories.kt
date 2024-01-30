package com.example.recetas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recetas.R
import com.example.recetas.model.category

class AdapterCategories(var context: Context) : RecyclerView.Adapter<AdapterCategories.MyHolder>() {

    private lateinit var lista_categories: ArrayList<category>

    init {
        lista_categories = ArrayList()
    }

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        var imagen: ImageView
        var texto_comida: TextView
        var boton: Button

        init {
            imagen = item.findViewById(R.id.imagen_comida_detail)
            texto_comida = item.findViewById(R.id.text_category_detail)
            boton = item.findViewById(R.id.boton_detalle_detail)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista =
            LayoutInflater.from(context).inflate(R.layout.detail_recycler_categories, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista_categories.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: category = lista_categories[position]
        holder.texto_comida.text = item.strCategory
        Glide.with(context).load(item.strCategoryThumb).into(holder.imagen)
    }

    fun addCategory(item: category) {
        lista_categories.add(item)
        notifyItemInserted(lista_categories.size - 1)
    }
}