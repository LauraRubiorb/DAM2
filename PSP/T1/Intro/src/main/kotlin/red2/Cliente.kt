package red2

import java.lang.Exception
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress

fun main() {
    try {
        val conexion = DatagramSocket()
        val mensaje = "hola servidor UDP"
        val mensajeByte = mensaje.toByteArray()
        //para poder mandarlo vemos a q ip le mandamos
        val ip = InetAddress.getByName("127.0.0.1")

        //construimos el paquete

        val paquete = DatagramPacket(mensajeByte, mensajeByte.size, ip, 6000)

        //mandarlo
        conexion.send(paquete)

        val buffer = ByteArray(1024)
        val paqueteRecibido = DatagramPacket(buffer, buffer.size)
        conexion.receive(paqueteRecibido)
        println(String(paqueteRecibido.data,0,paqueteRecibido.length))

    } catch (e: Exception) {
        e.printStackTrace()
    }
}