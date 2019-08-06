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
@Named(value = "homeBean")
@SessionScoped
public class HomeBean implements Serializable {

    /**
     * Creates a new instance of HomeBean
     */
    public HomeBean() {
    }
    
    public String Home() {
        return "index";
    }
    
    public String Cadastro() {
        return "/HTML/cadastro";
    }
    
    public String Locacao() {
        return "/HTML/locacao";
    }
    
    public String Busca() {
        return "/HTML/busca";
    }
    
}
