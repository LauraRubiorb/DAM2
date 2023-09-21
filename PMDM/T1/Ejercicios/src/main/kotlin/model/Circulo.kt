package model

class Circulo(var radio: Double) {
    //- Tenga un constructor con un parámetro double que representa el radio
    //- Tenga un método calcularArea que no recibe ningún parámetro y devuelve un double. (Pi *R2)
    //- Tenga un método calcularDiametro que no recibe ningún parámetro y devuelve un double. (2*r)
    fun calcularArea(): Double {
        val area = Math.PI * (radio * radio)
        return area
    }

    fun calcularDiametro(): Double {
        val diametro = 2 * radio
        return diametro
    }
}