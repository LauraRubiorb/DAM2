package model;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
//PASAR 5 SG

@Data
public class Carton {
    int id;
    final int precio = 1;
    //Array array[10];
    //todo 10 numeros unicos del 1-99
    Array [][] carton = new Array[3][9];

    //acertados == 10 num PREMIOOOO

    //PASOS PARA CREAR UN CARTON DE BINGO
    /*
1.Rellenar nuestra matriz de números.
2.Ordenar números por cada columna.
3.Poner los huecos.
4.Mostrar el cartón, sustituyendo -1 por el carácter deseado.
     */
    public static int generaNumeros(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + (min));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void rellenarCarton(Array[][] carton){
        int aleatorio;
        boolean repetido;
        //recorremos
        for (int i = 0; i < carton[0].length ; i++) {
            for (int j = 0; j <carton.length ; j++) {

            }
        }
    }



}
