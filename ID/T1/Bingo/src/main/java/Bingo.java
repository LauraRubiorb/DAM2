import model.Jugador;

import java.util.ArrayList;
import java.util.Scanner;

public class Bingo {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Jugador> listaJugadores;

    public Bingo() {
        listaJugadores = new ArrayList<>();
    }

    public void crearJugador(String nombre, int dinero) {
        if (dinero > 0) {
            Jugador jugador = new Jugador(nombre, dinero);
            listaJugadores.add(jugador);
        } else System.out.println("Debe introducir mas dinero");
    }
    public void comprarCarton(String dni,int numCartones){
        System.out.println();
    }
}
