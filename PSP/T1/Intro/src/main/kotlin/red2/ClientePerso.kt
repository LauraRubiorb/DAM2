package red2

import java.io.ObjectOutputStream
import java.net.Socket

class ClientePerso(private val host: String, private val puerto: Int) {
    fun enviarObjeto(persona: Persona) {
        val socket = Socket(host, puerto)
        println("Nos hemos conectado al servidor")

        val output = ObjectOutputStream(socket.getOutputStream())

        output.writeObject(persona)

        output.flush()
        output.close()
        socket.close()
    }
}