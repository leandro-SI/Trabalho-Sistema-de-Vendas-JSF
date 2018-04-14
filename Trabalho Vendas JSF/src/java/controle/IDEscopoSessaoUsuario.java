/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Leandro
 */

@ManagedBean(name = "sessaoLoginUsuario")
@SessionScoped
public class IDEscopoSessaoUsuario {
    
    public int idSessao;
    public String nomeSessao;
    public String loginSessao;
    public String senhaSessao;
    public Date tempoSessao;

    public IDEscopoSessaoUsuario() {
    }

    
    
    
    
    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public String getNomeSessao() {
        return nomeSessao;
    }

    public void setNomeSessao(String nomeSessao) {
        this.nomeSessao = nomeSessao;
    }
    
    
    public String getLoginSessao() {
        return loginSessao;
    }

    public void setLoginSessao(String loginSessao) {
        this.loginSessao = loginSessao;
    }

    public String getSenhaSessao() {
        return senhaSessao;
    }

    public void setSenhaSessao(String senhaSessao) {
        this.senhaSessao = senhaSessao;
    }

    public Date getTempoSessao() {
        return tempoSessao;
    }

    public void setTempoSessao(Date tempoSessao) {
        this.tempoSessao = tempoSessao;
    }
    
    
}
