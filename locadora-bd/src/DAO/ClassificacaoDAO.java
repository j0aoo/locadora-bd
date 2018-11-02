package DAO;

import Modelo.Classificacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassificacaoDAO extends ExecuteSQL {
    
    public ClassificacaoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Classificacao(Classificacao a) {
        
        try {
           
            String sql = "insert into classificacao values(0,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);

            ps.setString(1, a.getNome());
            ps.setDouble(2, a.getPreco());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }
    
}
