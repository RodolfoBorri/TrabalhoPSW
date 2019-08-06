package br.uem.biblioteca.bean;

import br.uem.biblioteca.controller.ClienteController;
import br.uem.biblioteca.model.Cliente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
    Cliente cliente = new Cliente();
    int indexCliente;

    private String nome;
    private int idade;
    private String cpf;
    private String endereco;
    
    public ClienteBean() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String cadastrar() {
        Cliente clienteEncontrado = ClienteController.BuscarClientePorCpf(cpf);
        
        if(clienteEncontrado != null){
            return "/HTML/clienteExistente";
        }
        else{
            ClienteController.salvarCliente(new Cliente(nome, idade, cpf, endereco));    
            return "/HTML/cadastroSucesso";
        }
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
     public String alterarCliente(Cliente cliente){
        this.cliente = cliente;
        
        List<Cliente> clientes;
        clientes = ClienteController.listarClientes();
        
        if(clientes.contains(cliente)) this.indexCliente = clientes.indexOf(cliente);
        return "alterarCliente";
    }
    
    public String salvarCliente(){
        Cliente clienteAlterado = new Cliente(cliente.getNome(), cliente.getIdade(), cliente.getCpf(), cliente.getEndereco());
        ClienteController.alterarCliente(indexCliente, clienteAlterado);
        return "/HTML/listarClientes";
    }
    
    public String cancelarAlterarCliente(){
        return "/HTML/listarClientes";
    }
    
    public String excluirCliente(Cliente cliente){
        if(!new EmprestimoBean().VerificarClientePossuiEmprestimo(cliente)){
            ClienteController.removerCliente(cliente);
            return "";
        }
        else return "/HTML/erro";
    }
    
    public List<Cliente> getClientes() {
        return ClienteController.listarClientes();
    }
}
