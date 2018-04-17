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
        String consulta = "SELECT * FROM produto WHERE nome = ?";
        
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
    
    public void cadastrarProdutoDAO(Produto produto){
        
        String consulta = "INSERT INTO produto(categoria_id, nome, quantidade, preco) "
                + "VALUES(?, ?, ?, ?)";
        
        try{
            
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setInt(1, produto.getIdCategoria());
            stmt.setString(2, produto.getNomeProduto());
            stmt.setInt(3, produto.getQuantidadeProduto());
            stmt.setDouble(4, produto.getPreco());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Produto Cadastrado");
        }catch(SQLException e){
            System.out.println("Erro cadastro de produto: " + e.getMessage());
        }
    }
    
}
