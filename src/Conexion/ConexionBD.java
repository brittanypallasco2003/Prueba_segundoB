package Conexion;

import java.sql.*;

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

    //metodo consulta
    public ResultSet consultarRegistros(String strSetenciaSql){
        try{
            PreparedStatement pstm =connection.prepareStatement(strSetenciaSql);//prepara la sentencia sql para que se pueda ejecutar
            ResultSet respuesta=pstm.executeQuery();//obtiene y devuelve la info que se genera de la consulta (esa es la ejecucion de la sentencia)
            return respuesta;//retorna la info de la consulta
        }catch (Exception exception){
            System.out.println("Error al realizar la consulta: "+exception);
            return null;/*si no encuentra datos, no obtiene nada y por tanto, no retorna nada*/
        }

    }

    //-----------------------METODO PARA INSERCION/DELETE/UPDATE DE DATOS----------------
    public int ejecutarQuery(String strSentencia){
        try {
            PreparedStatement pstm=connection.prepareStatement(strSentencia);//prepara la sentencia sql para que se pueda ejecutar
            pstm.execute();//con esto se ejecuta la instruccion SQL
            return 1;
        }catch (SQLException sqlException){
            System.out.println("Hubo un error: "+sqlException);
            return 0;
        }
    }


}

