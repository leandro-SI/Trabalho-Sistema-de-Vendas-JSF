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
import modelo.Produto;
import persistencia.ProdutoDAO;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "produtoManageBean")
@RequestScoped
public class ProdutoManageBean{
    
    private ProdutoDAO pDAO = new ProdutoDAO();
    private Produto produto = new Produto();
    private List<Produto> listaProdutoManage;

    public ProdutoManageBean() {
    }

    public ProdutoDAO getpDAO() {
        return pDAO;
    }

    public void setpDAO(ProdutoDAO pDAO) {
        this.pDAO = pDAO;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProdutoManage() {
        return listaProdutoManage;
    }

    public void setListaProdutoManage(List<Produto> listaProdutoManage) {
        this.listaProdutoManage = listaProdutoManage;
    }
    
    public String mensagemNegativa(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Produto não encontrado", "."));
        return null;
    }
    
    public String mensagemPositiva(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto encontrado", "."));
        return "pdv";
    }
    
    public String validaProdutoDAO(){
        
        if(pDAO.buscarProdutoDAO(produto.getNomeProduto()) != null){
            
            produto = pDAO.buscarProdutoDAO(produto.getNomeProduto());
            return mensagemPositiva();
        }else{
            return mensagemNegativa();
        }
    }
    
}
