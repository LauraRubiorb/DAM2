package model

abstract class ModeloLlamada (var numOrigen: Int, var numDestino : Int, var duracion:Int) {
    open fun mostrarDatos(): Unit {
        println("Numero de Origen: $numOrigen")
        println("Numero de Destino: $numDestino")
        println("Duración de la llamada: $duracion")
    }
}