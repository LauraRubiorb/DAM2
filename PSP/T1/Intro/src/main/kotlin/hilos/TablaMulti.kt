package hilos

class Operaciones(private val num: Int) : Thread() {
    override fun run() {
        println("Tabla de multiplicar del $num")
        println("===============================")
        try {
            for (i in 1..10) {
                val resultado = num * i
                println("$num x $i = $resultado")
            }
            println("Fin tabla del $num")
        } catch (ex: Exception) {
        }
    }
}

fun main() {
    println("Tablas de Multiplicar:")
    print("Introduce el primer número: ")
    var num1 = readLine()?.toInt()
    //num1 = 5
    print("Introduce el segundo número: ")
    var num2 = readLine()?.toInt()
    //num2 = 4

    if (num1 != null && num2 != null) {
        val op1 = Operaciones(num1)
        val op2 = Operaciones(num2)

        try {
            op1.start()
            op1.join()

            op2.start()
            op2.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    } else {
        println("Entrada inválida. Introduce números válidos.")
    }
}