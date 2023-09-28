package model

class Jugador(var id : Int, var nombre : String, var valor : String, var posicion : Int, var puntos : Int) {


    fun mostrarDatos(): Unit{
        println("id: $id")
        println("nombre: $nombre")
        println("valor: $valor")
        println("posicion: $posicion")
    }

}