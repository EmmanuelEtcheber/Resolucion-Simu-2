package Modelo.Gestoras;

import Modelo.Reserva;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GestoraReserva implements GestoraGenerica<Reserva>{
    private List<Reserva> reservas;

    public GestoraReserva() {
        this.reservas = new ArrayList<Reserva>();
    }

    @Override
    public void agregar(Reserva elemento) {
        this.reservas.add(elemento);
    }

    @Override
    public Reserva eliminar(int id) {
        return reservas.remove(id);
    }

    @Override
    public Reserva obtener(int id) {
        return reservas.get(id);
    }

    @Override
    public Collection<Reserva> obtenerConjunto() {
        return reservas;
    }

    @Override
    public String mostrarElementos() {
        StringBuilder res = new StringBuilder();
        for (Reserva reserva : reservas) {
            res.append(reserva.toString());
            res.append("\n");
        }
        return res.toString();
    }
}
