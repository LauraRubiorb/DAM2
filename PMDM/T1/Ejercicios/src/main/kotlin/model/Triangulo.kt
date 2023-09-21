package model

class Triangulo(var base: Double, var altura: Double) {
    //- Tenga un constructor con 2 parámetros de tipo double que inicialice base y altura.
    //- Tenga un método calcularArea que no recibe ningún parámetro y devuelve un double. (b*a)/2
    fun calcularArea():Double{
        val area = (base*altura)/2
        return area
    }

}