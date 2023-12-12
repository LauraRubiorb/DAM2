package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class FiltrarDialog : DialogFragment() {

    private lateinit var context: Context
    private var listener :  OnFiltradoDialogListener? = null

    override fun onAttach(context: Context) { //primer metodo en el ciclo de vida -> asociar el cuadro a la pantalla
        this.context = context
        this.listener = context as OnFiltradoDialogListener
        super.onAttach(context)
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Filtrar")
        builder.setMessage("¿Porqué genero quieres filtrar?")
        builder.setNeutralButton("ALL") { _, _ ->listener?.onGeneroSelected("all") }
        builder.setNegativeButton("MALE") { _, _ -> listener?.onGeneroSelected("male")}
        builder.setPositiveButton("FEMALE") { _, _ -> listener?.onGeneroSelected("female")}

        //gestionamos la pulsacion del boton aqui y el filtrado en el main

        return builder.create()
    }
    //interfaces de call back
    //1. creamos la interfaz
    //2. ejecutar el metodo de la interfaz (necesito un objeto)
    //3. inicializo la interfaz
    //4. implementar la interfaz en la clase destino


    interface OnFiltradoDialogListener {
        fun onGeneroSelected(genero: String): Unit
    }
}