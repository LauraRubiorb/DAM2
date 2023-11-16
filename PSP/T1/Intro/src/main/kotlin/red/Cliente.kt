import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

fun main() {
    //tema red-> peticiones web
    val cliente = OkHttpClient()
    val url = "https://randomuser.me/api/"
//val url = "https://api.openweathermap.org/data/2.5/weather?lat={40.463667}&lon={-3.74922}&appid={8e7df8ca8bca261a56ac499f4bcff30e}"

    //val url = "https://api.audiomack.com/v1/artist/bad-bunny/songs?show=music&fields=id"
    val peticion = Request.Builder().url(url).build()

    val respuesta = cliente.newCall(peticion).execute()
    val respuestaTotal = respuesta.body?.string()
    println(respuestaTotal)
}