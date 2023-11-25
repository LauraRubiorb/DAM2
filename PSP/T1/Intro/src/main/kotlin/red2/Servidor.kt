package red2

import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket

fun main() {
    try {
        val datagrama = DatagramSocket (6000)

        val buffer = ByteArray(1024)

        val  paquete = DatagramPacket(buffer,buffer.size)
        datagrama.receive(paquete)
        println(String(paquete.data,0,paquete.length))

        val respesta = "hola cliente"

        val respuesBuffer = respesta.toByteArray()
        val direccion = paquete.address
        val puertoRespuesta = paquete.port

        val paqueteRespuesta = DatagramPacket(respuesBuffer,respuesBuffer.size,direccion,puertoRespuesta)

        datagrama.send(paqueteRespuesta)

    }catch (e:Exception){
        e.printStackTrace()
    }
}