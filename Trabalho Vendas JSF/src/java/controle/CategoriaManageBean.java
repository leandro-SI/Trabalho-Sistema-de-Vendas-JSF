/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Categoria;
import persistencia.CategoriaDAO;

/**
 *
 * @author Leandro
 */
@ManagedBean(name = "categoriaManageBean")
@RequestScoped
public class CategoriaManageBean {
    
    private CategoriaDAO cDAO = new CategoriaDAO();
    private Categoria categoria = new Categoria();
    private List<Categoria> listaCategoriasManage = null;

    
    public String listarCategoriaManage(){
        
        listaCategoriasManage = cDAO.listarCategoriaDAO();

        return "cadastro-produto-ok";
    }
    
    
    public CategoriaManageBean() {
    }

    public CategoriaDAO getcDAO() {
        return cDAO;
    }

    public void setcDAO(CategoriaDAO cDAO) {
        this.cDAO = cDAO;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategoriasManage() {
        return listaCategoriasManage;
    }

    public void setListaCategoriasManage(List<Categoria> listaCategoriasManage) {
        this.listaCategoriasManage = listaCategoriasManage;
    }
    
    
    
    
}
