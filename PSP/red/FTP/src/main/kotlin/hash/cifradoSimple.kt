package hash

import javax.swing.plaf.metal.MetalBorders.PaletteBorder


fun cifrar(palabra : String, desplazamiento : Int): String{
    return palabra.map { (it+desplazamiento).toChar() }.joinToString { "" }
}
fun descifrar(palabraCifrada : String, desplazamiento : Int): String{
    return palabraCifrada.map { (it-desplazamiento).toChar() }.joinToString { "" }

}
fun main() {
    val palabra = "hola"
    val palabracifrar = cifrar(palabra,2)//le metemos la palabra y el desplazamiento
    println(palabracifrar)

    val palabraDescifrada = descifrar(palabracifrar,3)
    println(palabraDescifrada)
}
