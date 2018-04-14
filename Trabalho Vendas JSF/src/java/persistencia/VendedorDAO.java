/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Vendedor;
import tools.DAOBaseJDBC;

/**
 *
 * @author Leandro
 */
public class VendedorDAO extends DAOBaseJDBC{
    
    public Vendedor consultarLogin(String user, String pass) throws SQLException{
        
        Vendedor loginProcurado = null;
        
        String consulta = "SELECT * FROM vendedor WHERE usuario = ? AND senha = ?";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(consulta);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                loginProcurado = new Vendedor();
                
                loginProcurado.setIdVendedor(resultado.getInt("id"));
                loginProcurado.setNomeVendedor(resultado.getString("nome"));
                loginProcurado.setUsuarioVendedor(resultado.getString("usuario"));
                loginProcurado.setSenhaVendedor(resultado.getString(("senha")));
                stmt.close();
            }else{
                return null;
            }
            
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
        
        return loginProcurado;
    }
    
}
