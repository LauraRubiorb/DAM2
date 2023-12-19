package com.example.vuelos.ui.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class HoraDialog : DialogFragment() {

    private lateinit var context: Context
    private var horaActual = 0
    private var minutosActual = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context

        val calendar = Calendar.getInstance()
        horaActual = calendar.get(Calendar.HOUR_OF_DAY)
        minutosActual = calendar.get(Calendar.MINUTE)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //builder: title y builderl.create AHORA NO
        //es algo q ya esta hecho

        return TimePickerDialog(context, context as OnTimeSetListener, horaActual, minutosActual, true)
    }

    override fun onDetach() {
        super.onDetach()
    }

}