package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Getter
@Setter
public class Jugador {
    String nombre;
    String dni;
    int dinero;
    ArrayList<Carton> listaCartones;

    public Jugador() {
        listaCartones = new ArrayList<>();
    }

    public Jugador(String nombre, int dinero, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.dinero = dinero;
    }
}
