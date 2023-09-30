package model

class LlamadaProvincial(numOrigen: Int, numDestino: Int, duracion: Int) :
    ModeloLlamada(numOrigen, numDestino, duracion) {
        //0.15 coste
    val coste : Double = 0.15

    override fun mostrarDatos() {
        super.mostrarDatos()
    }
}