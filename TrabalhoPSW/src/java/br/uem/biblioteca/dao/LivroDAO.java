package br.uem.biblioteca.dao;

import br.uem.biblioteca.model.Exemplar;
import br.uem.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    
    private List<Livro> livros;
    private static LivroDAO instance;
    
    private LivroDAO() {
        this.livros = new ArrayList<>();
    }
    
    public static LivroDAO getInstance() {
        if (instance == null) {
            instance = new LivroDAO();
        }
        return instance;
    }
    
    public static void setInstance(LivroDAO instance) {
        LivroDAO.instance = instance;
    }
    
    public void CadastrarLivro(Livro livro){
        this.livros.add(livro);
    }
    
    public List<Livro> BuscarLivros(){
        return livros;
    }
    
    public void AlterarLivros(int index, Livro livro){
        livros.get(index).setTitulo(livro.getTitulo());
        livros.get(index).setDiretor(livro.getDiretor());
        livros.get(index).setEditora(livro.getEditora());
        livros.get(index).setAnoPublicacao(livro.getAnoPublicacao());
    }
    
    public void RemoverLivro(Livro livro){
        livros.remove(livro);
    }
    
    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    
    public Livro BuscaLivroPorTitulo(String titulo){
        Livro livroEncontrado = null;
        
        if(!livros.isEmpty()){
            for(Livro i : livros){
                if(i.getTitulo().equals(titulo)){
                    livroEncontrado = i;
                    break;
                }
            }
        }
        return livroEncontrado;
    }
}
