package Excepciones;

public class ConexionException extends Exception {
    public ConexionException() {
        super("Error con la base de datos.");
    }
    public ConexionException(String mensaje) {
        super("Error con la base de datos: " + mensaje);
    }
}
