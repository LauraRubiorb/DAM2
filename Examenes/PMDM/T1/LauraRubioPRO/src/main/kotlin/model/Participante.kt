package model

class Participante(var nombre : String, var puntos : Int, var presupuesto : Int = 10000000, var id : Int){
    lateinit var plantilla: ArrayList <Jugador>

    fun mostrarDatos(): Unit{
        println("nombre $nombre")
        println("puntos $puntos")
        println("presupuesto $presupuesto")
        println("id $id")
    }


}