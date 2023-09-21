package model

class Rectangulo(var base: Double, val altura: Double) {
    //- Tenga un constructor con dos parámetros de double que inicialice base y altura.
    //- Tenga un método calcularArea que no recibe ningún parámetro y devuelve un double. (base *altura)
    //- Tenga un método calcularPerimetro que no recibe ningún parámetro y devuelve un double. (2*(b+h))
    fun calcularArea():Double{
        val area = base*altura
        return area
    }
    fun calcularPerim():Double{
        val perim = 2*(base+altura)
        return perim
    }
}