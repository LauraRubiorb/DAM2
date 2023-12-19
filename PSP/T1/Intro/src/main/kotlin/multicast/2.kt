package multicast

import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

fun main() {
    val multicastGroup = "224.0.0.1" // Grupo de multicast al que te quieres unir
    val multicastPort = 5000 // Puerto del grupo de multicast
    val messageToSend = "¡Hola a to2!" // Mensaje a enviar

    try {
        val multicastAddress = InetAddress.getByName(multicastGroup)
        val multicastSocket = MulticastSocket(multicastPort)

        multicastSocket.joinGroup(multicastAddress) // Unirse al grupo de multicast

        // Enviar mensaje
        val sendBuffer = messageToSend.toByteArray()
        val sendPacket = DatagramPacket(sendBuffer, sendBuffer.size, multicastAddress, multicastPort)
        multicastSocket.send(sendPacket)

        // Escuchar mensajes continuamente
        while (true) {
            val receiveBuffer = ByteArray(1024)
            val receivePacket = DatagramPacket(receiveBuffer, receiveBuffer.size)
            multicastSocket.receive(receivePacket)
            val receivedMessage = String(receivePacket.data, receivePacket.offset, receivePacket.length)
            println("Mensaje recibido: $receivedMessage")
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
}