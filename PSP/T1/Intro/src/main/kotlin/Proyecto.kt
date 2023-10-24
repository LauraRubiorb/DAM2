import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.Period
import java.util.*
import kotlin.concurrent.thread


fun main() {
    val scanner = Scanner(System.`in`)
    print("Ingresa tu fecha de nacimiento (AAAA-MM-DD): ")
    val fechaNacimientoStr = scanner.nextLine()

    val fechaNacimiento = LocalDate.parse(fechaNacimientoStr)
   // val br = BufferedReader(InputStreamReader(fechaNacimiento.getInputStream()))

    val hiloPadre = thread {
        val edad = calcularEdad(fechaNacimiento)
        println("Tienes $edad años.")

        val diaNacimiento = fechaNacimiento.dayOfMonth
        val mesNacimiento = fechaNacimiento.monthValue
        val anioNacimiento = fechaNacimiento.year
        println("Naciste el día $diaNacimiento de mes $mesNacimiento, año $anioNacimiento.")
    }

    hiloPadre.join()
}

fun calcularEdad(fechaNacimiento: LocalDate): Int {
    val fechaActual = LocalDate.now()
    val periodo = Period.between(fechaNacimiento, fechaActual)
    return periodo.years
}
