package com.example.model

import java.io.Serializable

class Producto(
    var title: String? = null,
    var price: Double? = null,
    var description: String? = null,
    var category: String? = null,
    var thumbnail: String? = null,
    var id: Int? = null,
    var images: ArrayList<String>? = null
) {


}


