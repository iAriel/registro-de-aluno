/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import Model.Usuario;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class UsuarioDao {
    
    public void create(Usuario u) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuario (nome,curso) VALUES (?,?)");
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCurso());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }


    
}
