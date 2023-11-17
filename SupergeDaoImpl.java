package Seminarska.superge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SupergeDaoImpl implements SupergeDao {
    String dbURL = "jdbc:ucanaccess://C://Faks//TIS//Seminarska.superge.accdb";
    Superge sup;
    
    
  
    
    public ArrayList<Superge> getAllSuperge() {
        Statement stmt;
        Connection conn;
        ResultSet rs;

        ArrayList<Superge> superge = new ArrayList();
        try {
            conn = DriverManager.getConnection(dbURL);

            stmt = conn.createStatement();
            String sql = "SELECT * FROM Superge";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                String sport = rs.getString("sport");
                int velikost = rs.getInt("velikost");
                int cena = rs.getInt("cena");
                int leto = rs.getInt("leto");
                int idPodjetja = rs.getInt("idPodjetja");
                superge.add(new Superge(id, model, sport, velikost, cena, leto, idPodjetja));
            }

            //------------------------------------- Close ---------------------------------------------------------------------------------------
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return superge;
    }
    
    @Override
    public ArrayList<Superge> getAllByIDPodjetja(int idPodjetja) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        ArrayList<Superge> superge = new ArrayList();
        
        try {
            conn = DriverManager.getConnection(dbURL);
            pstmt = conn.prepareStatement("SELECT * FROM Superge WHERE idPodjetja = ?");
            pstmt.setInt(1, idPodjetja);
            
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String model = rs.getString("model");
                String sport = rs.getString("sport");
                int velikost = rs.getInt("velikost");
                int cena = rs.getInt("cena");
                int leto = rs.getInt("leto");
                superge.add(new Superge(id, model, sport, velikost, cena, leto, idPodjetja));
            }

            //------------------------------------- Close ---------------------------------------------------------------------------------------
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return superge;
    }
    
    @Override
    public Superge getSupergeById(int id){
        
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        Superge superge = new Superge();
        
        try {
            conn = DriverManager.getConnection(dbURL);
            pstmt = conn.prepareStatement("SELECT * FROM Superge WHERE id=?");
            pstmt.setInt(1, id);
            
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                superge.setId(rs.getInt("id"));
                superge.setModel(rs.getString("model"));
                superge.setSport(rs.getString("sport"));
                superge.setVelikost(rs.getInt("velikost"));
                superge.setCena(rs.getInt("cena"));
                superge.setLeto(rs.getInt("leto"));
                superge.setIdPodjetja(rs.getInt("idPodjetja"));

            } else {
                System.out.println("Ta superga ne obstaja!");
            }

            pstmt.close();
            conn.close();
    

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return superge;
    }
    
    @Override
   public void insertSuperge(Superge sup) {

        Connection conn;
        PreparedStatement pstmt;

        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "INSERT INTO Superge(model, sport, velikost, cena, leto, idPodjetja) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sup.getModel());
            pstmt.setString(2, sup.getSport());
            pstmt.setInt(3, sup.getVelikost());
            pstmt.setInt(4, sup.getCena());
            pstmt.setInt(5, sup.getLeto());
            pstmt.setInt(6, sup.getIdPodjetja());
            int rows = pstmt.executeUpdate();
            System.out.println("Število spremenjenih vrstic: " + rows);
            

            //------------------------------------- Close ---------------------------------------------------------------------------------------
            pstmt.close();
            conn.close();
            System.out.println("Superga dodana.");

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public void updateSuperge(Superge sup) {
        PreparedStatement pstmt;
        Connection conn;

        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "UPDATE Superge SET model = ?, sport = ?, velikost = ?, cena = ?, leto = ?, idPodjetja = ?  WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sup.getModel());
            pstmt.setString(2, sup.getSport());
            pstmt.setInt(3, sup.getVelikost());
            pstmt.setInt(4, sup.getCena());
            pstmt.setInt(5, sup.getLeto());
            pstmt.setInt(6, sup.getIdPodjetja());
            pstmt.setInt(7, sup.getId());
            
            int rows = pstmt.executeUpdate();
            System.out.println("Število spremenjenih vrstic: " + rows);

            //------------------------------------- Close ---------------------------------------------------------------------------------------
            pstmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    
    public void deleteSuperge(int id) {
        PreparedStatement pstmt;
        Connection conn;

        try {
            conn = DriverManager.getConnection(dbURL);
            String sql = "DELETE FROM Superge WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();

            if (rows != 1) {
                System.out.println("Ta superga ne obstaja!");
            } else {
                System.out.println("Superga izbrisana.");
            }

            //------------------------------------- Close ---------------------------------------------------------------------------------------
            pstmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    

}
