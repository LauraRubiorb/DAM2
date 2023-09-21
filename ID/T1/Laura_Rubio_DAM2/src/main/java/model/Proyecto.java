package model;

import com.mysql.cj.protocol.a.result.AbstractResultsetRows;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

@Data
@Setter
@Getter
public class Proyecto {
    //Constarán de un titulo, descripción, integrantes (conjunto de
    //alumnos), profesor encargado, contenido
    int id;
    String titulo;
    String descripcion;
    String profesorEncargado;
    String contenido;
    ArrayList<Alumno> listaAlumnosProyectos;

    public Proyecto() {
        listaAlumnosProyectos = new ArrayList<>();
    }

    public Proyecto(int id, String titulo, String descripcion, String profesorEncargado, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.profesorEncargado = profesorEncargado;
        this.contenido = contenido;
        listaAlumnosProyectos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id='" + id + '\'' +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", profesorEncargado='" + profesorEncargado + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }
}
