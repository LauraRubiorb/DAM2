package database;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Getter
@Setter
public class GestionDB {
    private Connection connection;

    public void gestioDB() {
        realizarConexion();
    }

    private void realizarConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="local1";
            String pass="";
            String host="192.168.64.2:3306";
            String dbName= "planificador";
            String url= "jdbc:mysql://"+host+"/"+dbName;
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void llamarConexion(){
        System.out.println(connection.toString());
    }
}

