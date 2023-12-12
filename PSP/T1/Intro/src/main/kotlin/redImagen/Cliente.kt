package redImagen

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.OutputStream
import java.net.Socket

fun main() {
    val host = "localhost"
    val port = 1234


    val fichero = File("img.png")

    val socket = Socket(host,port)

    val output : OutputStream = socket.getOutputStream()
    val file = FileInputStream(fichero)

    //lo mandamos

    val enviado = BufferedInputStream(file)

    val buffer = ByteArray(4096)
    var byte : Int

    while (enviado.read(buffer).also { byte = it }!=-1){
        output.write(buffer,0,byte)

    }
    output.flush()
    output.close()
    socket.close()

    //CONCEPTOS BASICOS COMUNICACIÓNE NTRE APP:
        //DIRECCION IP/ TCP: seguro Y UDP: malo, no hace falta comunicacion: es muy rapido
}       //SOCKETS
        //MODELOS DE COMUNICACIONES
        //computacion distribuida