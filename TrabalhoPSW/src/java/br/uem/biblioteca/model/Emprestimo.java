package br.uem.biblioteca.model;

public class Emprestimo {
    private Cliente cliente;
    private Exemplar exemplar;
    private String dataEmprestimo;      
    private String dataRetorno;
    private String dataParaDevolucao;

    public String getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(String dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Emprestimo(Cliente cliente, Exemplar exemplar, String dataEmprestimo,  String dataDevolucao) {
        this.cliente = cliente;
        this.exemplar = exemplar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataParaDevolucao = dataDevolucao;
    }
    
    public Emprestimo(){ } 
}
