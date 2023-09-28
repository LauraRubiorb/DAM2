package model

class Triangulo(var base: Double, var altura: Double) {
    fun mostrarDatos(): Unit {
        println("Base $base")
        println("Altura $altura")
        println("Area ${area()}")
    }

    fun area(): Double {
        var area = (base * altura) / 2
        return area
    }

}