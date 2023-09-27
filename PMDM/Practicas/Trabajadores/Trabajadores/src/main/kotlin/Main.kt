import controller.Empresa
import model.Asalariado

fun main(args: Array<String>) {
    var e1: Empresa = Empresa()

    do {
        println("Seleccione una opcion: ")
        println("1.Registrar trabajador")
        println("2.Listar trabajador")
        println("3.Mostrar trabajador")
        println("4.Despedir trabajador")
        println("5.Salir")
        val opcion: Int = readln().toInt()
        when (opcion) {
            1 -> {
                println("Escriba su nombre")
                val nombre: String = readln()
                println("Escriba su apellido")
                val apellido: String = readln()
                println("Escriba su dni")
                val dni: String = readln()
                println("Escriba su sueldo")
                val sueldo: Int = readln().toInt()
                e1.crearTrabajador(nombre, apellido, dni, sueldo)
            }

            2 -> {
                e1.mostrarTrabajadores()
            }

            3 -> {
                println("Escriba su dni")
                val dni: String = readln()
                e1.datosTrabajador(dni)
            }

            4 -> {
                println("Escriba su dni")
                val dni: String = readln()
                e1.existeDni(dni)
            }
        }
    } while (opcion != 5)
}