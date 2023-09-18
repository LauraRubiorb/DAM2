import kotlin.random.Random

//KT para crear una clase, objetos
//file crear funciones, class
//field palabra reservada
//retorno void == unit
//swits == when
//val NO reasigar valor, no puede mutar FINAL
//var es mutable
//? null
//Lateinit para inicializar mas adelante
var nombre: String = "Laura"
    get() {
        return field
    }

var edad: Int = 23
    get() {
        return field
    }
    set(value) {
        field = value + 1
    }

fun estructuraIf(): Unit {
    var numero: Int = 6
    if (numero > 0) {
        println("El numero es positivo")
    } else
        println("El numero es negativo")
}

fun estructuraWhen(): Unit {
    var numero: Int = 7
    when (numero) {
        !in 1..10 -> {
            println("Caso 1 a 10")
        }

        else -> {
            println("Caso recto")
        }
    }
}

fun estructuraFor(): Unit {
    //for (i in 0..10 step 2) {println(i)}
    //FOREACH(1..10).forEach { println(it) }
    /*(5..20).forEachIndexed { posicion, elemento -> println("El elemento es $elemento esta en la posicion $posicion") }*/
    println("El numero aleatoio generado es ${(1..100).random()}")
}

//100 aleatorios entre 0 y 50
fun estructura(): Unit {
    (0..100).forEach { println(Random(System.nanoTime()).nextInt(100)) }

}

fun main(args: Array<String>) {
    fun ejercicio1() {
        println("Introduce un numero entero")
        var numero: Int = readln().toInt();
        for (i in 0..20) {
            if (i % 2 == 0) {
                println("El numero es par")
            } else println("Es impar")
        }
    }
    fun ejercicio2(){
        println("Introduce un numero")
        var numero:Int = readln().toInt()
        if (numero == 0){ println("El numero es 0") }
        else if(numero>0){println("El numero es positivo")}
        else println("El numero es negativo")
    }
    fun ejercicio3(){
        println("Introduce un numero")
        var numero: Int = readln().toInt()

    }

}

