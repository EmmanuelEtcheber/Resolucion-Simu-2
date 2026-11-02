package Excepciones;

public class ElementoDuplicadoException extends Exception {
    public ElementoDuplicadoException() {
        super("el elemento ya fue agregado");
    }
}
