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
import modelo.Produto;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ProdutoDAO extends DAOBaseJDBC{
    
    public List<Produto> listaProdutosDAO(){
        
        Produto produtoProcurado = null;
        String consulta = "SELECT * FROM produto";
        
        List<Produto> produtos = new ArrayList<Produto>();
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next()){
               produtoProcurado = new Produto();
               produtoProcurado.setIdProduto(resultado.getInt("id"));
               produtoProcurado.setIdCategoria(resultado.getInt("categoria_id"));
               produtoProcurado.setNomeProduto(resultado.getString("nome"));
               produtoProcurado.setQuantidadeProduto(resultado.getInt("quantidade"));
               produtoProcurado.setPreco(resultado.getDouble("preco"));
               produtos.add(produtoProcurado);
            }
        }catch(SQLException e){
            
        }
        return produtos;
    }
    
    public Produto buscarProdutoDAO(String nome){
        
        Produto produtoProcurado = null;
        String consulta = "SELECT * FROM produto WHERE name = ?";
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            stmt.setString(1, nome);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
               produtoProcurado = new Produto();
               produtoProcurado.setIdProduto(resultado.getInt("id"));
               produtoProcurado.setIdCategoria(resultado.getInt("categoria_id"));
               produtoProcurado.setNomeProduto(resultado.getString("nome"));
               produtoProcurado.setQuantidadeProduto(resultado.getInt("quantidade"));
               produtoProcurado.setPreco(resultado.getDouble("preco"));
                stmt.close();
            }else{
                return null;
                
            }
            
        }catch(SQLException e){
            
        }
        return produtoProcurado;
    }
    
}
