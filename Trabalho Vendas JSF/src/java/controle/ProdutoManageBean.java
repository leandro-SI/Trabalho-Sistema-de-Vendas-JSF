/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Categoria;
import modelo.Produto;
import persistencia.CategoriaDAO;
import persistencia.ProdutoDAO;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "produtoManageBean")
@RequestScoped
public class ProdutoManageBean{
    
    public ProdutoDAO pDAO = new ProdutoDAO();
    public Produto produto = new Produto();
    private List<Produto> listaProdutoManage;
    private CategoriaDAO cDAO = new CategoriaDAO();
    private Categoria categoria = new Categoria();
    private List<Categoria> listaCategoriasManage = null;
  

     
    
    public String listarCategoriaManage(){
        
        listaCategoriasManage = cDAO.listarCategoriaDAO();

        return "cadastro-produto";
    }
    
    public String retornaIdCategoriaManage(String nome){
        
        produto.setIdCategoria(cDAO.retornaIdCategoria(nome));
        
        return "cadastro-produto-ok";
    }
    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO getcDAO() {
        return cDAO;
    }

    public void setcDAO(CategoriaDAO cDAO) {
        this.cDAO = cDAO;
    }

    public List<Categoria> getListaCategoriasManage() {
        return listaCategoriasManage;
    }

    public void setListaCategoriasManage(List<Categoria> listaCategoriasManage) {
        this.listaCategoriasManage = listaCategoriasManage;
    }
    
    
    

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
            System.out.println("Quantidade: " + produto.getQuantidadeProduto());
            System.out.println("Preco: " + produto.getPreco());
            return mensagemPositiva();
        }else{
            return mensagemNegativa();
        }
    }
    
    public String mensagemPositivaProduto(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto cadastrado", "."));
                produto = null;
        return "pdv";
    }
    
    
    public String cadastrarProdutManage(){
        
        
        
        pDAO.cadastrarProdutoDAO(produto);
        
        return mensagemPositivaProduto();
    }
    
   
    
}
