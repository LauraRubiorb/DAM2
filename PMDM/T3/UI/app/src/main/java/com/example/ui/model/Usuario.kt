package com.example.ui.model

class Usuario {
    private lateinit var nombre: String
    private lateinit var email : String
    private lateinit var passw : String

    constructor(nombre: String, email: String, passw: String) {
        this.nombre = nombre
        this.email = email
        this.passw = passw
    }

}