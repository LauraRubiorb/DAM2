package model

class UsuarioExtendido(nombre: String, apellido: String, dni: String,var telefono: Int, var sueldo: Int) : User(nombre, apellido, dni) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Telefono: $telefono")
        println("Sueldo: $sueldo")
    }


}