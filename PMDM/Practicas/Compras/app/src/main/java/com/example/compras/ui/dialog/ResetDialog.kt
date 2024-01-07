package com.example.compras.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.compras.R

class ResetDialog : DialogFragment() {

    private var listener: OnResetDialogListener? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        this.context = context
        listener = context as OnResetDialogListener
        super.onAttach(context)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("¿Desea resetear los filtros de busqueda?")
        builder.setPositiveButton("OK") { _, _ -> listener?.onResetClicked()}
        builder.setNegativeButton("CANCEL") { _, _ -> }

        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        this.listener = null

    }

    interface OnResetDialogListener {
        fun onResetClicked()


    }


}