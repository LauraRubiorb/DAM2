fun funcionSuma(operador1: Int, operador2: Int): Int {
    var suma = operador1 + operador2
    //println("El resultado de $operador1 + $operador2 es $suma")
    return suma
}

//int = 0 o poniendole la ?, diciendole que puede ser nullo
fun funcionOptativos(param1: String, param2: Int?) {
    println("Parametro 1 $param1 y parametro 2 es $param2")
}

// ->String
fun pedirNombre(): String {
    println("Introduzca su nombre")
    var nombre = readln()
    return nombre
}

//String->Unit
fun imprimirMensaje(palabra: String) {
    var nombre = pedirNombre()
    println(palabra + "$nombre")
}

fun funcionPArametroFuncion(param1: (() -> String)?, param2: String) {
    var nombre = param1?.invoke() ?:"defecto" //si acaba suendo null escribes defecto//funcion vacia, como la funcion entera puede ser nula ?
    println("$param2 $nombre")
}

//FUNCIONES LAMBDA: no es necesario declararla
var funcionSumaFlecha: ((Int, Int)->Int) = {param1: Int, param2: Int ->param1+param2}//tipo funcion

fun main() {
    //println(funcionSuma(2, 4))//posicional
    //println(funcionSuma(operador1 = 4, operador2 = 2))//nominal
    //funcionOptativos("uno", null)
    //imprimirMensaje("Esto es un ejemplo de mensaje")
    //funcionPArametroFuncion({ pedirNombre() }, "mensaje")
    //println(funcionSumaFlecha(4,8))
}
// Crea una función que sume dos números enteros y retorne el result
fun ejercicio1(num1:Int, num2:Int):Int{
    var suma = num1+num2
    return suma
}
//Crea una función que tome un número entero y retorne verdadero si es par y falso si es impar.
fun ejercicio2(num1: Int):Boolean{return num1%2==0}
var funcionPar ={x:Int ->x%2==0}
//Crea una función que tome un número entero y que retorne una lista de los números enteros desde 1 hasta el número ingresado.
fun listaNumeros (x:Int){ (1..x).forEach { println(it) }

}