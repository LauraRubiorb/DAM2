import java.util.*

class Reloj {
    fun iniciar() {
        while (true) {
            val horaActual = Date()
            println("Hora actual: $horaActual")
            Thread.sleep(1000) // Espera 1 segundo
        }
    }

    class Alarma(private val reloj: Reloj) {
        private var alarmaConfigurada = false

        fun configurar(segundos: Int) {
            val calendario = Calendar.getInstance()
            calendario.time = Date()
            calendario.add(Calendar.SECOND, segundos)
            val horaAlarma = calendario.time
            println("Alarma configurada para: $horaAlarma")
            alarmaConfigurada = true
        }

        fun esperarAlarma() {
            while (!alarmaConfigurada) {
                Thread.sleep(1000)
            }
        }

        fun detener() {
            alarmaConfigurada = false
        }
    }
}