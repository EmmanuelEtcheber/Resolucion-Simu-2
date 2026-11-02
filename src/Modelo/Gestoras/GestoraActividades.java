package Modelo.Gestoras;

import Excepciones.PaqueteInexistenteException;
import Modelo.Actividad;

import java.util.*;

public class GestoraActividades implements GestoraGenerica<Actividad> {
    public Map<Integer,Actividad> actividades;
    public Map<String, List<Actividad>> paquetesActividades;

    public GestoraActividades() {
        this.actividades = new HashMap<>();
        this.paquetesActividades = new HashMap<>();
    }

    @Override
    public void agregar(Actividad elemento) {
        actividades.put(elemento.getId(),elemento);
    }

    @Override
    public Actividad eliminar(int id) {
        return actividades.remove(id);
    }

    @Override
    public Actividad obtener(int id) {
        return  actividades.get(id);
    }

    public List<Actividad> obtenerPaquete(String nombrePaquete) {
        return  paquetesActividades.get(nombrePaquete);
    }

    @Override
    public Collection<Actividad> obtenerConjunto() {
        return actividades.values();
    }

    public String mostrarUnPaquete(String nombrePaquete) {
        StringBuilder sb = new StringBuilder();


        sb.append(nombrePaquete).append("\n");
        for (Actividad actividad : paquetesActividades.get(nombrePaquete)) {
            sb.append(actividad);
        }
        return sb.toString();
    }

    public String mostrarActividadesIndividuales()  {
        StringBuilder sb = new StringBuilder();

        sb.append("Actividades individuales:\n");
        for (Actividad actividad : actividades.values()) {
            sb.append(actividad);
        }
        return sb.toString();
    }

    @Override
    public String mostrarElementos() {
        StringBuilder res = new StringBuilder();
        res.append(mostrarActividadesIndividuales()).append("\n");
        for (String nombrePaquete : paquetesActividades.keySet()) {
            res.append(mostrarUnPaquete(nombrePaquete)).append("\n");
        }
        return res.toString();
    }
}
