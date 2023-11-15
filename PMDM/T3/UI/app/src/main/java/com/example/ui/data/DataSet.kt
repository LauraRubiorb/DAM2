package com.example.ui.data

import com.example.ui.R
import com.example.ui.model.Marca
import com.example.ui.model.Modelo

class DataSet {

    //acceder de forma directa->static
    companion object {
        fun getListaModelos(): ArrayList<Modelo> {
            val lista: ArrayList<Modelo> = ArrayList()
            lista.add(Modelo("Benz","Mercedes",300,40000,"Familiar",R.drawable.mercedesbenz))
            lista.add(Modelo("220","Mercedes",400,250000,"Electrico",R.drawable.mercedes220))
            lista.add(Modelo("RS6","Audi",340,150500,"Deportivo",R.drawable.audirs6))
            lista.add(Modelo("Etron","Audio",450,600000,"Clasico",R.drawable.audietron))
            lista.add(Modelo("GT40","Ford",300,100000,"Clasico",R.drawable.fordgt))
            lista.add(Modelo("Mustang","Ford",400,500000,"Deportivo",R.drawable.fordmust))
            return lista
        }

    }
}