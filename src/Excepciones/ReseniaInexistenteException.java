package Excepciones;

public class ReseniaInexistenteException extends Exception {
    public ReseniaInexistenteException() {
        super("La resenia que intenta cargar no existe");
    }
}
