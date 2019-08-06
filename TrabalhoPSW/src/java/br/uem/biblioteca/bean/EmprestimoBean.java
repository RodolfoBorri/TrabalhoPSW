package br.uem.biblioteca.bean;

import br.uem.biblioteca.controller.ClienteController;
import br.uem.biblioteca.controller.EmprestimoController;
import br.uem.biblioteca.controller.LivroController;
import br.uem.biblioteca.model.Cliente;
import br.uem.biblioteca.model.Emprestimo;
import br.uem.biblioteca.model.Exemplar;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
@Named(value = "emprestimoBean")
@SessionScoped
public class EmprestimoBean implements Serializable {

    private String cpf;
    private String exemplar;
    private Date dataEmprestimo;
    private String dataRetorno;
    private String dataParaDevolucao;
    
    public String EmprestarExemplar() {
        return "/HTML/cadastroEmprestimo";
    }
    
    public String DevolverExemplar() {
        return "/HTML/listarEmprestimos";
    }

    public String getDataParaDevolucao() {
        return dataParaDevolucao;
    }

    public void setDataParaDevolucao(String dataParaDevolucao) {
        this.dataParaDevolucao = dataParaDevolucao;
    }    

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public EmprestimoBean() {
    }

    public String getExemplar() {
        return exemplar;
    }

    public void setExemplar(String exemplar) {
        this.exemplar = exemplar;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
   
    public String cadastrar(){
        Cliente cliente = ClienteController.BuscarClientePorCpf(cpf);
        Exemplar exemplarEncontrado = LivroController.BuscarExemplarPorTituloDoLivro(exemplar);
        
        if(cliente == null || exemplarEncontrado == null){
            return "/HTML/erro"; 
        }
        else{
            if(dataParaDevolucao.isEmpty()){
                return "/HTML/erro"; 
            }
            else{                
                exemplarEncontrado.setEmprestado(true);
                EmprestimoController.salvarEmprestimo(new Emprestimo(cliente, exemplarEncontrado, new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()), dataParaDevolucao));
                return "/HTML/cadastroSucesso";
            }
        }
    }
    
    public boolean VerificarClientePossuiEmprestimo(Cliente cliente){
        return EmprestimoController.VerificarClientePossuiEmprestimo(cliente);
    }
    
    public List<Emprestimo> getEmprestimos(){
        return EmprestimoController.listarEmprestimos();
    }
    
    public void DevolverExemplar(Emprestimo emprestimo){
        LivroController.AlterarEmprestadoExemplar(emprestimo.getExemplar());
        EmprestimoController.DevolverExemplar(emprestimo);
    }
}
