package Excepciones;

public class PaqueteInexistenteException extends Exception {
    public PaqueteInexistenteException() {
        super("Ese paquete no existe.");
    }
}
