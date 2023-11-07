import hilos.Reloj
import kotlin.concurrent.thread

fun main() {
    val reloj = Reloj()
    val alarma = Reloj.Alarma(reloj)

    thread {
        reloj.iniciar()
    }

    thread {
        alarma.configurar(10) // Configura la alarma para que suene después de 10 segundos
        alarma.esperarAlarma()
        println("¡Alarma sonando!")
    }

    // Aquí puedes agregar la lógica para permitir que el usuario interrumpa la alarma, por ejemplo, presionando una tecla.
    println("Presiona Enter para detener la alarma.")
    readLine()

    alarma.detener()
}