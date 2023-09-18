import java.util.ArrayList

//LISTAS


fun main() {
    val lista = ArrayList<Int>()
    lista.add(1)
    lista.add(2)
    lista.add(6)
    lista.add(3)
    lista.add(7)
    lista.add(9)

    println(ejercicio1(lista))
}

//Crea una función que tome una lista de números enteros y retorne el número máximo de la lista.
fun ejercicio1(lista: ArrayList<Int>): Int {
    var posicion = 0
    var mayor = 0
    lista.forEach {
        if (posicion > it) {
            mayor = posicion
            return mayor
        }
        posicion++
    }

}