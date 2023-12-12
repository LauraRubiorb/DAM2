package com.example.proyectojson.model

import java.io.Serializable

class User(
    val first: String,
    val last: String,
    val email: String,
    val phone: String,
    val country: String,
    val city: String,
    val picture: String
) : Serializable {
}