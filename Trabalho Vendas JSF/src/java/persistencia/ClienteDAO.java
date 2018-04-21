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
import modelo.Cliente;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class ClienteDAO extends DAOBaseJDBC {
    
    public List<Cliente> listaClientesDAO(){
        
        Cliente clienteProcurado = null;
        String consulta = "SELECT * FROM cliente";
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            ResultSet resultado = stmt.executeQuery();
            while(resultado.next()){
                
                clienteProcurado = new Cliente();
                clienteProcurado.setIdCliente(resultado.getInt("id"));
                clienteProcurado.setNomeClente(resultado.getString("nome"));
                clienteProcurado.setCfp(resultado.getString("cpf"));
                clientes.add(clienteProcurado);
            }
            
            
        }catch(SQLException e){
            System.out.println("Erro ao listar Clientes: " + e.getMessage());
        }
        
        return clientes;
    }
    
    
    public Cliente buscarClienteDAO(String cpf){
        
        Cliente clienteProcurado = null;
        
        String consulta = "SELECT * FROM cliente WHERE cpf = ?";
        
        PreparedStatement stmt;
        
        try{
            stmt = conn.prepareStatement(consulta);
            stmt.setString(1, cpf);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                clienteProcurado = new Cliente();
                clienteProcurado.setIdCliente(resultado.getInt("id"));
                clienteProcurado.setNomeClente(resultado.getString("nome"));
                clienteProcurado.setCfp(resultado.getString("cpf"));
                stmt.close();
                System.out.println("Procura cliente SQL");
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println("Erro procurar cliente: " + e.getMessage());
        }
        
        return clienteProcurado;
    }
    
    public void cadastrarClienteDAO(Cliente cliente){
        
        String consulta = "INSERT INTO cliente(nome, cpf) VALUES(?, ?)";
        
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, cliente.getNomeClente());
            stmt.setString(2, cliente.getCfp());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Cadastro feito com sucesso");
        }catch(SQLException e){
            System.out.println("Erro ao cadastrar" + e.getMessage());
        }
    }
    
}
