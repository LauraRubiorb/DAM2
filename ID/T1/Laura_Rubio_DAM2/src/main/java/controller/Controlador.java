package controller;

import database.GestionDB;
import database.SchemaDB;
import model.Alumno;

import java.sql.*;
import java.util.Scanner;

public class Controlador {
    Scanner scanner = new Scanner(System.in);
    private Connection connection;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    public Controlador() {
        connection = new GestionDB().getConnection();
    }

    public boolean existeDNI(String dni) {
        String query = "SELECT %s FROM %s";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(query, SchemaDB.DNI1, SchemaDB.TABLA1));
            if (dni == SchemaDB.DNI1) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean existeID(int id) {
        String query = "SELECT * FROM %s WHERE %s == %d";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(query, SchemaDB.TABLA1, SchemaDB.ID1, id));
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    //add alumno
    public void agregarAlumno(String nombre, String apellido, String dni) {
        if (!existeDNI(dni)) {
            try {
                statement = connection.createStatement();
                String query = "INSERT INTO %s(%s,%s,%s)values('%s','%s','%s')";
                statement.execute(String.format(query, SchemaDB.TABLA1,
                        SchemaDB.NOMBRE1, SchemaDB.APELLIDO1, SchemaDB.DNI1,
                        nombre, apellido, dni));
                System.out.println("Agregado correctamente");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Este alumno ya esta añadido");
    }

    //add profe
    public void agregarProfe(String dni, String nombre, String apellido, String asignatura) {
        if (!existeDNI(dni)) {
            try {
                statement = connection.createStatement();
                String query = "INSERT INTO %s(%s,%s,%s,%s)values('%s','%s','%s','%s')";
                statement.execute(String.format(query,
                        SchemaDB.TABLA2, SchemaDB.DNI2, SchemaDB.NOMBRE2, SchemaDB.APELLIDO2, SchemaDB.ASGIN2,
                        dni, nombre, apellido, asignatura));
                System.out.println("Agregado correctamente");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("Este profesor ya esta añadido");
    }

    //add proyecto
    public void addProyecto(String titulo, String desc, String profe, String contenido) {
        //MAX 3 integrantes
        try {
            statement = connection.createStatement();
            String query = "INSERT INTO %s(%s,%s,%s,%s,%d)values('%s','%s','%s','%s',%d)";
            statement.execute(String.format(query, SchemaDB.TABLA3,
                    SchemaDB.TITULO3, SchemaDB.DESC3, SchemaDB.PROFE3, SchemaDB.CONTENIDO3,
                    titulo, desc, profe, contenido));
            System.out.println("Agregado correctamente");
            int contador = 0;
            do {
                System.out.println("Añadir alumnos al proyecto");
                System.out.println("Introduzca el id del alumno");
                int idAlumno = scanner.nextInt();
                if (!existeID(idAlumno)) {
                    //"UPDATE usuario SET nombre = '%s' WHERE nombre = '%s'";
                    String query2 = "UPDATE %s SET %s = '%s' WHERE %s= '%s'";
                    statement = connection.createStatement();
                    statement.execute(query2, SchemaDB.TABLA3, SchemaDB.idAlumno3, idAlumno, SchemaDB.idAlumno3, 0);
                }

            } while (contador1 != 3);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //listar proyectos
    public void listarProyectos() {
        String query = "SELECT * FROM %s";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(String.format(query, SchemaDB.TABLA3));
            if (resultSet != null) {
                while (resultSet.next()) {
                    String titulo = resultSet.getString("titulo");
                    String desc = resultSet.getString("descripcion");
                    String contenido = resultSet.getString("contenido");
                    String profe = resultSet.getString("profesorEncargado");
                    System.out.printf("El proyecto es: %s %s, %s, %s", resultSet.getRow(), titulo, desc, contenido, profe);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}