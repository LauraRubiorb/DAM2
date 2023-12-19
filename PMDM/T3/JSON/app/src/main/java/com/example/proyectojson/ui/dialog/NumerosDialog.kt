package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class NumerosDialog : DialogFragment() {

    private lateinit var context: Context
    private var listener: OnNumerosDialogListener? = null

    override fun onAttach(context: Context) {
        this.context = context
        this.listener = context as OnNumerosDialogListener
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Filtrar por numero")
        builder.setMessage("Seleccione el numero por el cual quieras filtrar")
        builder.setNeutralButton("1", { _, _ -> listener?.onNumeroSelected("1") })
        builder.setNegativeButton("50", { _, _ -> listener?.onNumeroSelected("50") })
        builder.setPositiveButton("100", { _, _ -> listener?.onNumeroSelected("100") })

        return builder.create()
    }

    interface OnNumerosDialogListener {
        fun onNumeroSelected(i: String)
    }
}