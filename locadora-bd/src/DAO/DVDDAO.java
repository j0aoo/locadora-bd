package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DVDDAO extends ExecuteSQL {
    
    public DVDDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_DVD(DVD a) {
        
        try {
            
            String sql = "insert into dvd values(0,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setInt(1, a.getCod_filme());
            ps.setDouble(2, a.getPreco());
            ps.setString(3, a.getData_compra());
            ps.setString(4, a.getSituacao());
            ps.setString(5, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
