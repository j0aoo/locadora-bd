package DAO;

import Modelo.DVD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<DVD> ListarDVD() {
    
        String sql = "select iddvd,idfilme,preco_compra,data_compra,situacao,capa from dvd";
        List<DVD> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    DVD a = new DVD();
                    a.setCodigo(rs.getInt(1));
                    a.setCod_filme(rs.getInt(2));
                    a.setPreco(rs.getDouble(3));
                    a.setData_compra(rs.getString(4));
                    a.setSituacao(rs.getString(5));
                
                    Lista.add(a);
                    
                }
                
                return Lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (SQLException e) {
            
            return null;
            
        }
        
    }
    
}
