package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {
    public int id;
    private String nombre;
    private String correo;
    private List<Resenia> listaResenias;

    public Cliente(int id, String correo, String nombre) {
        this.id = id;
        this.correo = correo;
        this.nombre = nombre;
        listaResenias = new ArrayList<Resenia>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean ingresarResenia(Resenia resenia) {
        return listaResenias.add(resenia);
    }

    public String listarResenias()
    {
        StringBuilder s = new StringBuilder();
        for (Resenia resenia : listaResenias) {
            s.append(resenia.toString());
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(correo, cliente.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(correo);
    }
}
