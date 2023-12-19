package com.example.vuelos.ui.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class FechaDialog : DialogFragment() {

    private lateinit var context: Context
    private var mesActual = 0
    private var diaActual = 0
    private var anioActual = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context

        val calendar = Calendar.getInstance()
        diaActual = calendar.get(Calendar.DAY_OF_MONTH)
        mesActual = calendar.get(Calendar.MONTH)
        anioActual = calendar.get(Calendar.YEAR)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //builder: title y builderl.create AHORA NO
        //es algo q ya esta hecho

        return DatePickerDialog(
            context,
            context as OnDateSetListener,
            anioActual,
            mesActual,
            diaActual
        )
    }

    override fun onDetach() {
        super.onDetach()
    }

}