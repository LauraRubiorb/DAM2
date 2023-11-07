import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    //tema red-> peticiones web
    val cliente = OkHttpClient()
    val url = "https://randomuser.me/api/"
    val peticion = Request.Builder().url(url).build()

    val respuesta = cliente.newCall(peticion).execute()
    val respuestaTotal = respuesta.body?.string()
    println(respuestaTotal)
}