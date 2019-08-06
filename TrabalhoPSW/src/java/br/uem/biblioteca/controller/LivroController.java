package br.uem.biblioteca.controller;
 
import br.uem.biblioteca.dao.ExemplarDAO;
import br.uem.biblioteca.dao.LivroDAO;
import br.uem.biblioteca.model.Livro;
import br.uem.biblioteca.model.Exemplar;
import java.util.List;

public class LivroController {
   
    public static void salvarLivro(Livro livro) {
        LivroDAO.getInstance().CadastrarLivro(livro);
    }

    public static List<Livro> listarLivros() {
        return LivroDAO.getInstance().BuscarLivros();
    }
    
    public static void salvarExemplar(Exemplar exemplar) {
        ExemplarDAO.getInstance().CadastrarExemplar(exemplar);
    }

    public static List<Exemplar> listarExemplares() {
        return ExemplarDAO.getInstance().BuscarExemplares();
    }

    public static void setLivros(List<Livro> livros) {
        LivroDAO.getInstance().setLivros(livros);
    }
    
    public static void alterarLivro(int index, Livro livro){
        LivroDAO.getInstance().AlterarLivros(index,livro);
    }

    public static void removerLivro(Livro livro) {
        LivroDAO.getInstance().RemoverLivro(livro);
    }

    public static Livro BuscarLivroPorTitulo(String titulo) {
        return LivroDAO.getInstance().BuscaLivroPorTitulo(titulo);
    }
    
    public static Exemplar BuscarExemplarPorTituloDoLivro(String titulo){
        return ExemplarDAO.getInstance().BuscarExemplarPorTituloDoLivro(titulo);
    }
    
    public static boolean VerificarLivroPossuiEmprestimo(Livro livro){
        return ExemplarDAO.getInstance().VerificarLivroPossuiEmprestimo(livro);
    }
    
    public static void AlterarEmprestadoExemplar(Exemplar exemplar){
        ExemplarDAO.getInstance().AlterarEmprestadoExemplar(exemplar);
    }
    
}
