package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Carton {
    int idCarton;
    final int PRECIO = 1;
    int[] carton = new int[10];

    public Carton() {
    }

    public Carton(int idCarton) {
        this.idCarton = idCarton;
    }

    public void rellenarCarton() {
        int aleatorio = 0;
        boolean repe;
        do {
            repe = false;
            for (int i = 0; i < carton.length; i++) {
                aleatorio = (int) (Math.random() * (11));
                if (i != aleatorio)
                    carton[i] = aleatorio;
                repe = true;
            }
        } while (repe);
    }
}
