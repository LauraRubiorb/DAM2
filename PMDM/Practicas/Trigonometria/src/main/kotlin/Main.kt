import model.Circulo
import model.Rectangulo
import model.Triangulo

fun main() {
    var radio: Double
    var altura: Double
    var base: Double
    do {
        println("1.Calcular area circulo")
        println("2.Calcular diametro circulo")
        println("3.Calcular area rectangulo")
        println("4.Calcular perimetro rectangulo")
        println("5.Calcular area triangulo")
        println("6.Salir")
        val opcion = readln().toInt()
        when (opcion) {
            1 -> {
                println("Introduce el radio")
                radio = readln().toDouble()
                val circulo = Circulo(radio)
                circulo.calcularArea()
            }

            2 -> {
                println("Introduce el radio")
                radio = readln().toDouble()
                val circulo = Circulo(radio)
                circulo.calcularDiametro()
            }

            3 -> {
                println("Introduce la base")
                base = readln().toDouble()
                println("Introduce la altura")
                altura = readln().toDouble()
                val rectangulo = Rectangulo(base, altura)
                rectangulo.calcularArea()
            }
            4 -> {
                println("Introduce la base")
                base = readln().toDouble()
                println("Introduce la altura")
                altura = readln().toDouble()
                val rectangulo = Rectangulo(base, altura)
                rectangulo.perimetro()
            }
            5 -> {
                println("Introduce la base")
                base = readln().toDouble()
                println("Introduce la altura")
                altura = readln().toDouble()
                val triangulo = Triangulo(base,altura)
                triangulo.area()
            }
        }

    } while (opcion != 6)
}