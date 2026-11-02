package Excepciones;

public class ReservaInexistenteException extends Exception {
    public ReservaInexistenteException(int idReserva) {
        super("La reserva con id: "+ idReserva + " no existe.");
    }
}
