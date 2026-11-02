package Modelo.Gestoras;

import java.util.Collection;

public interface GestoraGenerica <T> {
    void agregar(T elemento);
    T eliminar(int id);
    T obtener(int id);
    Collection<T> obtenerConjunto();
    String mostrarElementos();

}
