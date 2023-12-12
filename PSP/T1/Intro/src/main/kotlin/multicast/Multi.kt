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
    val mensaje = "hola chiquis"

    try {
        val direccion = InetAddress.getByName(multiGrupo)
        val socketMulti = MulticastSocket(puerto)

        socketMulti.joinGroup(direccion)
        val mensajeb = mensaje.toByteArray()
        val enviar = DatagramPacket(mensajeb,mensajeb.size,direccion,puerto)

        socketMulti.send(enviar)

        //escuchar lo que envio
        while (true){
            val array = ByteArray(256)
            val recibir = DatagramPacket(array,array.size)
            socketMulti.receive(recibir)
            val mensajec = String(recibir.data,recibir.offset,recibir.length)
            println(mensajec)
        }
    }catch (e : Exception){
        e.printStackTrace()
    }
}