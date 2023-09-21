package model;

import database.GestionDB;
import database.SchemaDB;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

@Setter
@Getter
@Data
public class Planificador {
    Connection connection;
    Scanner scanner = new Scanner(System.in);
    int opcionCrearTarea = 0;
    String opcionSubtarea0;
    int opcionSubtarea = 0;
    int opcionPrior = 0;
    int idsubtarea = 0;
    ArrayList<Tarea> listaTareas;
    ArrayList<Gestionable> listaGestion;
    int id = 0, presupuesto = 0;
    String titulo, descripcion, ubi, proyecto;
    EnumPrioridad enumPrioridad = null;
    Statement statement;
    PreparedStatement preparedStatement;
    ResultSet resultSet;


    public Planificador() {
//inicializamos el arraaylist
        listaTareas = new ArrayList<>();
        listaGestion = new ArrayList<>();
        connection = new GestionDB().getConnection();

    }
    //metodo que permite agregar una tarea al planiff

    public boolean addTarea(Tarea tarea) {
        return listaTareas.add(tarea);
    }

    //primero comprobamos si la lista tiene alguna tarea.->return false xq no existe o xq el id no esta en la lista
    //return true si existe una tarea con ese id
    public void addGestionableSQL(Gestionable gestionable) {
        //tarea
        try {
            statement = connection.createStatement();
            if (gestionable instanceof Tarea) {
                String query = "INSERT INTO %s (%s,%s,%s,%d,%b,%d) VALUES"+("%s,%s,%s,%d,%b,%d");
                statement.execute(String.format(query, SchemaDB.TABLA1,
                        SchemaDB.TITULO1,SchemaDB.PRIO1,SchemaDB.FECHA1,SchemaDB.DESC1,SchemaDB.COMPLETADA1,SchemaDB.IDSUB1,
                        ((Tarea) gestionable).getTitulo(),((Tarea) gestionable).getPrioridad(),((Tarea) gestionable).getFecha(),
                        ((Tarea) gestionable).getDescripcion(),((Tarea) gestionable).getCompletada(),((Tarea) gestionable).getListaSubtareas()));
                statement.execute(query);
                //add database
            }else if (gestionable instanceof Lista) {
        //lista
                String query = "INSERT INTO %s()";
                preparedStatement = connection.prepareStatement(query);
            }


        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }
    public void getAllTareas(){
        try {
            statement = connection.createStatement();
            resultSet  =statement.executeQuery("SELECT * FROM");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean existeId(int id) {
        if (listaGestion.size() == 0) {
            return false;
        } else {
            for (Gestionable item : listaGestion) {
                if (item.getId() == id) {
                    return true;
                }
            }
            return false;
        }
    }

    public void crearTarea() {
        System.out.println("¿La tarea que desea añadir es una subtarea?Si/no");
        opcionSubtarea0 = scanner.next();
        //como no quiere una subtarea se hace lo normal
        if (opcionSubtarea0.equalsIgnoreCase("No")) {
            System.out.println("Tarea de tipo 1.OCIO/2.TRABAJO/3.OTRO");
            opcionCrearTarea = scanner.nextInt();
            System.out.println("Indica id");
            id = scanner.nextInt();
            // comprobar el id
            if (existeId(id)) {//si el id introducido coincide devuelve TRUE osea que ya existe
                System.out.println("La tarea ya existe");
            } else {//creamos la tarea con lo comun y luego pregunto
                System.out.println("Indica titulo");
                titulo = scanner.next();
                System.out.println("Indica desc");
                descripcion = scanner.next();
                //indicar prioridad
                System.out.println("Indica prioridad: 1. baja 2. media 3. alta");
                opcionPrior = scanner.nextInt();
                switch (opcionPrior) {
                    case 1 -> enumPrioridad = EnumPrioridad.Baja;
                    case 2 -> enumPrioridad = EnumPrioridad.Media;
                    case 3 -> enumPrioridad = EnumPrioridad.Alta;
                }
                //preguntamos el tipo
                //tipo ocio
                if (opcionCrearTarea == 1) {
                    System.out.println("Indica ubicacion");
                    ubi = scanner.next();
                    System.out.println("Indica presupuesto");
                    presupuesto = scanner.nextInt();//pedimos y creamos
                    TareaOcio tareaOcio = new TareaOcio(id, titulo, enumPrioridad, descripcion, ubi, presupuesto);
                    listaTareas.add(tareaOcio);
                    System.out.println("Tarea añadida");
                }
                //tipo trabajo
                else if (opcionCrearTarea == 2) {
                    System.out.println("Indica el nombre del proyecto");
                    proyecto = scanner.next();//pedimos y creamos
                    TareaTrabajo tareaTrabajo = new TareaTrabajo(id, titulo, enumPrioridad, descripcion, proyecto);
                    listaTareas.add(tareaTrabajo);
                    System.out.println("Tarea añadida");
                }
                //Otros
                else {
                    Tarea tarea = new Tarea(id, titulo, enumPrioridad, descripcion);
                    listaTareas.add(tarea);
                }
            }
        } else if (opcionSubtarea0.equalsIgnoreCase("Si")) {
            //creamos la sub tarea
            System.out.println("Introduce el id de la tarea de la cual depende");
            idsubtarea = scanner.nextInt();
            //si existe el id de la tarea de la que depende se añadira a la lista
            if (existeId(idsubtarea)) {
                System.out.println("Indica id");
                id = scanner.nextInt();
                if (existeId(id)) {//si el id introducido coincide devuelve TRUE osea que ya existe
                    System.out.println("La tarea ya existe");
                } else {//creamos la tarea con lo comun y luego pregunto
                    System.out.println("Indica titulo");
                    titulo = scanner.next();
                    System.out.println("Indica desc");
                    descripcion = scanner.next();
                    //indicar prioridad
                    System.out.println("Indica prioridad: 1. baja 2. media 3. alta");
                    opcionPrior = scanner.nextInt();
                    switch (opcionPrior) {
                        case 1 -> enumPrioridad = EnumPrioridad.Baja;
                        case 2 -> enumPrioridad = EnumPrioridad.Media;
                        case 3 -> enumPrioridad = EnumPrioridad.Alta;
                    }
                    for (Tarea item : listaTareas) {
                        if (item.getId() == idsubtarea) {
                            Tarea tarea = new Tarea(id, titulo, enumPrioridad, descripcion);
                            item.getListaSubtareas().add(tarea);
                            System.out.println("Subtarea añadida");
                        } else System.out.println("Tarea no encontrada");
                    }
                }
            } else System.out.println("Error");
        }
    }

    public void listarTareas() {
        System.out.println(listaTareas.size());
        if (listaTareas.size() == 0) {
            System.out.println("Tu lista esta vacia");
        } else {
            for (Tarea item : listaTareas) {
                System.out.println(item);
            }
        }
    }

    public void modificarTarea(int numero) {
        String descripcion;
        int pri;
        for (Tarea item : listaTareas) {
            if (item.getId() == numero) {
                System.out.println("Escriba la nueva descripcion");
                descripcion = scanner.next();
                item.setDescripcion(descripcion);
                System.out.println("Escriba la nueva prioridad(1-2-3)");
                pri = scanner.nextInt();
                if (pri == 1) item.setPrioridad(EnumPrioridad.Baja);
                else if (pri == 2) {
                    item.setPrioridad(EnumPrioridad.Media);
                } else item.setPrioridad(EnumPrioridad.Alta);
            } else System.out.println("Tarea no encontrada");
        }
    }

   /* public void completarTarea(int id) {
        if (existeId(id)) {
            for (Tarea item : listaSubtareas) {
                item.setCompletada(true);
                System.out.println("Tarea completada");
            }
        } else System.out.println("Tarea no encontrada");
    TODO}*/

    public void listarCompletas() {
        for (Tarea item : listaTareas) {
            if (item.getCompletada()) {
                System.out.println(item);
            }
        }
    }

    public void listarIncompletas() {
        for (Tarea item : listaTareas) {
            if (!item.getCompletada()) {
                System.out.println(item);
            }
        }
    }
}

