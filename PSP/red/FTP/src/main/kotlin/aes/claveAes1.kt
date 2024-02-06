import java.nio.charset.StandardCharsets
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

fun main() {
    val encodedKey = "MTIzNDU2Nzg5MTIzNDU2Nw=="
    val decodedKey: ByteArray = Base64.getDecoder().decode(encodedKey)

    val originalKey: SecretKey = SecretKeySpec(decodedKey, 0, decodedKey.size, "AES")
    println("originalKey: ${String(decodedKey)}")

    val cipher = Cipher.getInstance("AES")

    val clearText = "hola"
    val clearTextBytes = clearText.toByteArray(StandardCharsets.UTF_8)
    println("Texto en claro: $clearText")

    cipher.init(Cipher.ENCRYPT_MODE, originalKey)
    val cipherBytes = cipher.doFinal(clearTextBytes)
    val cipherText = String(cipherBytes, StandardCharsets.UTF_8)
    println("Texto cifrado: $cipherText")

    cipher.init(Cipher.DECRYPT_MODE, originalKey)
    val decryptedBytes = cipher.doFinal(cipherBytes)
    val decryptedText = String(decryptedBytes, StandardCharsets.UTF_8)
    println("Texto descifrado: $decryptedText")
}