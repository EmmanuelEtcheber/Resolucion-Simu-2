package Excepciones;

public class ConexionFallidaException extends ConexionException {

    public ConexionFallidaException() {
        super("No fue posible conectar.");
    }
}
