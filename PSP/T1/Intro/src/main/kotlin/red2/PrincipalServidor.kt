package red2

import Servidor

fun main() {

    val puerto = 1234
    val servidorhilo = Thread{
        val servidor = ServidorPerso(puerto)
        servidor.iniciar()

    }
    servidorhilo.start()
    servidorhilo.join()
}