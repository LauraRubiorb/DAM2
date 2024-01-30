package base64

import java.util.Base64

fun main() {
    val texto = "hola"

    val codificar = Base64.getEncoder().encodeToString(texto.toByteArray())
    println(codificar)

    val descodificar = String(Base64.getDecoder().decode(codificar))
    println(descodificar)
}