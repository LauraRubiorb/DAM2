import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class Cliente {
    fun arrancarCliente(){
        try {
            val socketCliente = Socket("127.0.0.1",6000)
            val lectura = BufferedReader(InputStreamReader(socketCliente.getInputStream()))
            val escritura = PrintWriter(socketCliente.getOutputStream(), true)

            escritura.println("Este es el mensaje")
            var leer = lectura.readLine()
            println(leer)
            escritura.println("fin")

            lectura.close()
            escritura.close()
            socketCliente.close()

        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}

fun main() {
    val cliente = Cliente()
    cliente.arrancarCliente()
}