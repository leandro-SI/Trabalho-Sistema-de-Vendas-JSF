/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Vendedor;
import persistencia.VendedorDAO;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "requisicaoLoginUsuario")
@RequestScoped
public class IDEscopoRequisicaoUsuario {
    
    @ManagedProperty(value="#{sessaoLoginUsuario}")
    private IDEscopoSessaoUsuario sessaoLoginUsuario;
    
    public int id;
    public String nome;
    public String usuario;
    public String senha;
    public  VendedorDAO vDAO = new VendedorDAO();
    
    public String logar() throws SQLException{
        
        String navegacao = "";
        Vendedor v = vDAO.consultarLogin(usuario, senha);
        
        if(v != null){
            sessaoLoginUsuario.setIdSessao(v.getIdVendedor());
            sessaoLoginUsuario.setNomeSessao(v.getNomeVendedor());
            sessaoLoginUsuario.setLoginSessao(v.getUsuarioVendedor());
            sessaoLoginUsuario.setSenhaSessao(v.getSenhaVendedor());
            sessaoLoginUsuario.setTempoSessao(new GregorianCalendar().getTime());
            navegacao = DAOBaseJDBC.SUCESSO_LOGIN;
        }else{
            navegacao = DAOBaseJDBC.FALHA_LOGIN;
            
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha no login...", "usuário não encontrado"));
        }
        
        return navegacao;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public VendedorDAO getvDAO() {
        return vDAO;
    }

    public void setvDAO(VendedorDAO vDAO) {
        this.vDAO = vDAO;
    }


    public IDEscopoRequisicaoUsuario() {
    }
   
    
    public String getLogin() {
        return usuario;
    }

    public void setLogin(String login) {
        this.usuario= login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public IDEscopoSessaoUsuario getSessaoLoginUsuario() {
        return sessaoLoginUsuario;
    }

    public void setSessaoLoginUsuario(IDEscopoSessaoUsuario sessaoLoginUsuario) {
        this.sessaoLoginUsuario = sessaoLoginUsuario;
    }
    
    
    
    
}
