package model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Getter
@Setter
public class Lista {
    int id;
    ArrayList<String> lista;

    public Lista() {
        lista = new ArrayList<>();
    }

    public Lista(int id) {
        this.id = id;
    }
}
