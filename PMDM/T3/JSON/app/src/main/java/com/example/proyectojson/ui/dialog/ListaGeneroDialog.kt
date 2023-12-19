package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.proyectojson.R

class ListaGeneroDialog : DialogFragment() {

    private var listener: OnGeneroListaListener? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        this.context = context
        this.listener = context as OnGeneroListaListener
        super.onAttach(context)
    }

    //otra forma -> donde aparecen listas

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Por que genero quieres filtrar")
        val genero = builder.setItems(R.array.genero) { _, posicion -> resources.getStringArray(R.array.genero)[posicion] }
        Toast.makeText(this.context, genero.toString(), Toast.LENGTH_SHORT).show()
        return builder.create()
    }

    override fun onDetach() { //metodo que se ejecuta cuando el cuadro de dialogo desaparece
        listener = null
        super.onDetach()
    }

    interface OnGeneroListaListener {
        fun onGeneroListaSelected(genero: String)
    }
}