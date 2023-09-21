package org.example;

import controller.Controlador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1. Agregar alumno: Al seleccionar este menú se pedirán todos los datos y se
        //mostrará el alumno el mensaje de confirmación. No es posible agregar dos
        //alumnos con el mismo dni
        //2. Agregar profesor: Al seleccionar este menú se pedirán todos los datos y se
        //mostrara un mensaje de confirmación. No es posible agregar dos profesores
        //con el mismo dni
        //3. Agregar proyecto: se pedirán los datos por teclado. Un proyecto como máximo
        //tendrá 3 integrantes. Los irá pidiendo de forma itera3va
        //4. Listar proyectos: Mostrará la información de todos los proyectos junto con sus
        //integrantes
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();
        String nombre, apellido, dni , asignatura, profe,contenido,titulo,desc;
        int opcionMenu = 0;
        do {
            System.out.println("Seleccione una opción");
            opcionMenu = scanner.nextInt();
            System.out.println("1.Agregar alumno\n2.Agregar profesor.\n3.Agregar proyecto\n4.Listar proyectos\n5.Salir");
            switch (opcionMenu) {
                case 1:
                    System.out.println("Introduzca el nombre");
                    nombre = scanner.next();
                    System.out.println("Introduzca apellido");
                    apellido = scanner.next();
                    System.out.println("Introduzca dni");
                    dni = scanner.next();
                    controlador.agregarAlumno(nombre,apellido,dni);
                    break;
                case 2:
                    System.out.println("Introduzca el nombre");
                    nombre = scanner.next();
                    System.out.println("Introduzca apellido");
                    apellido = scanner.next();
                    System.out.println("Introduzca dni");
                    dni = scanner.next();
                    System.out.println("Introduzca asignatura");
                    asignatura = scanner.next();
                    controlador.agregarProfe(dni,nombre,apellido,asignatura);
                    break;
                case 3:
                    System.out.println("Introduzca el titulo");
                    titulo = scanner.next();
                    System.out.println("Introduzca descripcion");
                    desc = scanner.next();
                    System.out.println("Introduzca profe");
                    profe = scanner.next();
                    System.out.println("Introduzca contenido");
                    contenido = scanner.next();
                    controlador.agregarProfe(titulo,desc,profe,contenido);
                    break;
                case 4:
                    controlador.listarProyectos();
                    break;
                case 5:
                    System.out.println("saliendo");
                    break;
            }
        } while (opcionMenu != 5);
    }
}