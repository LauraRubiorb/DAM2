package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class TareaTrabajo extends Tarea {
    private String proyecto;

    public TareaTrabajo() {
        super();
    }

    public TareaTrabajo(String proyecto) {
        this.proyecto = proyecto;
    }

    public TareaTrabajo(int id, String titulo, EnumPrioridad prioridad, String descripcion, String proyecto) {
        super(id, titulo, prioridad, descripcion);
        this.proyecto = proyecto;
    }
    @Override
    public String toString() {
        return super.toString() + "proyecto=" + proyecto;
    }
}
