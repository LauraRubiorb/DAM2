package model

class Fantasy {
    var participante: Participante = Participante("X", 4, id = 1)
    var participante2: Participante = Participante("X", 4, id = 2)
    var participante3: Participante = Participante("X", 4, id = 3)
    var participante4: Participante = Participante("X", 4, id = 4)
    lateinit var listaparticipante: ArrayList<Participante>
    lateinit var jugadores: ArrayList<Jugador>

    fun addJugadores(): Unit {
        jugadores = ArrayList()
        jugadores.add(Jugador(1, "Marc-André ter Stegen", "Portero", 3000000, 10))
        jugadores.add(Jugador(2, "Ronald Araújo", "Defensa", 4000000, 11))
        jugadores.add(Jugador(3, "Eric García", "Defensa", 1000000, 7))
        jugadores.add(Jugador(4, "Pedri", "Mediocentro", 5000000, 20))
        jugadores.add(Jugador(5, "Robert Lewandowski", "Delantero", 8000000, 14))
        jugadores.add(Jugador(6, "Courtois", "Portero", 3000000, 12))
        jugadores.add(Jugador(7, "David Alaba", "Defensa", 4000000, 11))
        jugadores.add(Jugador(8, "Jesús Vallejo", "Defensa", 500000, 9))
        jugadores.add(Jugador(9, "Luka Modric", "Mediocentro", 5000000, 23))
        jugadores.add(Jugador(10, "Karim Benzema", "Delantero", 8000000, 35))
        jugadores.add(Jugador(11, "Ledesma", "Portero", 500000, 20))
        jugadores.add(Jugador(12, "Juan Cala", "Defensa", 300000, 43))
        jugadores.add(Jugador(13, "Zaldua", "Defensa", 400000, 20))
        jugadores.add(Jugador(14, "Alez Fernández", "Mediocentro", 700000, 10))
        jugadores.add(Jugador(15, "Choco Lozano", "Delantero", 800000, 11))
        jugadores.add(Jugador(16, "Rajković", "Portero", 300000, 23))
        jugadores.add(Jugador(17, "Raíllo", "Defensa", 200000, 40))
        jugadores.add(Jugador(18, "Maffeo", "Defensa", 300000, 23))
        jugadores.add(Jugador(19, "Ruiz de Galarreta", "Mediocentro", 400000, 12))
        jugadores.add(Jugador(25, "Ángel", "Delantero", 300000, 21))
        jugadores.add(Jugador(20, "Remiro", "Portero", 1000000, 22))
        jugadores.add(Jugador(21, "Elustondo", "Defensa", 900000, 47))
        jugadores.add(Jugador(22, "Zubeldia", "Defensa", 800000, 50))
        jugadores.add(Jugador(23, "Zubimendi", "Mediocentro", 1000000, 23))
        jugadores.add(Jugador(24, "Take Kubo", "Delantero", 800000, 20))
    }

    fun listarMayores(): Unit {
        val buscar = jugadores.filter { it.posicion > 3000000 }
        println(buscar)
    }

    fun fichar(participante: Participante): Unit {
        do {
            if (participante.plantilla.find { portero: Jugador -> portero.valor.equals("Portero") } != null) {
//
            } else {
                val porteros = jugadores.filter { portero: Jugador -> portero.valor.equals("Portero") }
                porteros.forEach { participante.plantilla.add(it) }
            }
            if (participante.plantilla.find { defensa: Jugador -> defensa.valor.equals("Defensa") } != null) {
//
            } else {
                val defensas = jugadores.filter { defensa: Jugador -> defensa.valor.equals("Defensa") }
                defensas.forEach { participante.plantilla.add(it) }
            }
            if (participante.plantilla.find { delantero: Jugador -> delantero.valor.equals("Delantero") } != null) {
//
            } else {
                val delantero = jugadores.filter { delantero: Jugador -> delantero.valor.equals("Delantero") }
                delantero.forEach { participante.plantilla.add(it) }

            }
            if (participante.plantilla.find { medio: Jugador -> medio.valor.equals("MedioCentro") } != null) {
                //
            } else {
                val medio = jugadores.filter { medio: Jugador -> medio.valor.equals("MedioCentro") }
                medio.forEach { participante.plantilla.add(it) }
            }

        } while (participante.presupuesto < 10000000 && participante.plantilla.size == 6)

    }

    fun ganador(): Unit {
        var suma = participante.plantilla.filter { jugador: Jugador -> jugador.puntos > 0 }
        suma += suma
        println(suma)
        var suma2 = participante2.plantilla.filter { jugador: Jugador -> jugador.puntos > 0 }
        suma2 += suma2
        println(suma2)
        var suma3 = participante3.plantilla.filter { jugador: Jugador -> jugador.puntos > 0 }
        suma3 += suma3
        println(suma3)
        if ((suma > suma2) && (suma > suma3)) {
            println("{participante.nombre}$ es ganador")
        }else if ((suma2 > suma) && (suma2 > suma3)){
            println("{participante2.nombre}$ es ganador")

        }else {
            println("{participante3.nombre}$ es ganador")
        }
    }
}