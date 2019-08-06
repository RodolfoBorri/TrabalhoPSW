package br.uem.biblioteca.model;

public class Exemplar {
    private int id;
    private Livro livro;
    private boolean emprestado;

    public Exemplar(Livro livro, boolean emprestado) {
        this.livro = livro;
        this.emprestado = emprestado;
    }

    public Exemplar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    
    
}
