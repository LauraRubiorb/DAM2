import controller.Centralita

fun main() {
    var opcion : Int
    var tipo : Int
    val central = Centralita()
    do {
        println("Seleccione: ")
        println("1.Registrar llamada: ")
        println("2.Mostrar llamadas: ")
        println("3.Mostrar costes: ")
        println("4.Salir: ")
        opcion = readln().toInt()
        when(opcion){
            1->{
                //REGISTRAR LLAMADA
                println("¿Que tipo de llamada desea realizar?")
                println("1.Llamada local")
                println("2.Llamada provincial")
                println("3.Llamada Nacional")
                tipo = readln().toInt()
                println("Numero de origen: ")
                val origen : Int = readln().toInt()
                println("Numero de destino: ")
                val destino : Int = readln().toInt()
                println("Duracion: ")
                val duracion : Int = readln().toInt()
                central.registrarLlamadas(tipo,origen,destino,duracion)
            }
            2->{
                //MOSTRAR LLAMADAS
                central.mostrarLlamadas()
            }
            3 -> {
                //MOSTRAR COSTES
                central.mostrarCostes()
            }
            4 -> {
                println("Saliendo")
            }
        }
    }while (opcion!=4)

}