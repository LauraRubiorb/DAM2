package com.example.comprasapp.data

import com.example.comprasapp.R
import com.example.comprasapp.model.Producto

class DataSet {
    companion object {
        fun getProductos(): ArrayList<Producto> {
            val listaProducto :  ArrayList<Producto> = ArrayList()
            listaProducto.add(Producto("Nike","Zapatillas1",96.99,
                    "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/26bb0f59-837a-43f9-a095-c75d1b8246d7/air-max-plus-3-zapatillas-P9HTjt.png",
                    R.drawable.nike)
            )
            listaProducto.add(Producto( "Nike","Zapatillas2",125.35,
                    "https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/20a66621-b4f1-411b-90ca-1492fa09fba7/zapatillas-dunk-low-nino-a-qzSGWv.png",
                    R.drawable.nike)
            )
            listaProducto.add(Producto("Adidas","Adidas1",59.60,"https://painkillerx.com/uploads/photo/image/2631/A01244_tQDN09GK.JPG",R.drawable.adidas))
            listaProducto.add(Producto("Adidas","Adidas2",79.90,"https://brand.assets.adidas.com/image/upload/f_auto,q_auto,fl_lossy/esES/Images/03-fw23-brand-campaign-launch-plp-originals-shoes-iwp-samba-d_tcm190-1060131.jpg",R.drawable.adidas))



            return listaProducto
        }
    }
}