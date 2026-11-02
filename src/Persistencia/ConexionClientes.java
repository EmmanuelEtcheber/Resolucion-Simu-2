package Persistencia;

import Excepciones.ClienteDuplicadoException;
import Excepciones.ConexionException;
import Excepciones.ConexionFallidaException;
import Excepciones.ConexionTablaExcepcion;
import Modelo.Cliente;

import java.sql.*;

public class ConexionClientes {
    public static void crearTablaCliente() throws ConexionException {
        Connection conn = ConexionDB.getConexion();
        try {
            Statement stmt = conn.createStatement();
            String query  = "CREATE TABLE IF NOT EXISTS clientes (" +
                    "idCliente INT NOT NULL," +
                    "nombre VARCHAR(45) NOT NULL," +
                    "correo VARCHAR(45) NOT NULL," +
                    "PRIMARY KEY (correo));";
            stmt.execute(query);
            stmt.close();
            conn.close();
            ConexionDB.closeConexion();
        } catch (SQLException e) {
            throw new ConexionTablaExcepcion();
        }

    }

    public static void insertarCliente(Cliente l) throws ConexionException {
        crearTablaCliente();
        Connection conn = ConexionDB.getConexion();
        try {

            String query  = "";
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO clientes VALUES (?, ?, ?)");
            stmt.setInt(1,l.id);
            stmt.setString(2, l.getNombre());
            stmt.setString(3, l.getCorreo());

            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new ClienteDuplicadoException();
        }
        catch (SQLException e) {
            throw new ConexionException();
        }

    }
}
