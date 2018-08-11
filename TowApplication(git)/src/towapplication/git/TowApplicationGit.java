/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towapplication.git;

/**
 *
 * @author Colton Sells
 */
import java.awt.Component;
import java.util.Scanner;
import javax.swing.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import javax.activation.*;
import towapplication.git.ui;
import towapplication.git.sqlUpdate;
import towapplication.git.employee;
//test line


public class TowApplicationGit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        try {
            //Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/towapplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "blackbelt1");
            //Create a statement
            Statement myStmt = myConn.createStatement();
            Statement loginStmt = myConn.createStatement();
            
            JTextField firstName = new JTextField(10);
            JTextField lastName = new JTextField(10);
            JTextField vehicleDesc = new JTextField(10);
            JTextField currentLoc = new JTextField(10);
            JTextField desiredLoc = new JTextField(10);
            JTextField phoneNum = new JTextField(10);
            JPanel myPanel = new JPanel();
            
            JTextField userName = new JTextField(10);
            JTextField passWord = new JTextField(10);
            JPanel employeePanel = new JPanel();
       
            String sfirstName = "";
            String slastName = "";
            String svehicleDescription = "";
            String scurrentLocation = "";
            String sdesiredLocation = "";
            String sphoneNumber = "";
        
        
            Customer_copy Cust = new Customer_copy(sfirstName, slastName, 
                svehicleDescription, scurrentLocation, sdesiredLocation, sphoneNumber);
            
            //Test distance
            Cust.distance = 100;
       
            //Applies JText boxes to a Jpanel for UI
            ui.createUI(firstName, lastName, vehicleDesc, currentLoc, desiredLoc, 
                phoneNum, myPanel);
            
            //Stores customer inputs into Customer class variables
           /* int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please enter the information below", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Cust.firstName = firstName.getText();
                Cust.lastName = lastName.getText();
                Cust.vehicleDescription = vehicleDesc.getText();
                Cust.currentLocation = currentLoc.getText();
                Cust.desiredLocation = desiredLoc.getText();
                Cust.phoneNumber = phoneNum.getText();
      
                //Calculates fare
                Cust.fare = Cust.distance * 5;
      
                //Prompts fare amount and request confirmation for order
                JPanel orderConfirm = new JPanel();
                ui.confirmationPrompt(orderConfirm, Cust.firstName, Cust.lastName,
                        Cust.vehicleDescription, Cust.currentLocation, Cust.desiredLocation, 
                        Cust.fare);
               
                int result2 = JOptionPane.showConfirmDialog(null, orderConfirm,
                "Order Confirmation", JOptionPane.OK_CANCEL_OPTION);
      
                if (result2 == JOptionPane.OK_OPTION) {

                    sqlUpdate.databaseUpdate(Cust.firstName, Cust.lastName, Cust.vehicleDescription,
                    Cust.currentLocation, Cust.desiredLocation, Cust.phoneNumber, myStmt);
            
                }    
            
            }
           */ 
            ui.employeeLoginPrompt(employeePanel, userName, passWord);
            int login = JOptionPane.showConfirmDialog(null, employeePanel, 
                    "Enter Login Information", JOptionPane.OK_CANCEL_OPTION);
            
            if (login == JOptionPane.OK_OPTION) {
                employee employeeInfo = new employee(userName.getText(), passWord.getText());
                int checkVar = sqlUpdate.loginCheck(employeeInfo.username, employeeInfo.password, loginStmt);
                
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }   

            
        /*  // Recipient's email ID needs to be mentioned.
            String to = "coltonsells3@yahoo.com";

        // Sender's email ID needs to be mentioned
            String from = "coltonsells3@yahoo.com";

        // Assuming you are sending email from localhost
            String host = "465";

        // Get system properties
            Properties properties = System.getProperties();

        // Setup mail server
            properties.setProperty("smtp.mail.yahoo.com", host);

        // Get the default Session object.
            Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
     */ }
      }
        
    
    

