package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Getter
@Setter

public class Lista implements Gestionable {
    int id;
    ArrayList<String> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public Lista(int id) {
        this.id = id;
        lista = new ArrayList<>();
    }

    @Override
    public void verDetalle() {
        System.out.println(id);
        if (lista.size() > 0) {
            for (String item : lista) {
                System.out.println(item);
            }
        }
    }

}
