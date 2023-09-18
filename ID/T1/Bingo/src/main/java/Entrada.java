import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionMENU = 0;
        Bingo bingo = new Bingo();

        //var
        String nombre = null;
        int dinero = 0;
        int carton = 0;
        String dni = null;
        do {
            System.out.println("Seleccione una opcion");
            System.out.println("""
                    1.Crear jugador
                    2.Comprar carton
                    3.Iniciar el juego
                    4.Salir
                    """);
            scanner.nextInt();
            switch (opcionMENU) {
                case 1:
                    System.out.println("Introduzca nombre");
                    nombre = scanner.next();
                    System.out.println("Introduzca dinero");
                    dinero= scanner.nextInt();
                    bingo.crearJugador(nombre,dinero);
                    break;
                case 2:
                    System.out.println("Introduzca dni");
                    dni = scanner.next();
                    System.out.println("Introduzca la cantidad de cartones a comprar(1€ x carton");
                    carton= scanner.nextInt();
                    bingo.comprarCarton(nombre,carton);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
            }

        } while (opcionMENU != 4);
    }
}
