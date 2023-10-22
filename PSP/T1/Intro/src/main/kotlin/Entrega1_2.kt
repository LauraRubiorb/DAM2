import java.io.File

fun main() {
    val input = readLine() ?: ""
    val datos = input.split(" ")

    if (datos.size >= 2) {
        val nombre = datos[0]
        val apellidos = datos[1]

        val rutaArchivo = "C:\\Users\\laura\\Desktop\\ entrega.txt"

        val archivo = File(rutaArchivo)

        archivo.printWriter().use { out ->
            out.println("Nombre: $nombre")
            out.println("Apellidos: $apellidos")
        }

        println("Datos guardados en $rutaArchivo")
    } else {
        println("Datos no válidos")
    }
}
