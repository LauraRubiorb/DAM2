package com.example.proyectojson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.proyectojson.R

class NacionalidadDialog : DialogFragment() {

    private lateinit var context: Context
    private var listener: OnNacionalidadListener? = null
    private var nacionalidades : ArrayList<String> = ArrayList()

    override fun onAttach(context: Context) {
        this.context = context
        listener = context as OnNacionalidadListener
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Selecciona las nacionalidades a mostrar:")
        //set multriplechoice
        builder.setMultiChoiceItems(R.array.nacionalidades,null){_,position,isCheck ->
            if (isCheck){
                nacionalidades.add(resources.getStringArray(R.array.nacionalidades)[position])
            }else{
                nacionalidades.remove(resources.getStringArray(R.array.nacionalidades)[position])

            }
        }

        builder.setPositiveButton("OK") { _, _ ->
            //comunico
            listener?.onDialogoNacionalidadSelected(nacionalidades)
        }

        return builder.create()
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    interface OnNacionalidadListener {
        fun onDialogoNacionalidadSelected(nacionalidades: ArrayList<String>)
    }

}