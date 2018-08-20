/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towapplication.git;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Colton Sells
 */
public class sqlUpdate {
    
    public static void databaseUpdate(String firstName, String lastName, String vehicleDescription,
            String currentLoc, String desiredLoc, String phoneNum, Statement stmnt) {
            String sql = "insert into customer" 
                    + " (firstName, lastName, vehicleDescription, pickupLoc, dropOffLoc, phoneNumber) "
                    + " values ('"+firstName+"', '"+lastName+
                    "', '"+vehicleDescription+"', '"+currentLoc+"', '"
                    +desiredLoc+"', '"+phoneNum+"')";
            
        try {
            stmnt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(sqlUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int loginCheck(String username, String password, Statement stmnt) {
        int value = 0;
        String query = "SELECT password FROM employees WHERE username='"+username+"'";
        try {
            ResultSet rs = stmnt.executeQuery(query);
            if (rs.next()){
                String passwordCheck = rs.getString("password");
                if (passwordCheck.equals(password)){
                    value = 1;
                }
              
           }
        } catch (SQLException ex) {
            Logger.getLogger(sqlUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }
    
    public static int retrieveId(String firstName, String lastName, String vehicleDescription,
            String currentLoc, String desiredLoc, String phoneNum, Statement stmnt){
        ResultSet result = null;
        int answer = 0;
        String retrieve = "SELECT id FROM customer WHERE firstName = '" + firstName +
                "' AND lastName = '" + lastName + "' AND vehicleDescription = '" + vehicleDescription +
                "' AND pickupLoc = '" + currentLoc + "' AND dropOffLoc = '" + desiredLoc +
                "' AND phoneNumber = '" + phoneNum + "'";
        
        try {
           result = stmnt.executeQuery(retrieve);
           result.next();
           answer = result.getInt("id");
        } catch (SQLException ex) {
            Logger.getLogger(sqlUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return answer;
    }
    
    
    public static void updateJobStatus(int idNumber, Connection con){
        String update = "UPDATE customer "
                + "SET jobComplete = ? "
                + "WHERE id = ?";
        
        try{
            PreparedStatement pstmnt = con.prepareStatement(update);
            pstmnt.setString(1, "YES");
            pstmnt.setInt(2, idNumber);
            pstmnt.executeUpdate();
        } catch (SQLException ex){
            Logger.getLogger(sqlUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
