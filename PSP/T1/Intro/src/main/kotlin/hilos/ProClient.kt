package hilos
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedWriter
import java.io.File
import java.nio.charset.Charset


fun main() {
    val cliente = OkHttpClient()
    //val url1 = "https://api.openweathermap.org/data/2.5/weather?lat={40.463667}&lon={-3.74922}&appid={c8f8e5cdc3bf85ad224caabb22fd2729}"
    //val url2 = "http://api.openweathermap.org/data/2.5/air_pollution?lat={40.463667}&lon={-3.74922}&appid={c8f8e5cdc3bf85ad224caabb22fd2729}"
    //val url3 = "GET https: //api.nasa.gov/insight_weather/?api_key=DEMO_KEY&feedtype=json&ver=1.0"
    //val url3 = "https://api.nasa.gov/DONKI/IPS?startDate=2016-01-01&endDate=2016-01-30&api_key=20231111190451"


    //14 diferentes categorias de comidas que te encontraras en la api
    val url1 = "https://www.themealdb.com/api/json/v1/1/categories.php"
    //comidas por la letra x de la api
    val url2 = "https://www.themealdb.com/api/json/v1/1/search.php?f=a"




//dos hilos de solicitudes a la api
    val thread1 = Thread {
        val peticion1 = Request.Builder().url(url1).build()
        val respuesta1 = cliente.newCall(peticion1).execute()
        val respuestaTotal1 = respuesta1.body?.string()
        val cat = "14 CATEGORIAS\n".toString()
        val fileP : File = File("C:\\Users\\laura\\Desktop\\jesus.txt")
        val file : File = File("C:\\Users\\laura\\Desktop\\jesus.txt")
        val bufferP = BufferedWriter(fileP.writer())
        val buffer = BufferedWriter(file.writer())
        buffer.write(respuestaTotal1)
        buffer.write(cat)
        buffer.close()

    }



    val thread2 = Thread {
        val peticion2 = Request.Builder().url(url2).build()
        val respuesta2 = cliente.newCall(peticion2).execute()
        val respuestaTotal2 = respuesta2.body?.string()
        val letras = "COMIDAS POR LA LETRA: a\n".toString()
        val file : File = File("C:\\Users\\laura\\Desktop\\jesus.txt")
        val file2 : File = File("C:\\Users\\laura\\Desktop\\jesus.txt")
        val buffer2 = BufferedWriter(file.writer())
        val buffer = BufferedWriter(file.writer())
        buffer.write(letras)
        buffer.write(respuestaTotal2)
        buffer.close()
    }

    thread1.start()
    thread2.start()

    try {
        thread1.join()
        thread2.join()
    } catch (e: InterruptedException) {
        e.printStackTrace()
    }

    //cerrar el http
    //detener todas las tareas en cola y rechazar cualquier tarea nueva que se intente enviar al servicio de ejecución.

    cliente.dispatcher.executorService.shutdown()
}