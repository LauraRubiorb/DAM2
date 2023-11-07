package red
import java.net.InetAddress
import java.net.Socket

fun main() {
    val puerto = 6000
    val cliente = Socket("127.0.0.1",puerto)//necesitamos el puerto y la direccion ip

    //saber con que direccion me he conectado

    val ip:InetAddress = cliente.inetAddress
    println(ip)

}