package hash

import java.lang.StringBuilder
import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun main() {
    val passw = "hola"
    val secret = SecretKeySpec("1234".toByteArray(),"HmacMD5")
    val algoritmo = Mac.getInstance("HmacMD5")
    algoritmo.init(secret)
    val hash = algoritmo.doFinal(passw.toByteArray())
    val resultado = StringBuilder()

    for (byte in hash){
        resultado.append(String.format("%02x",byte))
    }
    println(resultado)
}