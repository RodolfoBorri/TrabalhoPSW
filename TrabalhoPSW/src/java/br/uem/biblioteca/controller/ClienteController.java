package br.uem.biblioteca.controller;

import br.uem.biblioteca.dao.ClienteDAO;
import br.uem.biblioteca.model.Cliente;
import java.util.List;

public class ClienteController {

    public static void salvarCliente(Cliente cliente) {
        ClienteDAO.getInstance().salvarCliente(cliente);
    }

    public static List<Cliente> listarClientes() {      //buscar cliente
        return ClienteDAO.getInstance().BuscarClientes();
    }    
    
    public static void setClientes(List<Cliente> clientes) {
        ClienteDAO.getInstance().setClientes(clientes);
    }

    public static void alterarCliente(int index, Cliente cliente){
        ClienteDAO.getInstance().alterarCliente(index, cliente);
    }

    public static void removerCliente(Cliente cliente) {
        ClienteDAO.getInstance().RemoverCliente(cliente);
    }
    
    public static Cliente BuscarClientePorCpf(String cpf){
        return ClienteDAO.getInstance().BuscaClientePorCpf(cpf);
    }
}
