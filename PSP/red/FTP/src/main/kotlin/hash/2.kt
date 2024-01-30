package hash

import java.security.MessageDigest

fun main() {
    val passw = "hola"
    val semilla = "1234###ad"
    val sha512 = MessageDigest.getInstance("SHA-512")
    val bytes = (passw+semilla).toByteArray()
    val hash = sha512.digest(bytes) //hassea passw
    println(hash.joinToString (""){
        "%02x".format(it)
    })

}