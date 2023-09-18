package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class Tarea implements Gestionable {
    private int id;
    private String titulo;
    private EnumPrioridad prioridad;
    private String fecha;
    private String descripcion;
    private Boolean completada;
    private ArrayList<Tarea> listaSubtareas;


    public Tarea() {
        this.fecha = "01/01/20";
        this.prioridad = EnumPrioridad.Baja;
        this.completada = false;
        listaSubtareas = new ArrayList<>();
    }

    public Tarea(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = "01/01/20";
        this.prioridad = EnumPrioridad.Baja;
        this.completada = false;
        listaSubtareas = new ArrayList<>();

    }

    public Tarea(int id, String titulo, EnumPrioridad prioridad, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.fecha = "01/01/20";
        this.completada = false;
        listaSubtareas = new ArrayList<>();

    }


    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada='" + completada + '\'' +
                '}';
    }

    @Override
    public void verDetalle() {

    }
}
