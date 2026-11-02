package Excepciones;

public class ClienteDuplicadoException extends ConexionException {
    public ClienteDuplicadoException() {
        super("Ya existe un cliente con ese mail.");
    }
}
