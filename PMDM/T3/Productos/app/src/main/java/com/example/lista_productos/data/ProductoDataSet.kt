package com.example.lista_productos.data

import com.example.lista_productos.model.Producto

class ProductoDataSet {

    companion object{
        fun getProducto (): Producto{
            var listaProducto = ArrayList<Producto>()
            listaProducto.add(Producto("zapatillas","deporte",150.0,"https://e00-expansion.uecdn.es/assets/multimedia/imagenes/2022/12/20/16715408188469.jpg"))
            listaProducto.add(Producto("camiseta","vestir",50.0,"https://media.gq.com.mx/photos/5fdaad6f45ab6ba380bf4e85/16:9/w_2560%2Cc_limit/PLAYERA%2520BLANCA%2520TRAJE%25202.jpg"))
            listaProducto.add(Producto("pantalones","vaqueros",70.0,"https://okdiario.com/coolthelifestyle/img/2023/10/06/ynesuelves.jpg"))
            listaProducto.add(Producto("pulsera","cuero",20.0,""))

        return listaProducto[(0..2).random()]
        }
    }
}