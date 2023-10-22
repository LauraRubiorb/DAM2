import java.io.PipedOutputStream
import java.io.PrintWriter

fun main() {
    val output = PipedOutputStream()
    val writer = PrintWriter(output)

    println("Por favor, ingrese su nombre:")
    val nombre = readLine() ?: ""

    println("Ahora, ingrese sus apellidos:")
    val apellidos = readLine() ?: ""

    writer.println("$nombre $apellidos")
    writer.close()
}
