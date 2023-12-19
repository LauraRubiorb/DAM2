package com.example.multicast

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.net.DatagramPacket
import java.net.InetAddress
import java.net.MulticastSocket

class MainActivity : AppCompatActivity() {

    private lateinit var multicastSocket: MulticastSocket
    private lateinit var receiveThread: Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSendMulticast: Button = findViewById(R.id.buttonSendMulticast)
        //val textViewReceivedMessage: TextView = findViewById(R.id.textViewReceivedMessage)
        val mensaje : EditText = findViewById(R.id.editMensaje)

        buttonSendMulticast.setOnClickListener {
            sendMessage(mensaje.text.toString())
        }

        receiveThread = Thread {
            try {
                val multicastGroup = "224.0.0.1"
                val multicastPort = 5000

                val multicastAddress = InetAddress.getByName(multicastGroup)
                multicastSocket = MulticastSocket(multicastPort)
                multicastSocket.joinGroup(multicastAddress)

                while (!Thread.currentThread().isInterrupted) {
                    val receiveBuffer = ByteArray(1024)
                    val receivePacket = DatagramPacket(receiveBuffer, receiveBuffer.size)
                    multicastSocket.receive(receivePacket)
                    val receivedMessage = String(receivePacket.data, receivePacket.offset, receivePacket.length)

                    runOnUiThread {
                        // Actualizar la interfaz de usuario con el mensaje recibido
                        //textViewReceivedMessage.text = receivedMessage
                        mensaje.text = receivedMessage
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
                val multicastGroup = "224.0.0.1"
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

    override fun onDestroy() {
        super.onDestroy()
        receiveThread.interrupt()
        multicastSocket.close()
    }
}