package controller

import model.LlamadaLocal
import model.LlamadaNacional
import model.LlamadaProvincial
import model.ModeloLlamada
import javax.swing.text.html.HTMLEditorKit.LinkController

class Centralita {
    var listaLlamadas: ArrayList<ModeloLlamada> = ArrayList()

    fun registrarLlamadas(tipo: Int, origen: Int, destino: Int, duracion: Int): Unit {
        if (tipo == 1) {
            //llamada local
            val llamadaLocal: LlamadaLocal = LlamadaLocal(origen, destino, duracion)
            listaLlamadas.add(llamadaLocal)
        } else if (tipo == 2) {
            //llamada provincial
            val llamadaProvincial: LlamadaProvincial = LlamadaProvincial(origen, destino, duracion)
            listaLlamadas.add(llamadaProvincial)
        } else if (tipo == 3) {
            //llamada nacional
            println("Determine la franja horaria: 1 / 2 / 3")
            val franja: Int = readln().toInt()
            val llamadaNacional: LlamadaNacional = LlamadaNacional(origen, destino, duracion, franja)
            listaLlamadas.add(llamadaNacional)
        } else {
            println("Error")
        }
    }

    fun mostrarLlamadas(): Unit {
        if (listaLlamadas.size > 0) {
            listaLlamadas.forEach { it.mostrarDatos() }
        } else {
            println("La lista esta vacia")
        }
    }

    fun mostrarCostes(): Unit {
        calcularCostes()
    }

    fun calcularCostes(): Unit {
        if (listaLlamadas.filterIsInstance<LlamadaProvincial>().size > 0) {
            val costesProvincial = listaLlamadas.filterIsInstance<LlamadaProvincial>().forEach { it.coste * it.duracion }

            print(costesProvincial)
        }
        if (listaLlamadas.filterIsInstance<LlamadaNacional>().size > 0) {
            val costesNac1 = listaLlamadas.filterIsInstance<LlamadaNacional>()
                .filter { it.franja == 1 * it.duracion * it.coste1.toInt() }
            println(costesNac1)
            val costesNac2 = listaLlamadas.filterIsInstance<LlamadaNacional>()
                .filter { it.franja == 2 * it.duracion * it.coste2.toInt() }
            println(costesNac2)
            val costesNac3 = listaLlamadas.filterIsInstance<LlamadaNacional>()
                .filter { it.franja == 3 * it.duracion * it.coste3.toInt() }
            println(costesNac3)
        } else {
            print("Error. Lista vacia")
        }
    }
}
