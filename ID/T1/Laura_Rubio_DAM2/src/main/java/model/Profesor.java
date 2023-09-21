package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Profesor {
    //Profesores: dni, nombre, apellido, asignatura
    String dni;
    String nombre;
    String apellido;
    String asignatura;

    public Profesor() {
    }

    public Profesor(String dni, String nombre, String apellido, String asignatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
    }
}
