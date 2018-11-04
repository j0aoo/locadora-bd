package DAO;

import Modelo.Cliente;
import Modelo.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO extends ExecuteSQL {
    
    public FilmeDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Filme(Filme a){
        
        try{
            
            String sql = "insert into filme values(0,?,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setString(1, a.getTitulo());
            ps.setInt(2, a.getAno());
            ps.setString(3, a.getDuracao());
            ps.setInt(4, a.getCod_categoria());
            ps.setInt(5, a.getCod_classificacao());
            ps.setString(6, a.getCapa());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso";
                
            } else {
                
                return "Erro ao inserir!";
                
            }
            
        }catch(SQLException e){
        
            return e.getMessage();
        
        }
        
    }
    
    public List<Filme> ListarFilme() {
    
        String sql = "select idfilme,titulo,ano,duracao,idcategoria,idclassificacao from filme";
        List<Filme> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    a.setTitulo(rs.getString(2));
                    a.setAno(rs.getInt(3));
                    a.setDuracao(rs.getString(4));
                    a.setCod_categoria(rs.getInt(5));
                    a.setCod_classificacao(rs.getInt(6));
                    
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
    
    public List<Filme> ConsultaCodigoCliente(String nome) {
        
        String sql = "select idfilme from filme where titulo = '"+ nome +"'";
        List<Filme> lista = new ArrayList<>();
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Filme a = new Filme();
                    a.setCodigo(rs.getInt(1));
                    lista.add(a);

                }
                
                return lista;
                
            } else {
                
                return null;
                
            }
            
        } catch (Exception e) {
            
            return null;
            
        }
        
    }
        
    
}
