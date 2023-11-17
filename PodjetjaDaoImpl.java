package Seminarska.superge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class PodjetjaDaoImpl implements PodjetjaDao {
    String dbURL = "jdbc:ucanaccess://C://Faks//TIS//Seminarska.superge.accdb";
    
    
    
    
     public ArrayList<Podjetja> getAllPodjetja() {
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
        ArrayList<Podjetja> podjetje = new ArrayList();
        try {
            String SQL_GET_ALL = "SELECT id, naziv FROM Podjetja ORDER BY id";
            conn = DriverManager.getConnection(dbURL);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SQL_GET_ALL);
            
            while(rs.next()) {
                podjetje.add(new Podjetja (rs.getInt("id"), rs.getString("naziv")));
            }
            rs.close();
            stmt.close();
            conn.close();
    

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return podjetje;
    }
    
     
    public Podjetja getPodjetjaById(int id) {
        
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        Podjetja podjetje = new Podjetja();
        
        try {
            String SQL_GET_BY_ID = "SELECT id, naziv FROM Podjetja WHERE id=?";
            conn = DriverManager.getConnection(dbURL);
            pstmt = conn.prepareStatement(SQL_GET_BY_ID);
            pstmt.setInt(1, id);
            
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                podjetje.setId(id);
                podjetje.setNaziv(rs.getString("naziv"));

            } else {
                System.out.println("Ta podjetje ne obstaja!");
            }

            pstmt.close();
            conn.close();
    

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return podjetje;
    }
}
