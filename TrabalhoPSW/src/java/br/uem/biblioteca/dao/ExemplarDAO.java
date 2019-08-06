package br.uem.biblioteca.dao;

import br.uem.biblioteca.model.Exemplar;
import br.uem.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExemplarDAO {
    private List<Exemplar> exemplares;
    private static ExemplarDAO instance;
    
    private ExemplarDAO() {
        this.exemplares = new ArrayList<>();
    }
    
    public static ExemplarDAO getInstance() {
        if (instance == null) {
            instance = new ExemplarDAO();
        }
        return instance;
    }
    
     public void CadastrarExemplar(Exemplar exemplar){
        Random rdm = new Random();
        int valor = rdm.nextInt(10000);
        exemplar.setId(valor);
        this.exemplares.add(exemplar);
    }
    
    public List<Exemplar> BuscarExemplares() {
        return exemplares;
    }
    
    public boolean VerificarLivroPossuiEmprestimo(Livro livro){
        for(Exemplar i : exemplares){
            if(i.getLivro().equals(livro)){
                if(i.isEmprestado()) return true;
            }
        }
        return false;
    }
    
    public Exemplar BuscarExemplarPorTituloDoLivro(String titulo) {
        for(Exemplar i : ExemplarDAO.getInstance().BuscarExemplares()){
            if(i.getLivro().getTitulo().equals(titulo) && !i.isEmprestado()){
                return i;
            }
        }
        return null;
    }
    
    public void AlterarEmprestadoExemplar(Exemplar exemplar){
        for(Exemplar i : exemplares){
            if(i.equals(exemplar)){
                i.setEmprestado(false);                
            }
        }
    }
}
