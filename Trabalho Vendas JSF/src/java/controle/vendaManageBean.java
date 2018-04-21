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
import modelo.Categoria;
import modelo.Cliente;
import modelo.ItemVenda;
import modelo.Produto;
import persistencia.CategoriaDAO;
import persistencia.ClienteDAO;
import persistencia.ProdutoDAO;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "vendasManageBean")
@RequestScoped
public class vendaManageBean {
    
    private ClienteDAO cDAO = new ClienteDAO();
    private Cliente cliente = new Cliente();
    private List<Cliente> listaClienteManage;
    
    public ProdutoDAO pDAO = new ProdutoDAO();
    public Produto produto = new Produto();
    private List<Produto> listaProdutoManage;
    private CategoriaDAO catDAO = new CategoriaDAO();
    private Categoria categoria = new Categoria();
    private List<Categoria> listaCategoriasManage = null;
    
    private List<ItemVenda> itensVenda;
   
    // METODOS CLIENTE BEAN

   
    public String mensagemPositivaCadastro(){
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado", "."));
        return "cadastro-cliente-ok";
    }
    
    public String validaCliente(){
        

        if(cDAO.buscarClienteDAO(cliente.getCfp()) != null){
            cliente = cDAO.buscarClienteDAO(cliente.getCfp());
            return mensagemPositiva();
        }else{
            return mensagemNegativa();
        }

    }
    
    
    public String cadastrarClienteManage(){
        
        cDAO.cadastrarClienteDAO(cliente);
        cliente = null;
        return mensagemPositivaCadastro();
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
    
    ////////// FIM METODOS CLIENTE BEAN //////////////////////
    
    
    
    //////////// METODOS PRODUTO BEAN //////////////////////
    
    
    public String listarCategoriaManage(){
        
        listaCategoriasManage = catDAO.listarCategoriaDAO();

        return "cadastro-produto";
    }
    
    public String retornaIdCategoriaManage(String nome){
        
        produto.setIdCategoria(catDAO.retornaIdCategoria(nome));
        
        return "cadastro-produto-ok";
    }
    
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaDAO getcatDAO() {
        return catDAO;
    }

    public void setcDAO(CategoriaDAO cDAO) {
        this.catDAO = cDAO;
    }

    public List<Categoria> getListaCategoriasManage() {
        return listaCategoriasManage;
    }

    public void setListaCategoriasManage(List<Categoria> listaCategoriasManage) {
        this.listaCategoriasManage = listaCategoriasManage;
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
    
    
    ////////////////// FIM METODOS PRODUTO BEAN ////////////////////////
    
    
    
    
}
