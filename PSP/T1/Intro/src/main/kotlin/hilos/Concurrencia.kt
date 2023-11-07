package hilos

import java.util.concurrent.CountDownLatch
/*
class Concurrencia {
    fun main() {
        val lanch = CountDownLatch(2)
        val b = Hilo1(lanch)
        val c = Hilo2(lanch)
        b.start()
        c.start()
        println("Suma: ${b.total}")
        println("Resta: ${c.total}")
        try {
            println("Esperando a q b acabe c")
            lanch.await()
        }catch (e : InterruptedException){
            e.printStackTrace()
        }

    }
}

class Hilo1(private val lanch: CountDownLatch) : Thread() {
    var total = 0
    override fun run() {
        synchronized(this) {
            for (i in 0 <= until < 100) {
                total += 1
            }
            lanch.countDown()
        }
    }
}

class Hilo2(private val lanch: CountDownLatch) : Thread() {
    var total = 0
    override fun run() {
        synchronized(this) {
            for (i in 0 <= until < 100) {
                total -= 1
            }
            lanch.countDown()
        }
    }*/

