package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class VersionDialog : DialogFragment() {

    //fragments: elementos que aparecen y desaparecen en una misma pantalla
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        this.context = context


        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //me devuelve un cuadro de dialogo: metodo que lanza el cuadro y pone la vista

        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("App Listas JSON")
        builder.setMessage("Versión 1.0 de al app realizada por LRR")
        builder.setPositiveButton("OK")
        { _, _ ->
            Toast.makeText(context, "Pulsado OK", Toast.LENGTH_SHORT).show()
        } //si no me interesa _

        return builder.create()
    }
}