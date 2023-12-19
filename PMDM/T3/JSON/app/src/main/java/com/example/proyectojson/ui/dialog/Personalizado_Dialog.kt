package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import com.example.proyectojson.R

class Personalizado_Dialog : DialogFragment() {
    private lateinit var context: Context
    private var listener: OnDialogoPersoListener? = null
    private lateinit var vista: View
    private lateinit var spinnerGeneros : Spinner
    private lateinit var spinnerNumeros : Spinner//configurar el spinner numeros -> adaptador
    private lateinit var adapterNumeros : ArrayAdapter<Int>
    private lateinit var boton : Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        this.listener = context as OnDialogoPersoListener
        this.vista = LayoutInflater.from(context).inflate(R.layout.dialogo_filter, null)
        this.adapterNumeros = ArrayAdapter(context,android.R.layout.simple_spinner_item,(1..100).toList())//lista pasada a coleecion
        this.adapterNumeros.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(vista)
        //inicializar lo grafico

        spinnerNumeros = vista.findViewById(R.id.spinnerResultados)
        spinnerGeneros = vista.findViewById(R.id.spinnerGenero)
        boton = vista.findViewById(R.id.boton)

        spinnerNumeros.adapter = adapterNumeros

        boton.setOnClickListener{
            listener?.onPersonalizadoSelected(spinnerGeneros.selectedItem.toString(),spinnerNumeros.selectedItem.toString().toInt())
            dismiss()
        }

        return builder.create()
    }


    override fun onDetach() {
        super.onDetach()
    }

    interface OnDialogoPersoListener {
        fun onPersonalizadoSelected(genero: String, resultados: Int)
    }


}