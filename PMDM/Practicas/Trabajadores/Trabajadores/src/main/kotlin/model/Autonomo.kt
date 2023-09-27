package model

import data.Constantes

class Autonomo(
    nombre: String,
    apellido: String,
    dni: String,
    sueldo: Int = 10000,
    var cuotas: Int,
    var contratado: Boolean = false
) : Trabajador(nombre, apellido, dni, sueldo) {
    //(salario - (cuota*12))/meses
    override fun calcularSueldoNetoMes(): Int {
        return  (sueldo - (cuotas*Constantes.MESES))/Constantes.MESES
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Cuotas: $cuotas")
        println("Contratado: $contratado")
        println("Salario : ${calcularSueldoNetoMes()}")
        println("--------------------------------------")
    }
}