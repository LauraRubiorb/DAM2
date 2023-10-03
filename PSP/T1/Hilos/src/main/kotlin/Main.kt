fun main(args: Array<String>) {

    println("Introduce el numero del que quieres ver la tabla")
    val num = readln().toInt()
    val tabla = Thread {
        var i = 1
        while (i<11){
            println("$num x $i = ${num*i}")
            i++
        }
    }
    tabla.start()
    Thread.sleep(1000)
    tabla.start()
    tabla.join()

}