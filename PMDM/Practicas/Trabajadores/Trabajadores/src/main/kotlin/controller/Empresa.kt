package controller

import model.Asalariado
import model.Autonomo
import model.Jefe
import model.Trabajador

class Empresa {
    var listaTrabajadores: ArrayList<Trabajador>

    init {
        listaTrabajadores = ArrayList<Trabajador>()
    }

    fun existeDni(dni: String): Boolean {
        if (listaTrabajadores.find { it.dni == dni } != null) {
            return true
        }
        return false
    }

    //add trabajador-> AS AU JF -> no puede haber dos trabajadores con el mismo dni
    fun crearTrabajador(nombre: String, apellido: String, dni: String, sueldo: Int): Unit {
        if (existeDni(dni)) {
            println("DNI ya existente")
        } else
            println("Desea agregar : 1.Asalariado,2.Autonomo, 3.Jefe")
        val opcion: Int = readln().toInt()
        when (opcion) {
            1 -> {
                println("Introduce el numero de pagas: ")
                val numPagas: Int = readln().toInt()
                println("¿Contratado? true/false")
                val contratado: Boolean = readln().toBoolean()
                var asalariado: Asalariado = Asalariado(nombre, apellido, dni, sueldo, numPagas, contratado)
                listaTrabajadores.add(asalariado)
                println("Agregado correctamente")
            }

            2 -> {
                println("Introduce el numero de cuotas: ")
                val cuotas: Int = readln().toInt()
                println("¿Contratado? true/false")
                val contratado: Boolean = readln().toBoolean()
                var autonomo: Autonomo = Autonomo(nombre, apellido, dni, sueldo, cuotas, contratado)
                listaTrabajadores.add(autonomo)
                println("Agregado correctamente")
            }

            3 -> {
                println("Introduce tus acciones: ")
                val acciones: Int = readln().toInt()
                println("Introduce tus beneficios: ")
                val beneficios: Int = readln().toInt()
                var jefe: Jefe = Jefe(nombre, apellido, dni, sueldo, acciones, beneficios)
                listaTrabajadores.add(jefe)
                println("Agregado correctamente")
            }
        }
    }
    fun despedir(dni: String): Unit {
        if (!existeDni(dni)){
            println("Trabajador no encontrado")
        }else {
            listaTrabajadores.removeIf { it.dni == dni }
            println("Despedido correctamente")
        }
    }

    fun mostrarTrabajadores(): Unit {
        if (listaTrabajadores.size > 0) {
            println("1.Asalariados/2.Autonomos/3.Jefes")
            var opcion0: Int = readln().toInt()
            when (opcion0) {
                1 -> {
                    listaTrabajadores.filterIsInstance<Asalariado>().forEach { it.mostrarDatos() }
                }

                2 -> {
                    listaTrabajadores.filterIsInstance<Autonomo>().forEach { it.mostrarDatos() }
                }

                3 -> {
                    listaTrabajadores.filterIsInstance<Jefe>().forEach { it.mostrarDatos() }
                }
            }
        }else println("Lista vacia")
    }

    fun datosTrabajador(dni:String): Unit {
        if (!existeDni(dni)){
            println("Trabajador no encontrado")
        }else {
            listaTrabajadores.find { it.dni == dni}?.mostrarDatos()
        }
    }


}