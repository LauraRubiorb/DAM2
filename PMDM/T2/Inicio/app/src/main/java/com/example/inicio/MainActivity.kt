package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),OnClickListener {
    lateinit var botonPulsar: Button
    lateinit var botonVaciar: Button
    lateinit var name: EditText
    lateinit var phone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
    }

    private fun instancias() {
        botonPulsar = findViewById(R.id.boton_pulsar)
        botonVaciar = findViewById(R.id.boton_vaciar)
        name = findViewById(R.id.edit_nombre)
        phone = findViewById(R.id.edit_telefono)

    }

    private fun acciones() {
        //necesita por parametro una funcion->view->lo que genera el evento
        botonPulsar.setOnClickListener {
            if (!name.text.isEmpty() && phone.text.isEmpty()) {
                //hay cosas dentro
                var noti2 = Snackbar.make(it, "${resources.getString(R.string.text_continuar1)} " +
                        "${name.text} ${resources.getString(R.string.text_continuar1)}" , Snackbar.LENGTH_INDEFINITE).show()

            } else {
                Snackbar.make(it, "Faltan Datos", Snackbar.LENGTH_LONG).show()
            }

        }
        botonPulsar.setOnClickListener {
            var noti2 = Snackbar.make(it, R.string.text_continuar, Snackbar.LENGTH_LONG)
            noti2.setAction(R.string.text_pulsar) {
                //ocultar la notificación
                noti2.dismiss()
            }
            noti2.show()
        }
        botonVaciar.setOnClickListener(this)
        
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.boton_pulsar->{}
            R.id.boton_vaciar->{}
        }

    }
}