package com.example.ui.data

import com.example.ui.R
import com.example.ui.model.Marca
import com.example.ui.model.Modelo

class DataSet {

    //acceder de forma directa->static
    companion object {
        fun getListaModelos(): ArrayList<Modelo> {
            val lista: ArrayList<Modelo> = ArrayList()
            lista.add(Modelo("Benz",Marca("Mercedes",5.7,R.drawable.mercedes),300,40000,"Familiar",R.drawable.mercedesbenz,""))
            lista.add(Modelo("220",Marca("Mercedes",5.8,R.drawable.mercedes),400,250000,"Electrico",R.drawable.mercedes220,""))
            lista.add(Modelo("RS6",Marca("Audi",5.2,R.drawable.audi),340,150500,"Deportivo",R.drawable.audirs6,""))
            lista.add(Modelo("Etron",Marca("Audi",5.7,R.drawable.audi),450,600000,"Clasico",R.drawable.audietron,""))
            lista.add(Modelo("GT40",Marca("Ford",4.7,R.drawable.ford),300,100000,"Clasico",R.drawable.fordgt,"https://cdn.motor1.com/images/mgl/BzERe/s3/ford-gt40-p-1075-toolroom-copy.jpg"))
            lista.add(Modelo("Mustang",Marca("Ford",5.0,R.drawable.ford),400,500000,"Deportivo",R.drawable.fordmust,"https://estaticos-cdn.prensaiberica.es/clip/41a0bdc1-2635-4c08-9e11-2cdf2619b88f_alta-libre-aspect-ratio_default_0.jpg"))
            return lista
        }

    }
}