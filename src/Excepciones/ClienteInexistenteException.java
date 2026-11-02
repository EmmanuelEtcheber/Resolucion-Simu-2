package Excepciones;

public class ClienteInexistenteException extends Exception {
  public ClienteInexistenteException(int idCliente) {
    super("El cliente con el id: "+ idCliente+" no existe.");
  }
}
