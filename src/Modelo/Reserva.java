package Modelo;

import Modelo.Gestoras.GestoraActividades;

public class Reserva{
    private int id;
    private String fecha;
    private Cliente cliente;
    private GestoraActividades actividades;

    public Reserva(int id, String fecha) {
        this.id = id;
        this.fecha = fecha;
        this.actividades = new GestoraActividades();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public GestoraActividades getActividades() {
        return actividades;
    }

    public void setActividades(GestoraActividades actividades) {
        this.actividades = actividades;
    }
}
