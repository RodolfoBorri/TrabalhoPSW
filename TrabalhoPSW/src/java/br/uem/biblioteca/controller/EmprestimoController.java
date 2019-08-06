package br.uem.biblioteca.controller;

import br.uem.biblioteca.dao.EmprestimoDAO;
import br.uem.biblioteca.model.Cliente;
import br.uem.biblioteca.model.Emprestimo;
import java.util.List;

public class EmprestimoController {
    
    public static void salvarEmprestimo(Emprestimo emprestimo) {
        EmprestimoDAO.getInstance().CadastrarEmprestimo(emprestimo);
    }

    public static List<Emprestimo> listarEmprestimos() {
        return EmprestimoDAO.getInstance().BuscarEmprestimos();
    }
    
    public static boolean VerificarClientePossuiEmprestimo(Cliente cliente){
        return EmprestimoDAO.getInstance().VerificarClientePossuiEmprestimo(cliente);
    }

    public static void DevolverExemplar(Emprestimo emprestimo) {
        EmprestimoDAO.getInstance().DevolverExemplar(emprestimo);
    }
}
