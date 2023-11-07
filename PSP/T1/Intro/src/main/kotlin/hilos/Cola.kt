import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue : Queue<Int> = LinkedList()
    val productor = Thread{
        for (i in 1..10){
            synchronized(queue){
                queue.add(i)
                println("hemos añadido un elemento")
                Thread.sleep(1000)
            }
        }
    }
    val consumir = Thread{
        for (i in 1..10){
            synchronized(queue){
                while (queue.isEmpty()){
                    Thread.sleep(1000)
                }
                val  elemento = queue.poll()//si la cola no esta vacia sacamos el elemento
                println("$elemento")
            }
        }
    }
    productor.start()
    consumir.start()
    productor.join()
    consumir.join()
}