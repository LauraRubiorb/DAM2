package model

import data.Constantes

class Asalariado(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Int = 10000,
    var numeroPagas: Int,
    var contratado: Boolean = false
) : Trabajador(nombre, apellido, dni, sueldo) {
    //SALARIO: salario - (salario * 0,21)/numPagas
    override fun calcularSueldoNetoMes():Int{
        return (sueldo - (sueldo * Constantes.RETENCIONES)/numeroPagas).toInt()
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Numero Pagas : $numeroPagas")
        println("Contratado : $contratado")
        println("Salario : ${calcularSueldoNetoMes()}")
        println("--------------------------------------")
    }
}