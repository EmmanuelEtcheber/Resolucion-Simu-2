package Modelo.Gestoras;

import Excepciones.ElementoDuplicadoException;
import Modelo.Cliente;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GestoraClientes implements GestoraGenerica<Cliente>{
    private Set<Cliente> clientes;

    public GestoraClientes() {
        clientes = new HashSet<>();
    }

    @Override
    public void agregar(Cliente elemento) throws ElementoDuplicadoException {

            if(clientes.contains(elemento))
            {
                throw new ElementoDuplicadoException();
            }
            else
            {
                clientes.add(elemento);
            }


    }

    @Override
    public Cliente eliminar(int id) {
        Cliente eliminado = obtener(id);
        clientes.remove(eliminado);
        return eliminado;
    }

    @Override
    public Cliente obtener(int id) {
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> obtenerConjunto() {
        return clientes;
    }

    @Override
    public String mostrarElementos() {
        StringBuilder res = new StringBuilder();
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            res.append(cliente.toString());
            res.append("\n");
        }
        return res.toString();
    }
}
