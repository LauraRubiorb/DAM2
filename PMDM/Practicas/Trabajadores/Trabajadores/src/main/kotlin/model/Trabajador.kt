package model

abstract class Trabajador(var nombre: String, var apellido: String, var dni: String, var sueldo: Int = 10000) {// sueldo valor x defecto

    open fun mostrarDatos(): Unit{
        println("Nombre: $nombre")
        println("Apellido: $apellido")
        println("DNI: $dni")
        println("Sueldo: $sueldo")
    }
    abstract fun calcularSueldoNetoMes():Int //clase abstracta para redefinir como se calcula el sueldo de cada trabajador
}