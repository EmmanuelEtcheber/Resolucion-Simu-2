package Modelo.Gestoras;

import Excepciones.CupoLlenoException;
import Modelo.Actividad;
import Modelo.Cliente;
import Modelo.Resenia;
import Modelo.Reserva;

import java.util.List;

public class GestoraHotel {
    GestoraActividades gestoraActividades;
    GestoraClientes gestoraClientes;
    GestoraReserva gestoraReserva;

    public GestoraHotel() {
        gestoraActividades = new GestoraActividades();
        gestoraClientes = new GestoraClientes();
        gestoraReserva = new GestoraReserva();

    }

    public void agregarCliente(Cliente cliente) {
        gestoraClientes.agregar(cliente);
    }

    public void agregarActividad(Actividad actividad) {
        gestoraActividades.agregar(actividad);
    }

    public void agregarReserva(Reserva reserva) {
        gestoraReserva.agregar(reserva);
    }

    public void cargarActividadReserva(int idActividad, int idReserva) throws CupoLlenoException {
        Reserva buscada = gestoraReserva.obtener(idReserva);
        if (buscada != null) {
            Actividad actividad = gestoraActividades.obtener(idActividad);
            if (actividad != null) {
                if (!actividad.aumentarCupo())
                    throw new CupoLlenoException(actividad);
                buscada.getActividades().agregar(actividad);
            }
            //else
                //lanzar Excepcion actividad no existe
        }
        //else
            //lanzarExcepcion
    }

    public void cargarPaqueteReserva(String nombrePaquete, int idReserva) throws CupoLlenoException {
        Reserva buscada = gestoraReserva.obtener(idReserva);
        if (buscada != null) {
            List<Actividad> paquete = gestoraActividades.obtenerPaquete(nombrePaquete);
            if (!paquete.isEmpty()) {
                for (Actividad actividad : paquete) {
                    if (!actividad.aumentarCupo())
                        throw new CupoLlenoException(actividad);
                    buscada.getActividades().agregar(actividad);
                }
            }
            //else
            //lanzar Excepcion paquetevacio
        }
        //else
        //lanzarExcepcion
    }

    public void agregarResenia(Resenia nueva, int idCliente) {
        Cliente aux = gestoraClientes.obtener(idCliente);
        if (aux != null) {
            aux.ingresarResenia(nueva);
            nueva.getActividad().disminuirCupo();
        }
    }

}
