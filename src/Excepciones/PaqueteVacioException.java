package Excepciones;

public class PaqueteVacioException extends Exception {
    public PaqueteVacioException(String nombrePaquete) {
        super("el paquete con el nombre: "+ nombrePaquete+" no posee ninguna actividad");
    }
}
