import model.User
import model.UsuarioExtendido

fun main() {
    var usuario: User = User("Laura", "Rubio", "50193939L")
    usuario.mostrarDatos()
    var usuarioExtendido : UsuarioExtendido = UsuarioExtendido("Laura","Rubio","123s",2,3)
    usuarioExtendido.mostrarDatos()
}