package model

class LlamadaNacional(numOrigen: Int, numDestino: Int, duracion: Int, var franja : Int) :
    ModeloLlamada(numOrigen, numDestino, duracion) {
    var  coste1 : Double = 0.20
    var  coste2 : Double = 0.25
    var  coste3 : Double = 0.30

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Franja horaria: $franja")
    }
}