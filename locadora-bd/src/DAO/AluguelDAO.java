package DAO;

import Modelo.*;
import DAO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AluguelDAO extends ExecuteSQL{
    
    public AluguelDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Aluguel(Aluguel a) {
        
        try {
            
            String sql = "insert into aluguel values(0,?,?,?,?,?)";
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            ps.setInt(1, a.getCoddvd());
            ps.setDouble(2, a.getCodcliente());
            ps.setString(3, a.getHorario());
            ps.setString(4, a.getData_aluguel());
            ps.setString(5, a.getData_devolucao());
            
            if (ps.executeUpdate() > 0) {
                
                return "Inserido com sucesso!";
                
            } else {
                
                return "Erro ao inserir";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }

  
    
    public String Atualizar_Situacao(int cod, String situacao) {
        
        String sql = "update dvd set situacao = '"+ situacao +"' where iddvd = "+ cod +" ";
        
        try {
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            
            if (ps.executeUpdate() > 0) {
                
                return "Atualizado com sucesso!";
                
            } else {
                
                return "Erro ao Atualizar!";
                
            }
            
        } catch (SQLException e) {
            
            return e.getMessage();
            
        }
        
    }

    public List<Aluguel> ListarAluguel() {
    
        String sql = "select * from aluguel";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public List<Aluguel> PesquisarCodAluguel(int cod) {
    
        String sql = "select * from aluguel where idaluguel = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public List<Aluguel> PesquisarCodCliente(int cod) {
    
        String sql = "select * from aluguel where idcliente = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
    
    public List<Aluguel> PesquisarCodDVD(int cod) {
    
        String sql = "select * from aluguel where iddvd = "+ cod +"";
        List<Aluguel> Lista = new ArrayList<>();
           
        try {

            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if (rs != null) {
                
                while (rs.next()) {
                    
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
                
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
 
    public  List<Cliente> ConsultaTable(String nome){
  
        String sql = "select idcliente from cliente where nome = '"+ nome +"'";
        List<Cliente> lista = new ArrayList();    
        
        try {
        
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs!=null){
                
                while(rs.next()){
         
                    Cliente c = new Cliente();
                    c.setCodigo(rs.getInt(1));
                    lista.add(c);
                
                }
                
                return lista;
           
            } else {
                
                return null;
        
            }
        
        } catch (Exception e) {
        
            return null;
        
        }

    }
    
    public List<Aluguel> AtualizaAluguel(int cod){
        
        String sql = "select * from aluguel where idcliente = '"+ cod +"'";
        List<Aluguel> lista = new ArrayList<>();
        
        try{   
            
            PreparedStatement ps = getcon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
      
            if(rs!=null){
            
                while(rs.next()){
                
                    Aluguel a = new Aluguel();
                    a.setCod(rs.getInt(1));
                    a.setCoddvd(rs.getInt(2));
                    a.setCodcliente(rs.getInt(3));
                    a.setHorario(rs.getString(4));
                    a.setData_aluguel(rs.getString(5));
                    a.setData_devolucao(rs.getString(6));
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
