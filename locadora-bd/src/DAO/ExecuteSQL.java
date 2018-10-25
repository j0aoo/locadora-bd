package DAO;

import java.sql.*;

public class ExecuteSQL {

    private Connection con;
    
    public ExecuteSQL(Connection con){
    
        setCon(con);
    
    }
    
    public Connection getcon(){
    
        return con;
    
    }

    private void setCon(Connection con) {

        this.con = con;
        
    }
    
}
