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
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.sql.*;
import java.lang.Math;
import javax.activation.*;
import towapplication.git.ui;
import towapplication.git.sqlUpdate;
import towapplication.git.employee;
import Google.GeoCoder;
import Google.PlaceInformation; 



public class TowApplicationGit {

    /**
     * @param args the command line arguments
     */
    // From emial setup
    static final String FROM = "email";
    static final String FROMNAME = "New Tow For Driver";
	
    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    static final String TO = "email";
    
    // Amazon SES SMTP username.
    static final String SMTP_USERNAME = "username";
    
    // Amazon SES SMTP password.
    static final String SMTP_PASSWORD = "password";
    
    // Amazon SES SMTP host name.
    static final String HOST = "email-smtp.us-east-1.amazonaws.com";
    
    // The port you will connect to on the Amazon SES SMTP endpoint. 
    static final int PORT = 587;
    
    // Subject line for the email being sent
    static final String SUBJECT = "New Tow";
    
    public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
        
        try {
            //Get connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/towapplication?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false", 
                    "root", "pasword");
            //Create a statement
            Statement myStmt = myConn.createStatement();
            Statement loginStmt = myConn.createStatement();
            Statement retrieveStmt = myConn.createStatement();
                     
            //Text field UI intitializations for user UI
            JTextField firstName = new JTextField(10);
            JTextField lastName = new JTextField(10);
            JTextField vehicleDesc = new JTextField(10);
            JTextField currentLoc = new JTextField(10);
            JTextField desiredLoc = new JTextField(10);
            JTextField phoneNum = new JTextField(10);
            JPanel myPanel = new JPanel();
            
            //Text field UI initializations for employee login UI
            JTextField userName = new JTextField(10);
            JTextField passWord = new JTextField(10);
            JPanel employeePanel = new JPanel();
            
            //Text field UI initilizations for employee job completion UI
            JTextField jobId = new JTextField(6);
            JPanel jobUpdate = new JPanel();
       
            //Customer object variable initilizations
            String sfirstName = "";
            String slastName = "";
            String svehicleDescription = "";
            String scurrentLocation = "";
            String sdesiredLocation = "";
            String sphoneNumber = "";
            
        
            //Initializes customer object
            Customer_copy Cust = new Customer_copy(sfirstName, slastName, 
                svehicleDescription, scurrentLocation, sdesiredLocation, sphoneNumber);
            
            //Test distance
            Cust.setDistance(100);
       
            //Applies JText boxes to a Jpanel for UI
            ui.createUI(firstName, lastName, vehicleDesc, currentLoc, desiredLoc, 
                phoneNum, myPanel);
            
