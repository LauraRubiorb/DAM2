package multicast

import java.lang.reflect.Executable
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import javax.lang.model.type.IntersectionType

fun main() {
    //empezamos inicandole la creacion de un grupo->direccion a la q todos nos conectaremos

    val multiGrupo = "224.0.0.251"
    val puerto = 1234
    //val mensaje = "hola chiquis"

    try {
        val direccion = InetAddress.getByName(multiGrupo)
        val socketMulti = MulticastSocket(puerto)

        socketMulti.joinGroup(direccion)
        //val mensajeb = mensaje.toByteArray()
        //val enviar = DatagramPacket(mensajeb, mensajeb.size, direccion, puerto)

        //socketMulti.send(enviar)

        //escuchar lo que envio
        while (true) {
            val mensajeChat = readLine().toString()
            val byarray = mensajeChat.toByteArray()
            val recibirChat = DatagramPacket(byarray, byarray.size, direccion, puerto)

            socketMulti.send(recibirChat)

            val array = ByteArray(256)
            val recibir = DatagramPacket(array, array.size)
            socketMulti.receive(recibir)
            val mensajec = String(recibir.data, recibir.offset, recibir.length)
            println(mensajec)

            if (mensajec == "cierra") {
                break

            }
        }
        //FALTA CERRAR LAS CONEXIONES
    } catch (e: Exception) {
        e.printStackTrace()
    }
}