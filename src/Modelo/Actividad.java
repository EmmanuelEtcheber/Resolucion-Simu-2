package Modelo;

public class Actividad {
    private int id;
    private String descripcion;
    private int capacidadMaxima;
    private int cupoActual;
    private double costo;

    public Actividad(int id, String descripcion,int capacidadMaxima, int cupoActual, double costo) {
        this.id = id;
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.cupoActual = cupoActual;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupoActual() {
        return cupoActual;
    }

    public void setCupoActual(int cupoActual) {
        this.cupoActual = cupoActual;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean aumentarCupo() {
        if (cupoActual < capacidadMaxima) {
            cupoActual++;
            return true;
        } else return false;
    }
    public boolean disminuirCupo() {
        if (cupoActual > 0) {
            cupoActual--;
            return true;
        }
        return false;
    }
}
