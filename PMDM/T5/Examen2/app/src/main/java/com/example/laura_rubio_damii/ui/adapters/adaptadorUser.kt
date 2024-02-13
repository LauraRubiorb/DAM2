package com.example.laura_rubio_damii.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.laura_rubio_damii.R
import com.example.laura_rubio_damii.ui.model.Post
import com.example.laura_rubio_damii.ui.model.User

class adaptadorUser(var context: Context): RecyclerView.Adapter<adaptadorUser.MyHolder>() {
    private var listaUser = ArrayList<User>()

    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        lateinit var email: TextView
        lateinit var contador : TextView
        init {
            email = view.findViewById(R.id.textView_body)
            contador = view.findViewById(R.id.textView_contador)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.user_detail,parent,false)
        return adaptadorUser.MyHolder(view)
    }

    override fun getItemCount(): Int {
    return listaUser.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var user: User = listaUser.get(position) as User
    }
}