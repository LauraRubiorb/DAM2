package com.example.compras.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.compras.R

class FiltrarDialog : DialogFragment() {

    private var listaCategorys: ArrayList<String> = ArrayList()
    private var listener: OnCategoryDialogListener? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        this.context = context
        listener = context as OnCategoryDialogListener
        super.onAttach(context)
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Seleccione la categoría por la cual desee filtrar: ")
        builder.setMultiChoiceItems(R.array.categorias, null)
        { _, pos, isChecked ->
            // ejecuto
            if (isChecked){
                listaCategorys.add(resources.getStringArray(R.array.categorias)[pos])
            } else {
                listaCategorys.remove(resources.getStringArray(R.array.categorias)[pos])
            }
        }

        builder.setPositiveButton("OK") { _, _ ->
            for (i in listaCategorys){
                listener?.onCategorySelected(i)
            }
        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        this.listener = null

    }

    interface OnCategoryDialogListener {
        fun onCategorySelected(category: String)
    }

}