            //Stores customer inputs into Customer class variables
            int result = JOptionPane.showConfirmDialog(null, myPanel,
            "Please enter the information below", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                Cust.setFirstName(firstName.getText());
                Cust.setLastName(lastName.getText());
                Cust.setVehicleDescription(vehicleDesc.getText());
                Cust.setCurrentLocation(currentLoc.getText());
                Cust.setDesiredLocation(desiredLoc.getText());
                Cust.setPhoneNumber(phoneNum.getText());
                
                //get geolocation information for current location
                PlaceInformation one = GeoCoder.findPlace(Cust.getCurrentLocation());
                if (one == null) {
                     System.out.println("no matches for that search string.");
                }
                //get geolocation information for desired location
                PlaceInformation two = GeoCoder.findPlace(Cust.getDesiredLocation());
                if (two == null) {
                    System.out.println("no matches for that search string.");
                } 
      
                //Calculates fare and rounds it based of 5 dollars per mile
                double d = one.distanceFrom(two.getLocation()) * 5;
                d = Customer_copy.round(d, 2);
                Cust.setFare(d);
      
                //Prompts fare amount and request confirmation for order
                JPanel orderConfirm = new JPanel();
                ui.confirmationPrompt(orderConfirm, Cust.getFirstName(), Cust.getLastName(),
                        Cust.getVehicleDescription(), Cust.getCurrentLocation(), Cust.getDesiredLocation(), 
                        Cust.getFare());
               
                //Verfiy the ok button is pressed
                int result2 = JOptionPane.showConfirmDialog(null, orderConfirm,
                "Order Confirmation", JOptionPane.OK_CANCEL_OPTION);
      
                if (result2 == JOptionPane.OK_OPTION) {
                    //update customer table in database
                    sqlUpdate.databaseUpdate(Cust.getFirstName(), Cust.getLastName(), Cust.getVehicleDescription(),
                    Cust.getCurrentLocation(), Cust.getDesiredLocation(), Cust.getPhoneNumber(), myStmt);               
                    //get job id for emial
                    int idRetrieve = sqlUpdate.retrieveId(Cust.getFirstName(), Cust.getLastName(), Cust.getVehicleDescription(), 
                            Cust.getCurrentLocation(), Cust.getDesiredLocation(), Cust.getPhoneNumber(), retrieveStmt);
                    
                    String sendId = Integer.toString(idRetrieve);
                    
                    //text for email
                    String text = String.join(
                            System.getProperty("line.separator"), 
                            
                            "<h1>New Tow<h1>", 
                            "<p>"+ Cust.getFirstName() + " " + Cust.getLastName() + "<br>" +
                            " Job ID: " + sendId + "<br>" +
                            " Car Descritpion: " + Cust.getVehicleDescription() + "<br>" +
                            " Pick Up location: " + Cust.getCurrentLocation() + "<br>" +
                            " Drop Off location: " + Cust.getDesiredLocation() + "<br>" +
                            " Phone Number: " + Cust.getPhoneNumber()) + "<br>" +
                            " Fare: $" + d;
                      
                    Properties props = System.getProperties();
                    props.put("mail.transport.protocol", "smtp");
                    props.put("mail.smtp.port", PORT); 
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.auth", "true");

                    // Create a Session object to represent a mail session with the specified properties. 
                    Session session = Session.getDefaultInstance(props);

                    // Create a message with the specified information. 
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(new InternetAddress(FROM,FROMNAME));
                    msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
                    msg.setSubject(SUBJECT);
                    msg.setContent(text,"text/html");                 
            
                    // Create a transport.
                    Transport transport = session.getTransport();
                    
                    // Send the message.
                    try
                    {
                        System.out.println("Sending...");
            
                        // Connect to Amazon SES using the SMTP username and password you specified above.
                        transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
                        // Send the email.
                        transport.sendMessage(msg, msg.getAllRecipients());
                        System.out.println("Email sent!");
                    }
                    catch (Exception ex) {
                        System.out.println("The email was not sent.");
                        System.out.println("Error message: " + ex.getMessage());
                    }
                    finally
                    {
                        // Close and terminate the connection.
                        transport.close();
                    }   
                }    
            }
            //prompt employee login UI
            ui.employeeLoginPrompt(employeePanel, userName, passWord);
            int login = JOptionPane.showConfirmDialog(null, employeePanel, 
                    "Enter Login Information", JOptionPane.OK_CANCEL_OPTION);
            
            if (login == JOptionPane.OK_OPTION) {
                employee employeeInfo = new employee(userName.getText(), passWord.getText());
                int checkVar = sqlUpdate.loginCheck(employeeInfo.username, employeeInfo.password, loginStmt);
                
                if(checkVar == 1){
                    //Change job completed status
                    ui.employeeJobUpdatePrompt(jobUpdate, jobId);
                    int update = JOptionPane.showConfirmDialog(null, jobUpdate, 
                            "Enter Job ID to be completed", JOptionPane.OK_CANCEL_OPTION);
                    if(update == JOptionPane.OK_OPTION) { 
                        
                        int jobIdNumber = Integer.parseInt(jobId.getText());
                        sqlUpdate.updateJobStatus(jobIdNumber, myConn);
                        JOptionPane.showMessageDialog(null, "Job status successfully updated");
                    }
                } else {
                 JOptionPane.showMessageDialog(null, "Login failed uersname or password incorrect");
                }
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }   
}
}

        
    
    

