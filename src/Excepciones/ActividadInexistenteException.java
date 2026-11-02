package Excepciones;

public class ActividadInexistenteException extends Exception {
    public ActividadInexistenteException(int idActividad) {
        super("La actividad con el id "+ idActividad +" no existe");
    }
}
