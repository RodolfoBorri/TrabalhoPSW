package br.uem.biblioteca.bean;

import br.uem.biblioteca.controller.LivroController;
import br.uem.biblioteca.model.Exemplar;
import br.uem.biblioteca.model.Livro;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
@Named(value = "livroBean")
@SessionScoped
public class LivroBean implements Serializable {    
    Livro livro = new Livro();
    int indexLivro;
    
    private String titulo;
    private String autor;
    private String editora;
    private String anoPublicacao; 
    
    
    public LivroBean() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
    
    public String cadastrar() {
        Livro livroEncontrado = LivroController.BuscarLivroPorTitulo(titulo);
        
        if(livroEncontrado == null){
            Livro livroNovo = new Livro(titulo, autor, editora, anoPublicacao);
            LivroController.salvarLivro(livroNovo);
            LivroController.salvarExemplar(new Exemplar(livroNovo, false));
            return "/HTML/cadastroSucesso";
        }
        else{
            LivroController.salvarExemplar(new Exemplar(livroEncontrado, false));
            return "/HTML/cadastroExemplarSucesso";
        }
    }
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public String alterarLivro(Livro livro){
        this.livro = livro;
        
        List<Livro> livros;
        livros = LivroController.listarLivros();
        
        if(livros.contains(livro)) this.indexLivro = livros.indexOf(livro);
        
        return "alterarLivro";
    }
    
    public String salvarLivro(){
        Livro livroAlterado = new Livro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getAnoPublicacao());
        LivroController.alterarLivro(indexLivro, livroAlterado);
        return "/HTML/listarLivros";
    }
    
    public String cancelarAlterarLivro(){
        return "/HTML/listarLivros";
    }
    
    public boolean VerificarLivroPossuiEmprestimo(Livro livro){
        return LivroController.VerificarLivroPossuiEmprestimo(livro);
    }
    
    public String excluirLivro(Livro livro){     
        if(!VerificarLivroPossuiEmprestimo(livro)){
            LivroController.removerLivro(livro);
            return "";
        }
        else return "/HTML/erro";
    }
    
    public List<Livro> getLivros() {
        return LivroController.listarLivros();
    }
}
