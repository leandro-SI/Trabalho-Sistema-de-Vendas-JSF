/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Leandro
 */

@ManagedBean(name = "clienteManageBean")
@RequestScoped
public class ClienteManageBean {
    
    private ClienteDAO cDAO = new ClienteDAO();
    private Cliente cliente = new Cliente();
    private List<Cliente> listaClienteManage;
   
    

    public String mensagemNegativa(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado", "."));
        return null;
    }
    
    public String mensagemPositiva(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário encontrado", "."));
        return "pdv";
    }
    
    public String validaCliente(){
        

        if(cDAO.buscarClienteDAO(cliente.getCfp()) != null){

            cliente = cDAO.buscarClienteDAO(cliente.getCfp());
            return mensagemPositiva();
        }else{
            return mensagemNegativa();
        }
        
       // return clienteRetornado;
    }
    
    
    public ClienteManageBean() {
    }

    public ClienteDAO getcDAO() {
        return cDAO;
    }

    public void setcDAO(ClienteDAO cDAO) {
        this.cDAO = cDAO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClienteManage() {
        return listaClienteManage;
    }

    public void setListaClienteManage(List<Cliente> listaClienteManage) {
        this.listaClienteManage = listaClienteManage;
    }

    
    
    
}
