package red2

import java.io.ObjectInputStream
import java.net.ServerSocket

class ServidorPerso (private val puerto: Int){

    fun iniciar(): Unit {
        val socket = ServerSocket(puerto)
        println("el servidor se ha iniciado")


        val peticion = socket.accept()

        //sacar la direccion ip desde la que se ha conectado el cliente
        println("se ha conectado el cliente ${peticion.inetAddress.hostAddress}")

        val input = ObjectInputStream(peticion.getInputStream())

        val recibir = input.readObject() as Persona

        println("recibido persona")
        println("nombre: ${recibir.nombre}")
        println("edad: ${recibir.edad}")

        input.close()

        socket.close()
        peticion.close()

    }

}

