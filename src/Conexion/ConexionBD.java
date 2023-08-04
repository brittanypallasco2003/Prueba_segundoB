package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    public static final String cadenaConexionBD="jdbc:mysql://localhost/info";
    public static final String userName="root";
    public static final String pass="root_bas3";

    Connection connection =null;

    public ConexionBD() {
        try {
            connection= DriverManager.getConnection(cadenaConexionBD,userName,pass);
            System.out.println("Conexion Establecida");
        }catch (SQLException exception){
            System.out.println("Error de conexion: "+exception.getMessage());
            throw new RuntimeException(exception);
        }
    }

}

