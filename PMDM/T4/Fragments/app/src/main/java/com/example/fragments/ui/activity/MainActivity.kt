package com.example.fragments.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import com.example.fragments.R
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.ui.fragments.FragmentUno

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        //binding.sitioFragments
        // supportFragmentManager-> gestion de fragments
        // supportFragmentManager-> fragmentTransaction

        var ft = supportFragmentManager.beginTransaction();
        // replace
        ft.replace(binding.sitioFragments.id, FragmentUno(), "f1")
        ft.addToBackStack("f1")
        ft.commit()

        ft = supportFragmentManager.beginTransaction();
        //ft.setCustomAnimations(android.R.)
        ft.replace(binding.sitioFragments.id, FragmentUno(), "f11")
        ft.addToBackStack("f11")
        ft.commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu)
        return super.onCreateOptionsMenu(menu)
    }

    /*
        override fun onClick(v: View?) {
            when(v!!.id){
                binding.botonF1.id->{
                    var ft = supportFragmentManager.beginTransaction();
                    // replace
                    ft.replace(binding.sitioFragments.id,FragmentUno(),"f1")
                    ft.addToBackStack("f1")
                    ft.commit()
                }
                binding.botonF2.id->{
                    var ft = supportFragmentManager.beginTransaction();
                    //ft.setCustomAnimations(android.R.)
                    ft.replace(binding.sitioFragments.id,FragmentDos(),"f11")
                    ft.addToBackStack("f11")
                    ft.commit()
                }
            }
        }*/

    override fun onNombreSelected(nombre: String) {
        var ft = supportFragmentManager.beginTransaction();
        //ft.setCustomAnimations(android.R.)
        ft.replace(binding.sitioFragments.id, FragmentDos.newInstance(nombre), "f11")
        ft.addToBackStack("f11")
        ft.commit()
    }
}