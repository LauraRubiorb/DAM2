package red

import java.io.BufferedReader
import java.io.InputStreamReader
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
        val proceso = ProcessBuilder(comando)
        //val proceso1 = Runtime.getRuntime().exec(comando)
        proceso.start()


    }catch (e : Exception){
        //si hay un error lo saca print
        e.printStackTrace()
    }
}