package Excepciones;

public class ConexionTablaExcepcion extends ConexionException {
    public ConexionTablaExcepcion() {
        super("Error al crear la tabla.");
    }
}
