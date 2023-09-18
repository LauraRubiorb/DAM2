import model.*;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int idModificar = 0;
        int idCompletar = 0;

        Planificador planificador = new Planificador();
        do {
            System.out.println("¿Seleccione una opcion?");
            System.out.print("""
                    1.Agregar Tarea
                    2.Listar Tareas
                    3.Modificar tarea
                    4.Completar tarea
                    5.Listar tareas completadas
                    6.Listar tareas incompletadas
                    7.Salir
                    """);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    planificador.crearTarea();
                    break;
                case 2:
                    System.out.println("Lista de sus tareas");
                    planificador.listarTareas();
                    break;
                case 3:
                    System.out.println("Introduce el id de la tarea que desee modificar");
                    idModificar = scanner.nextInt();
                    planificador.modificarTarea(idModificar);
                    break;
                case 4:
                    System.out.println("Introduce el id de la tarea a completar");
                    idCompletar = scanner.nextInt();
                    planificador.completarTarea(idCompletar);
                    break;
                case 5:
                    planificador.listarCompletas();
                    break;
                case 6:
                    planificador.listarIncompletas();
                    break;
                case 7:
                    System.out.println("Saliendo");
            }
        }
        while (opcion != 6);
    }
}
