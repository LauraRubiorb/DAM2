package hilos

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread

class Cuenta(var saldo: Int) {
    private val lock = ReentrantLock()

    fun depositar(cantidad: Int) {
        //si yo estoy depositando nadie mas puede a la vez
        lock.lock()
        try {
            saldo += cantidad
            println("Dinero ingresado: $saldo")
        } finally {
            lock.unlock()
        }
    }

    fun retirar(cantidad: Int) {
        lock.lock()
        try {
            if (saldo >= cantidad) {
                saldo -= cantidad
                println("Dinero retirado: $saldo")
            } else {
                print("No tienes dinero")
            }
        } finally {
            lock.unlock()
        }
    }
}

fun main() {
    val cuenta = Cuenta(1000)
    val hilo1 = thread {
        for (i in 1..5) {
            cuenta.depositar(100)
            Thread.sleep(100)
        }
    }
    val hilo2 = thread {
        for (i in 1..5) {
            cuenta.retirar(100)
            Thread.sleep(100)
        }
    }
    hilo1.join()
    hilo2.join()

}

