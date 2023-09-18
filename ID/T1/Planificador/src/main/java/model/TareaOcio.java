package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class TareaOcio extends Tarea{
    private String ubicacion;
    private int presupuesto;

    public TareaOcio() {
        super();
    }

    @Override
    public void verDetalle() {
        super.verDetalle();
    }

    public TareaOcio(String ubicacion, int presupuesto) {
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    public TareaOcio(int id, String titulo, EnumPrioridad prioridad, String descripcion, String ubicacion, int presupuesto) {
        super(id, titulo, prioridad, descripcion);
        this.ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString()+ "TareaOcio{" +
                "ubicacion='" + ubicacion + '\'' +
                ", presupuesto=" + presupuesto +
                '}';
    }
}
