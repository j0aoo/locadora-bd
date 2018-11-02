package DAO;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO extends ExecuteSQL{

    public ClienteDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Cliente(Cliente a) {
        
        try{
            
            String sql = "insert into cliente values(0,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setString(1, a.getNome());
            ps.setString(2, a.getNascimento());
            ps.setString(3, a.getRG());
            ps.setString(4, a.getCPF());
            ps.setString(5, a.getEmail());
            ps.setString(6, a.getTelefone());
            ps.setString(7, a.getBairro());
            ps.setString(8, a.getRua());
            ps.setInt(9, a.getNumero());
            ps.setString(10, a.getCEP());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        }catch(SQLException e){
        
            return e.getMessage();
        
        }
        
    }
    
}
