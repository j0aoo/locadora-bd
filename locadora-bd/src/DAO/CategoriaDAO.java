package DAO;

import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoriaDAO extends ExecuteSQL {
    
    public CategoriaDAO(Connection con) {
        super(con);
    }

    public String Inserir_Categoria(Categoria a) {

        try {
        
            String sql = "insert into categoria values(0,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            ps.setString(1, a.getNome());
            
            if (ps.executeUpdate()> 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
