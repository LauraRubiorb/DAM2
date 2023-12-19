package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.proyectojson.R

class GeneroSimpleDialog : DialogFragment() {

    private var listener: OnGeneroSimpleListener? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        this.context = context
        this.listener = context as OnGeneroSimpleListener
        super.onAttach(context)
    }

    //otra forma -> donde aparecen listas

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Por que genero quieres filtrar")
        builder.setSingleChoiceItems(R.array.genero,-1){_,pos ->

        }
        builder.setPositiveButton("OK"){_,_ ->}
        return builder.create()
    }

    override fun onDetach() { //metodo que se ejecuta cuando el cuadro de dialogo desaparece
        listener = null
        super.onDetach()
    }

    interface OnGeneroSimpleListener {
        fun onGeneroSimpleSelected(genero: String)
    }
}