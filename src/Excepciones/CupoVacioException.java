package Excepciones;

public class CupoVacioException extends Exception {
    public CupoVacioException() {
        super("Error al disminuir el cupo. La actividad no tiene participantes registrados");
    }
}
