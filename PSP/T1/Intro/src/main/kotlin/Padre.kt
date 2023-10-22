import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val proceso = ProcessBuilder("C:\\Program Files\\Java\\jdk-18.0.2.1\\bin\\java.exe\" \"-javaagent:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.2\\lib\\idea_rt.jar=65399:C:\\Program Files\\JetBrains\\IntelliJ IDEA Community Edition 2022.2.2\\bin\" " +
            "-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath " +
            "C:\\Users\\laura\\Documents\\GitHub\\dam2\\PSP\\T1\\Intro\\out\\production\\Intro;C:\\Users\\laura\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk8\\1.7.10\\kotlin-stdlib-jdk8-1.7.10.jar;C:\\Users\\laura\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib\\1.7.10\\kotlin-stdlib-1.7.10.jar;C:\\Users\\laura\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-common\\1.7.10\\kotlin-stdlib-common-1.7.10.jar;C:\\Users\\laura\\.m2\\repository\\org\\jetbrains\\annotations\\13.0\\annotations-13.0.jar;C:\\Users\\laura\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib-jdk7\\1.7.10\\kotlin-stdlib-jdk7-1.7.10.jar MainKt")
    val hijo = proceso.start()

    val input = hijo.inputStream
    val leer = BufferedReader(InputStreamReader(input))
    val resultado = leer.readLine()
    println(resultado)
    //val valor = hijo.waitFor()
    println("el hijo ha finalizado")

    //ideas: hijo devuelva info dada por el padre
}
