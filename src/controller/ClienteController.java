package controller;

import domain.Cliente;
import java.util.LinkedList;

public class ClienteController {

    public void listarClientes(Cliente[] clientes) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println(" Cliente: " + (i + 1) + " --> " + clientes[i].toString());
            }
        }
    }

    public void AddListaEspera(LinkedList<Cliente> filaDeEspera, Cliente[] clientes){
        if (filaDeEspera.size() < 4) {
            for (int i = 0; i < 4; i++) {
                filaDeEspera.add(clientes[i]);

            }
        }

    }
}