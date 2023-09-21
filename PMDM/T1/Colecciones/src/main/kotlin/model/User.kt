package model

open class User(var nombre: String?, var apellido: String?) {//constructor vacio ?
    //get y setter ya estan
    //solo hay 2 tipos de contructores
    //late init solo para complejos
    /*var nombre:String? = null
    lateinit var apellido: String
    var edad: Int = 0;*/


    var dni: String? = null
    lateinit var dni0: String

    init {
        if (dni0.length == 0) {
            dni0 = "sin dni"
        }
    }

    //CONSUTRUCTORES secundario
    constructor(nombre: String, apellido: String, dni: String) : this(nombre, apellido) {
        this.dni = dni
    }

    open fun mostrarDatos() {
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("Dni: ${dni ?: "sin dni"}")
    }

    override fun toString(): String {
        return super.toString()
    }

}