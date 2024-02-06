package aes

import java.nio.charset.StandardCharsets
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

fun generateAESKey(): Key {
    val keyGenerator = KeyGenerator.getInstance("AES")
    keyGenerator.init(128) // Tamaño de clave: 128 bits (AES-128)
    return keyGenerator.generateKey()
}

fun encryptAES(text: String, key: Key): ByteArray {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val iv = cipher.parameters.getParameterSpec(IvParameterSpec::class.java).iv
    val encryptedText = cipher.doFinal(text.toByteArray(StandardCharsets.UTF_8))
    return iv + encryptedText
}

fun decryptAES(encryptedData: ByteArray, key: Key): String {
    val ivSize = 16 // Tamaño del vector de inicialización (IV) utilizado en AES
    val iv = encryptedData.copyOfRange(0, ivSize)
    val encryptedText = encryptedData.copyOfRange(ivSize, encryptedData.size)

    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(iv))
    val decryptedText = cipher.doFinal(encryptedText)
    return String(decryptedText, StandardCharsets.UTF_8)
}

fun main() {
    val originalMessage = "¡Hola, este es un ejemplo de cifrado AES en Kotlin!"
    val aesKey = generateAESKey()

    val encryptedData = encryptAES(originalMessage, aesKey)
    val decryptedMessage = decryptAES(encryptedData, aesKey)

    println("Mensaje original: $originalMessage")
    println("Mensaje cifrado: ${encryptedData.contentToString()}")
    println("Mensaje descifrado: $decryptedMessage")
}