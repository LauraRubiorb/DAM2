package com.example.compras.model

import java.io.Serializable

class Producto(
    var title: String,
    var price: Int,
    var stock: Int,
    var description: String,
    var thumbnail: String,
    var images: ArrayList<String>
) : Serializable {
}