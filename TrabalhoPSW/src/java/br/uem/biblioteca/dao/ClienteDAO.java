package br.uem.biblioteca.dao;

import br.uem.biblioteca.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private List<Cliente> clientes;
    private static ClienteDAO instance;
    
     private ClienteDAO() {
        this.clientes = new ArrayList<>();
    }

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public void salvarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> BuscarClientes() {     //retorna todos os clientes
        return clientes;
    }    
    
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }    

    public static void setInstance(ClienteDAO instance) {
        ClienteDAO.instance = instance;
    }
    
    public void alterarCliente(int index, Cliente cliente){
        clientes.get(index).setCpf(cliente.getCpf());
        clientes.get(index).setNome(cliente.getNome());
        clientes.get(index).setEndereco(cliente.getEndereco());
        clientes.get(index).setIdade(cliente.getIdade());
    }

    public void RemoverCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
    
    public Cliente BuscaClientePorCpf(String cpf){
        Cliente clienteEncontrado = null;
        
        if(!clientes.isEmpty()){
            for(Cliente i : clientes){
                if(i.getCpf().equals(cpf)){
                    clienteEncontrado = i;
                    break;
                }
            }
        }
        return clienteEncontrado;
    }
}
