package red

import java.net.ServerSocket

fun main() {
    //necesito trabajar con puertos

    val puerto = 6000

    //saber si el puerto se esta utilizando : netstart -ano |find

    val servidor = ServerSocket(puerto)
    val cliente = servidor.accept() //con el accept escuchas las peticiones
}