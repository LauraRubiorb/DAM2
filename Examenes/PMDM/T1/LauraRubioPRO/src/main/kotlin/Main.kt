import model.Fantasy
import model.Participante

fun main(args: Array<String>) {
    val liga : Fantasy = Fantasy()
    liga.addJugadores()
   //liga.fichar()
    liga.listarMayores()
    liga.ganador()

}