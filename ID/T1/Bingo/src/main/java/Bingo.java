import lombok.Data;
import model.Carton;
import model.Jugador;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.ArrayList;
import java.util.Scanner;

@Data
public class Bingo {
    Scanner scanner = new Scanner(System.in);
    int aleatorioJuego;
    int cantidadCartones = 0;
    ArrayList<Jugador> listaJugadores;

    public Bingo() {
        listaJugadores = new ArrayList<>();
    }

    public void crearJugador(String nombre, int dinero, String dni) {
        if (dinero > 0) {
            Jugador jugador = new Jugador(nombre, dinero, dni);
            listaJugadores.add(jugador);
        } else System.out.println("Debe introducir mas dinero");
    }

    public void comprarCarton(String dni) {
        for (Jugador item : listaJugadores) {
            if (dni.equalsIgnoreCase(item.getDni())) {
                System.out.println("¿Cuantos cartones desea comprar?");
                cantidadCartones = scanner.nextInt();
                for (int i = 0; i < cantidadCartones; i++) {
                    Carton carton = new Carton();
                    carton.rellenarCarton();
                    item.getListaCartones().add(carton);
                }
            }
        }
    }

    public void inicioJuego() {
        aleatorioJuego = (int) (Math.random() * 99);
        System.out.println(aleatorioJuego);
        for (Jugador jugador : listaJugadores) {
            for (int i = 0; i < jugador.getListaCartones().size(); i++) {
                do {
                    if (i == aleatorioJuego) {
                        System.out.println("¡Bingo!");
                        try {
                            Thread.sleep(5 * 1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } while (true);//idk todo
            }
        }
    }
}
