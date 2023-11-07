import java.io.File

fun main(){
    val runtime = Runtime.getRuntime()
    val fichero = "C:\\Intel\\output.txt"
    val process = ProcessBuilder("cmd.exe", "/c","ipconfig")
    process.redirectOutput(ProcessBuilder.Redirect.to(File(fichero)))
    process.start()

}