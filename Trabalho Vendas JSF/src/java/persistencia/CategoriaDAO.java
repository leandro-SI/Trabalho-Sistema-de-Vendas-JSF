/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class CategoriaDAO extends DAOBaseJDBC{
    
    public List<Categoria> listarCategoriaDAO(){
        
        Categoria categoriaProcurada = null;
        
        String consulta = "SELECT * FROM categoria";
        List<Categoria> categorias = new ArrayList<Categoria>();
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
                
                categoriaProcurada = new Categoria();
                categoriaProcurada.setIdCategoria(resultado.getInt("id"));
                categoriaProcurada.setNomeCategoria(resultado.getString("nome"));
                categorias.add(categoriaProcurada);
            }
            
        }catch(SQLException e){
            
        }
        
        for(Categoria c: categorias){
            System.out.println("NOme: " + c.getNomeCategoria());
        }
        
        return categorias;
    }
    
    public int retornaIdCategoria(String nome){
        
        Integer id = null;
        
        String consulta = "SELECT * FROM categoria WHERE nome = ?";
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                
               id = resultado.getInt("id");
               
               return id;
            }
            
        }catch(SQLException e){
            
        }
        
        return id;
    }
    
    
    
}
