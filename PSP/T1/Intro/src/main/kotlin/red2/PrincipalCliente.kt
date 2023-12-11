package red2


fun main() {
    val persona = Persona ("Antonio",25)
    val puerto = 1234
    val host = "localhost"

    val cliente = ClientePerso(host,puerto)
    cliente.enviarObjeto(persona)
}