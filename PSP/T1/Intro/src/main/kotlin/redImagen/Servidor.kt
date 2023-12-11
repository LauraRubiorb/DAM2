package redImagen

import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.ServerSocket

fun main() {
    val puerto = 1234
    val server = ServerSocket(1234)
    println("servidor iniciado")

    val socket = server.accept()
    println("cliente conectado")

    val input : InputStream = socket.getInputStream()

    val fichero = FileOutputStream("fichero.png")

    val recibido = BufferedOutputStream(fichero)

    val buffer = ByteArray(4096)
    var byte: Int

    while (input.read(buffer).also { byte = it }!= -1){
        recibido.write(buffer,0,byte)
    }
    recibido.flush()
    recibido.close()
    socket.close()
    server.close()

    println("imagen recibida")

}