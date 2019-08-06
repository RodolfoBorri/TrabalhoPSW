package br.uem.biblioteca.model;

public class Livro {
    private String titulo;
    private String diretor;
    private String editora;
    private String anoPublicacao;    

    public Livro(String titulo, String diretor, String editora, String anoPublicacao) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    
}
