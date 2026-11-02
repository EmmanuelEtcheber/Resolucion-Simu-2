package Modelo.Gestoras;

import Excepciones.*;
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

    public void agregarCliente(Cliente cliente) throws ElementoDuplicadoException {
        gestoraClientes.agregar(cliente);
    }

    public void agregarActividad(Actividad actividad) throws ElementoDuplicadoException {
        gestoraActividades.agregar(actividad);
    }

    public void agregarReserva(Reserva reserva) {
        gestoraReserva.agregar(reserva);
    }

    public void cargarActividadReserva(int idActividad, int idReserva) throws CupoLlenoException, ElementoDuplicadoException, ActividadInexistenteException, ReservaInexistenteException {
        Reserva buscada = gestoraReserva.obtener(idReserva);
        if (buscada != null) {
            Actividad actividad = gestoraActividades.obtener(idActividad);
            if (actividad != null) {
                if (!actividad.aumentarCupo())
                    throw new CupoLlenoException(actividad);
                buscada.getActividades().agregar(actividad);
            }
            else {
                throw new ActividadInexistenteException(idActividad);
            }

        }
        else {
            throw new ReservaInexistenteException(idReserva);
        }
    }

    public void cargarPaqueteReserva(String nombrePaquete, int idReserva) throws CupoLlenoException, ElementoDuplicadoException, PaqueteVacioException, ReservaInexistenteException {
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
            else {
                throw new PaqueteVacioException(nombrePaquete);
            }

        } else
        {
            throw new ReservaInexistenteException(idReserva);
        }

    }

    public void agregarResenia(Resenia nueva, int idCliente) throws ClienteInexistenteException, ReseniaInexistenteException, CupoVacioException {
        Cliente aux = gestoraClientes.obtener(idCliente);
        if (aux != null) {
            if(nueva != null) {
                aux.ingresarResenia(nueva);
                if (nueva.getActividad().getCupoActual()>0)
                {
                nueva.getActividad().disminuirCupo();

                }
                else
                {
                    throw new CupoVacioException();
                }
            }
            else {
                throw new ReseniaInexistenteException();
            }

        }
        else {
            throw new ClienteInexistenteException(idCliente);
        }
    }

}
