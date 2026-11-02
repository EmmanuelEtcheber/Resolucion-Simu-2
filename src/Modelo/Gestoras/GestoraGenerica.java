package Modelo.Gestoras;

import Excepciones.ElementoDuplicadoException;

import java.util.Collection;

public interface GestoraGenerica <T> {
    void agregar(T elemento) throws ElementoDuplicadoException;
    T eliminar(int id);
    T obtener(int id);
    Collection<T> obtenerConjunto();
    String mostrarElementos();

}
