package red

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket

fun main() {
    try{
        //conexion mediante socket: ponemos la direccion ip y el puerto (localhost es yo mismo)
        val socket = Socket("localhost",6000)
        val input = BufferedReader(InputStreamReader(socket.getInputStream()))
        val output = socket.getOutputStream()

        //vamos a mandar el comando dir->convertido a byte
        output.write("notepad".toByteArray())
        //enter-> ejecutar el dir
        output.write("\n".toByteArray())
        //vaciar el output
        output.flush()

    }catch (e : Exception){
        //si hay un error lo saca print
        e.printStackTrace()
    }
}