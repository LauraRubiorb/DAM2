package com.example.juegodecartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.SnackbarContentLayout

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var editName : EditText
    private lateinit var botonEmpezar : Button
    private  var nombre : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instancias()
        acciones()
        nombre = savedInstanceState?.getString("nombre")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nombre",nombre!!)
    }
    private fun acciones() {
        botonEmpezar.setOnClickListener(this)

    }

    private fun instancias() {
        editName = findViewById(R.id.editName)
        botonEmpezar = findViewById(R.id.botonEmpezar)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.botonEmpezar->{
                if (editName.text.isEmpty()){
                    var notif1 = Snackbar.make(p0, resources.getString(R.string.noti1),Snackbar.LENGTH_LONG).show()
                }else{
                    nombre = editName.text.toString()
                    var notif2 = Snackbar.make(p0,"Perfecto ${nombre}, ¿Quieres empezar?",Snackbar.LENGTH_INDEFINITE)
                    notif2.setAction("OK"){
                        notif2.dismiss()
                        val intent = Intent(applicationContext,SecondActivity::class.java)
                        intent.putExtra("nombre",nombre)
                        startActivity(intent)
                    }
                    notif2.show()
                }
            }
        }
    }
}