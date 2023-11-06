import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    val valores = "nombre=juan&edad=43"
    //me devuelve user agent CES
    val url =
        //URL("http://127.0.0.1/a/Seguridad-master/Seguridad-master/GetPost/exampleget.php?nombre=d&edad=$i&submit=Enviar")
        URL("http://127.0.0.1/a/Seguridad-master/Seguridad-master/GetPost/examplepost.php")
    val con = url.openConnection() as HttpURLConnection
    con.requestMethod = "POST"
    con.doOutput = true //habilito el envio de datos
    //creo un string para escribir
    val output = con.outputStream
    output.write(valores.toByteArray())
    output.flush()
    output.close()

    //tambien url.openStream()
    //val input = url.openStream()
    //con.setRequestProperty("User-Agent", "CES")
    val input = con.getInputStream()//obtenemos el flujo
    val buffer = BufferedReader(InputStreamReader(input))//leer lo que tenemos en el input

    /*var linea : String?
    //leemos cada linea del string y si es diferente a nulo lo imprimimos
    while (buffer.readLine().also { linea = it  }!= null){
    }*/

    //otra forma de leerlo
    buffer.useLines { lines ->
        lines.forEach { line ->
            println(line)
        }

    }
}