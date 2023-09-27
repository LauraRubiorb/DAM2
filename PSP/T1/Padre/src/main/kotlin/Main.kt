import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {

   val proceso = ProcessBuilder ("C:\\Users\\laura\\Documents\\GitHub\\dam2\\PSP\\T1\\Padre\\src\\main\\kotlin\\Mainkt")
    val hijo = proceso.start()
    val input = hijo.inputStream
    val leer = BufferedReader(InputStreamReader(input))
    val resultado = leer.readLine()

}