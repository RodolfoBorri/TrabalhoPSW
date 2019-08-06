/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.biblioteca.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Rodolfo
 */
@Named(value = "gerenciadorBuscaBean")
@SessionScoped
public class GerenciadorBuscaBean implements Serializable {

    /**
     * Creates a new instance of BuscaBean
     */
    public GerenciadorBuscaBean() {
    }
    
    public String buscaCliente(){
        return "/HTML/listarClientes";
    }
    
    public String buscaLivro(){
        return "/HTML/listarLivros";
    }
    
    public String listarClientes(){
        return "/HTML/listarClientes";
    }
    
    public String listarLivros(){
        return "/HTML/listarLivros";
    }   
}
