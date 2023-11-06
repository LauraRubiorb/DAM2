import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val cliente = OkHttpClient()
    val url = "https://www.jesusninoc.com"
    val peticion = Request.Builder().url(url).build()

    val respuesta = cliente.newCall(peticion).execute()
    val respuestaTotal = respuesta.body?.string()
    println(respuestaTotal)
}