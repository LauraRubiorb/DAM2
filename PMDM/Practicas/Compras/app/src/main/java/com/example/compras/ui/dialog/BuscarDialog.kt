package com.example.compras.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.compras.R
import com.google.android.material.snackbar.Snackbar

class BuscarDialog : DialogFragment() {

    private var listener: OnBuscarDialogListener? = null
    private lateinit var context: Context
    private lateinit var vista: View
    private lateinit var text_palabra: EditText
    private lateinit var boton_cancel: Button
    private lateinit var boton_ok: Button


    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        this.vista = LayoutInflater.from(context).inflate(R.layout.buscar_dialog, null)

        listener = context as OnBuscarDialogListener
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(vista)
        text_palabra = vista.findViewById(R.id.text_palabra)
        boton_cancel = vista.findViewById(R.id.boton_cancel)
        boton_ok = vista.findViewById(R.id.boton_ok)

        boton_ok.setOnClickListener {
            if (text_palabra.text.equals("")) {
                Toast.makeText(this.context,"Faltan datos",Toast.LENGTH_SHORT).show()
            } else {
                listener?.onButtonOKSelected(text_palabra.text.toString())
            }
            dismiss()
        }
        boton_cancel.setOnClickListener {
            dismiss()
        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        this.listener = null

    }

    interface OnBuscarDialogListener {
        fun onButtonOKSelected(x: String)
    }

}