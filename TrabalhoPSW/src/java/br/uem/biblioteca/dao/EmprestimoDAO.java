package br.uem.biblioteca.dao;

import br.uem.biblioteca.model.Cliente;
import br.uem.biblioteca.model.Emprestimo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EmprestimoDAO {
    private List<Emprestimo> emprestimos;
    private static EmprestimoDAO instance;
    
    private EmprestimoDAO() {
        this.emprestimos = new ArrayList<>();
    }
    
    public static EmprestimoDAO getInstance() {
        if (instance == null) {
            instance = new EmprestimoDAO();
        }
        return instance;
    }
    
    public void CadastrarEmprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }
    
    public List<Emprestimo> BuscarEmprestimos() {
        return emprestimos;
    }
    
    public boolean VerificarClientePossuiEmprestimo(Cliente cliente){
        for(Emprestimo i : emprestimos){
            if(i.getCliente().equals(cliente)){
                if(i.getDataRetorno() == null){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void DevolverExemplar(Emprestimo emprestimo) {
        for(Emprestimo i : emprestimos){
            if(i.equals(emprestimo))
                i.setDataRetorno(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));
        }
    }
}
