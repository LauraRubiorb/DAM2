package com.example.entregafinal

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket
import java.security.MessageDigest
import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class ChatActivity : AppCompatActivity() {

    private lateinit var multicastSocket: MulticastSocket
    private lateinit var receiveThread: Thread
    private var palabra = "1234567891234567"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //val claveSecreta:String = generarClaveSecreta()

        val buttonSendMulticast: Button = findViewById(R.id.boton_enviar)
        val botobDescifrar: Button = findViewById(R.id.boton_descifrar)
        val textViewReceivedMessage: TextView = findViewById(R.id.textview_recibido)
        val textViewCifrado: TextView = findViewById(R.id.textview_cifrado)
        val editMensaje: EditText = findViewById(R.id.edit_mensaje)

        //------------------------------
        /*
        val encodedKey = "MTIzNDU2Nzg5MTIzNDU2Nw=="
        val decodedKey: ByteArray = Base64.getDecoder().decode(encodedKey)

        val originalKey: SecretKey = SecretKeySpec(decodedKey, 0, decodedKey.size, "AES")
        println("originalKey: ${String(decodedKey)}")

        val cipher = Cipher.getInstance("AES")

        val clearTextBytes = editMensaje.text.toString().toByteArray(StandardCharsets.UTF_8)
        */


        buttonSendMulticast.setOnClickListener {
            textViewReceivedMessage.text = editMensaje.text
            sendMessage(encriptar(editMensaje.text.toString(), palabra))
        }
        botobDescifrar.setOnClickListener {
            textViewReceivedMessage.text  = desencriptar(editMensaje.text.toString(), palabra)
        }

        receiveThread = Thread {
            try {
                val multicastGroup = "224.0.0.251"
                val multicastPort = 5000

                val multicastAddress = InetAddress.getByName(multicastGroup)
                multicastSocket = MulticastSocket(multicastPort)
                multicastSocket.joinGroup(multicastAddress)

                while (!Thread.currentThread().isInterrupted) {
                    val receiveBuffer = ByteArray(256)
                    val receivePacket = DatagramPacket(receiveBuffer, receiveBuffer.size)
                    multicastSocket.receive(receivePacket)
                    val receivedMessage = String(receivePacket.data, receivePacket.offset, receivePacket.length)

                    runOnUiThread {
                        // Actualizar la interfaz de usuario con el mensaje recibido
                        textViewCifrado.text = receivedMessage
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        receiveThread.start()
    }

    private fun sendMessage(message: String) {
        Thread {
            try {
                val multicastGroup = "224.0.0.251"
                val multicastPort = 5000

                val multicastAddress = InetAddress.getByName(multicastGroup)
                val sendBuffer = message.toByteArray()
                val sendPacket = DatagramPacket(sendBuffer, sendBuffer.size, multicastAddress, multicastPort)

                val sendSocket = MulticastSocket()
                sendSocket.send(sendPacket)
                sendSocket.close()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }.start()
    }


    private fun encriptar(datos: String, password: String): String {
        val secretKey = generateKey(password)
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val datosEncriptadosBytes = cipher.doFinal(datos.toByteArray())
        return Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT)
    }

    private fun generateKey(password: String): SecretKeySpec {
        val sha = MessageDigest.getInstance("SHA-256")
        var key = password.toByteArray(charset("UTF-8"))
        key = sha.digest(key)
        return SecretKeySpec(key, "AES")
    }

    private fun desencriptar(datos: String, password: String): String {
        try {
            val secretKey = generateKey(password)
            val cipher = Cipher.getInstance("AES/ECB/NoPadding")
            cipher.init(Cipher.DECRYPT_MODE, secretKey)
            val datosDescodificados = Base64.decode(datos, Base64.DEFAULT)
            val datosDesencriptadosByte = cipher.doFinal(datosDescodificados)
            return String(datosDesencriptadosByte)
        } catch (e: Exception) {
            e.printStackTrace()
            return "Error al descifrar el mensaje: ${e.message}"
        }
        /*val secretKey = generateKey(password)
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        val datosDescodificados = Base64.decode(datos, Base64.DEFAULT)
        val datosDesencriptadosByte = cipher.doFinal(datosDescodificados)
        return String(datosDesencriptadosByte)*/
    }

    override fun onDestroy() {
        super.onDestroy()
        receiveThread.interrupt()
        multicastSocket.close()
    }
}