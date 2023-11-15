import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

class Servidor {

    fun arrancar(){

        try {
            val server = ServerSocket(6000)
            val cliente = server.accept()
            val lectura = BufferedReader(InputStreamReader(cliente.getInputStream()))
            val escritura = PrintWriter(cliente.getOutputStream(), true)

            var mensaje:String?

            do {
                mensaje = lectura.readLine()
                println(mensaje)
                escritura.println("Me ha llegado")
            } while (mensaje != "fin" && mensaje != null)

            lectura.close()
            escritura.close()
            cliente.close()
            server.close()

        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}

fun main() {
    val server = Servidor()
    server.arrancar()
}