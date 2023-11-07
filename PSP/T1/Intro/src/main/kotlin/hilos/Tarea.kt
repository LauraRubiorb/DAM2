package hilos

import java.util.concurrent.Executors

fun main() {
    /*val executor = Executors.newSingleThreadExecutor()
    executor.execute {
        println("Soy una tarea")
    }
    executor.shutdown()//detenerlo*/
    val numHilos = 5
    val ejecuciones = Executors.newFixedThreadPool(numHilos)
    val tareas = listOf(Tarea("Tarea1"),Tarea("Tarea2"),Tarea("Tarea3"),Tarea("Tarea4"),Tarea("Tarea5"))
    for (tarea in tareas){
        ejecuciones.execute(tarea)
    }
    ejecuciones.shutdown()
}
class Tarea(private val nombre: String): Runnable{
    override fun run() {
        println("Empieza el hilo con $nombre")
        for (i in 1 ..5){
            println("pasito $i")
            Thread.sleep(1000)
        }
    }
}