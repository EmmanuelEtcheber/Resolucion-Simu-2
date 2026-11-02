package Persistencia;

import Excepciones.ConexionFallidaException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String url = "jdbc:mysql://172.16.1.64:3306/acáPonenElNombreDeSuBD";
    private static final String username = "bdd1";
    private static final String password = "bdd1";
    public static Connection conexion;

    public static Connection getConexion() throws ConexionFallidaException {
        try {
            conexion = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new ConexionFallidaException();
        }
        return conexion;
    }

    public static void closeConexion() throws ConexionFallidaException {
        try {
            conexion.close();
        } catch (SQLException e) {
            throw new ConexionFallidaException();
        }
    }
}
