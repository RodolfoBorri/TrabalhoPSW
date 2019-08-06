
package br.uem.biblioteca.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Rodolfo
 */
@Named(value = "gerenciadorCadastroBean")
@SessionScoped
public class GerenciadorCadastroBean implements Serializable {

    /**
     * Creates a new instance of GerenciadorCadastro
     */
    public GerenciadorCadastroBean() { }
    
    public String cadastrarCliente() {
        return "/HTML/cadastroCliente";
    }
    
    public String cadastrarLivro() {
        return "/HTML/cadastroLivro";
    }
    
    public String emprestarLivro() {
        return "/HTML/cadastroEmprestimo";
    }
}
