package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.proyectojson.R

class InfoDialog : DialogFragment() {
    private lateinit var context: Context
    private lateinit var vista: View
    private lateinit var texto: TextView
    private lateinit var textoComunicar: String
    private var edadComunicar: Int ? = 0

    companion object {
        fun newInstance(nombre: String, edad: Int): InfoDialog {
            val infoDialog: InfoDialog = InfoDialog()

            val bundle = Bundle()
            bundle.putString("nombre", nombre)
            bundle.putInt("edad",edad)
            infoDialog.arguments = bundle
            return infoDialog
        }
    }

    override fun onAttach(context: Context) {
        this.context = context
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_info, null)
        textoComunicar = this.arguments?.getString("nombre") ?: "sin nombre"
        edadComunicar = this.arguments?.getInt("edad")?: 0
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        texto = vista.findViewById(R.id.textoNombre)
        builder.setView(vista)
        texto.text = textoComunicar
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }
}