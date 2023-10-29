package com.example.laurarubio_t2_pdmd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText
    private lateinit var button_H: Button
    private lateinit var button_M: Button
    private var peso: Int = 0
    private var altura: Double = 0.0
    private var imc: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            instancias()
            acciones()
        }else{
            imc = savedInstanceState?.getInt("imc")!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("imc",imc)
        outState.putInt("button_H",R.id.button_H)
        outState.putInt("button_M",R.id.button_M)
    }

    private fun acciones() {
        button_H.setOnClickListener(this)
        button_M.setOnClickListener(this)
    }

    private fun instancias() {
        button_H = findViewById(R.id.button_H)
        button_M = findViewById(R.id.button_M)
        editAltura = findViewById(R.id.edit_altura)
        editPeso = findViewById(R.id.edit_peso)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            //si hace click y esta vacio salta la primera noti
            R.id.button_H -> {
                if (editAltura.text.isEmpty() || editPeso.text.isEmpty()) {
                    var notificacion1 =
                        Snackbar.make(v, R.string.faltan_datos, Snackbar.LENGTH_LONG).show()
                } else {
                    //si no esta vacio guardamos el texto escrito, y calculamos el imc
                    //editPuntuacion.setText(puntuacion.toString())
                    peso = (editPeso.text.toString().toInt())
                    altura = (editAltura.text.toString().toDouble())
                    imc = (peso / (altura*altura)).toInt()
                    //creamos la noti2
                    var notificacion2 =
                        Snackbar.make(v, R.string.ver_IMC, Snackbar.LENGTH_INDEFINITE)
                    notificacion2.setAction(R.string.boton_OK) {
                        notificacion2.dismiss()
                        var intent = Intent(applicationContext, SecondActivity::class.java)
                        intent.putExtra("imc",imc)
                        intent.putExtra("button_H",R.id.button_H)
                        startActivity(intent)
                    }
                    notificacion2.show()
                }
            }

            R.id.button_M -> {
                if (editAltura.text.isEmpty() || editPeso.text.isEmpty()) {
                    var notificacion1 =
                        Snackbar.make(v, R.string.faltan_datos, Snackbar.LENGTH_LONG).show()
                } else {
                    peso = (editPeso.text.toString().toInt())
                    altura = (editAltura.text.toString().toDouble())
                    imc = (peso / (altura*altura)).toInt()
                    //creamos la noti2
                    var notificacion2 =
                        Snackbar.make(v, R.string.ver_IMC, Snackbar.LENGTH_INDEFINITE)
                    notificacion2.setAction(R.string.boton_OK) {
                        notificacion2.dismiss()
                        var intent = Intent(applicationContext, SecondActivity::class.java)
                        intent.putExtra("imc",imc)
                        intent.putExtra("button_M",R.id.button_M)
                        startActivity(intent)
                    }
                    notificacion2.show()
                }
            }
        }


    }
}

