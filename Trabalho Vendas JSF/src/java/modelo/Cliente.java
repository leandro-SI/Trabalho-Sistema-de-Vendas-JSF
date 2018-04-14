/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leandro
 */
public class Cliente {
    
    private int idCliente;
    private String nomeClente;
    private String cfp;

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeClente() {
        return nomeClente;
    }

    public void setNomeClente(String nomeClente) {
        this.nomeClente = nomeClente;
    }

    public String getCfp() {
        return cfp;
    }

    public void setCfp(String cfp) {
        this.cfp = cfp;
    }
    
    
}
