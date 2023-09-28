package model

import kotlin.math.pow

class Circulo(var radio: Double) {
    fun mostrarDatos(): Unit {
        println("Radio: $radio")
        println("Area del ciruclo es ${calcularArea()}")
        println("Diametro del circulo es ${calcularDiametro()}")
    }

    fun calcularArea(): Double {
        val area = Math.PI * (radio.pow(2))
        return area
    }
    fun calcularDiametro():Double{
        val diametro =  2 * radio
        return diametro
    }
}