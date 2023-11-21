package red

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.ServerSocket

fun main() {

    try{
        //creamos un server con la claseServerSocket y con un puerto
        val server = ServerSocket(6000)
        println("Servidor esperando en el puerto")
        val cliente = server.accept()
        println("primer cliente conectado")
        //flujo de entrada o salida
        val input = BufferedReader(InputStreamReader(cliente.getInputStream()))
        val output = cliente.getOutputStream()

        //asegurarnos que llega el comando dir->leer
        val comando = input.readLine()
        println(comando)
        //val proceso = ProcessBuilder(comando)

        val proceso1 = Runtime.getRuntime().exec(comando)
        //proceso.start()
        //para poder ver el resultado nos tenemos que conectar al input

        val leerProceso = BufferedReader(InputStreamReader(proceso1.inputStream))
        var resultado = StringBuilder()
        var line : String?
        while (leerProceso.readLine().also { line = it }!= null){
            resultado.append(line).append("\n")
        }
        //despues de leer en el output escribimos el resultado
        output.write(resultado.toString().toByteArray())
        output.flush()
        cliente.close()
        server.close()

    }catch (e : Exception){
        //si hay un error lo saca print
        e.printStackTrace()
    }
}