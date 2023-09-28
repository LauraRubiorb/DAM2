package model

class Rectangulo(var base: Double, var altura: Double) {
    fun mostrarDatos(): Unit {
        println("Base $base")
        println("Altura $altura")
        println("Area ${calcularArea()}")
        println("Perimetro ${perimetro()}")
    }

    fun calcularArea(): Double {
        val area = base * altura
        return area
    }

    fun perimetro(): Double {
        val per = 2 * (base + altura)
        return per
    }
}