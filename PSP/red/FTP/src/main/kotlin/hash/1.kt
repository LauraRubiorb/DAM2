package hash

import java.security.Security

fun main() {
    val algoritmo = HashSet<String>()
    val proveedores = Security.getProviders()

    for (i in proveedores){
        val claves = i.keys
        for (clave in claves){
            val nombre_algoritmo = clave.toString()
            println(nombre_algoritmo)
        }
    }
}