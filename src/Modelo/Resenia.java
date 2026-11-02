package Modelo;

public class Resenia {
    private int id;
    private int calificacion;
    private Actividad actividad;
    private String fecha;

    public Resenia(int id, int calificacion, Actividad actividad, String fecha) {
        this.id = id;
        this.calificacion = calificacion;
        this.actividad = actividad;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
