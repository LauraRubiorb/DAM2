package model

import data.Constantes

class Jefe(nombre: String, apellido: String, dni: String, sueldo: Int = 10000, var acciones: Int, var beneficio: Int) :
    Trabajador(nombre, apellido, dni, sueldo) {
    //salario/12
    override fun calcularSueldoNetoMes(): Int {
        return sueldo / Constantes.MESES
    }

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Acciones: $acciones")
        println("Beneficio: $beneficio")
        println("Salario : ${calcularSueldoNetoMes()}")
        println("--------------------------------------")
    }
}