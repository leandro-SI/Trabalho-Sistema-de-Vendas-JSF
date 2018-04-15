/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Leandro
 */

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean {
    
    private ClienteDAO cDAO = new ClienteDAO();
    private Cliente cliente = new Cliente();
    private List<Cliente> listaClientesManage = null;

    public List<Cliente> listarClientesManage(){
        listaClientesManage = cDAO.listaClientesDAO();
        
        
        return listaClientesManage;
    }
    
    
    
    public UserBean() {
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

    public List<Cliente> getListaClientesManage() {
        return listaClientesManage;
    }

    public void setListaClientesManage(List<Cliente> listaClientesManage) {
        this.listaClientesManage = listaClientesManage;
    }
    
    
    
    
    
}
