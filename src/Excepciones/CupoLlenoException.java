package Excepciones;

import Modelo.Actividad;

public class CupoLlenoException extends Exception {
    public CupoLlenoException(Actividad actividad) {
        super("El cupo para "+ actividad.getDescripcion() +" fue alcanzado.");
    }
}
