package com.example.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.get
import com.example.ui.databinding.ActivityMainBinding
import com.example.ui.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var perfil : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLimpiar.setOnLongClickListener{
            binding.editPass.text!!.clear()
            binding.editNombre.text!!.clear()
            binding.editCorreo.text!!.clear()
            binding.grupoTipo.clearCheck()
            binding.spinnerPerfil.setSelection(0)
            binding.checkRecordar.isChecked = false
            return@setOnLongClickListener true
        }
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonRegistrar.setOnClickListener(this)
        binding.checkRecordar.setOnCheckedChangeListener{_,isChecked -> }
        binding.grupoTipo.setOnCheckedChangeListener { _, checkedId ->  //si no quiero un param le pongo _ (no quiero el grupo xq ya se cual es)
            if (checkedId>-1) {
                val seleccion = (this.findViewById<RadioButton>(checkedId)).text
                binding.checkRecordar.isEnabled = !seleccion.equals("Mensual")
            }
            //Snackbar.make(binding.root,seleccion,Snackbar.LENGTH_SHORT).show()


        }
        binding.spinnerPerfil.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?, //elemento que realiza la accion
                view: View?,            // la fila que has pulsado
                position: Int,          //posicion de la fila
                id: Long                //pk de bd
            ) {
                //binding.spinnerPerfil.selectedItem //me da el objeto seleccionado -> este solo cuando hay 1 spinner, cuando no se implemente la interfaz
                perfil = parent?.adapter?.getItem(position).toString() //lo mismo accediendo al parent
                //Snackbar.make(binding.root,seleccionado,Snackbar.LENGTH_SHORT).show()
                if (perfil.equals("Invitado",ignoreCase = true)){
                    binding.radioAnual.isEnabled = false
                    binding.radioMensual.isEnabled = false
                    binding.checkRecordar.isEnabled = false

                }else {

                    binding.radioAnual.isEnabled = true
                    binding.radioMensual.isEnabled = true
                    binding.checkRecordar.isEnabled = true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }

    }


    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonRegistrar.id->{
                //val seleccionado = binding.spinnerPerfil.selectedItem.toString()
                //val seleccion = findViewById<RadioButton>(binding.grupoTipo.checkedRadioButtonId).text
                //Snackbar.make(binding.root,seleccionado,Snackbar.LENGTH_SHORT).show()
                //Toast.makeText(applicationContext,seleccion,Toast.LENGTH_SHORT).show()

                if (!binding.editNombre.text!!.isEmpty()
                    && !binding.editCorreo.text!!.isEmpty()
                    && !binding.editPass.text!!.isEmpty()
                    &&(!perfil.equals("Invitado") && binding.grupoTipo.checkedRadioButtonId>-1)){
                    val intent = Intent(applicationContext,SecondActivity::class.java)
                    val usuario = Usuario(
                        nombre = binding.editNombre.text.toString(),
                        email = binding.editCorreo.text.toString(),
                        pass = binding.editPass.text.toString(),
                        periodo = (findViewById<RadioButton>(binding.grupoTipo.checkedRadioButtonId).text.toString()),
                        perfil = binding.spinnerPerfil.selectedItem.toString(),
                        recordar = binding.checkRecordar.isChecked)
                    intent.putExtra("usuario",usuario)
                    startActivity(intent)
                }else{
                    Snackbar.make(binding.root,"FALTAN DATOS!",Snackbar.LENGTH_SHORT).show()
                    //vamos a la segunda pantalla

                }
            }
        }
    }
}