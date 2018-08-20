/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towapplication.git;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Colton Sells
 */
public class ui {
    
    
    public static void createUI (JTextField fName, JTextField lName, JTextField vDesc, JTextField cLoc,
        JTextField dLoc, JTextField pNum, JPanel panel) {
     
        
        //Applies JText boxes to a Jpanel for UI
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(new JLabel("First Name:"));
        panel.add(fName);
        panel.add(Box.createHorizontalStrut(15)); // a spacer
        panel.add(new JLabel("Last Name:"));
        panel.add(lName);
        panel.add(new JLabel("Vehicle Description:"));
        panel.add(vDesc);
        panel.add(new JLabel("Pick Up Location"));
        panel.add(cLoc);
        panel.add(new JLabel("Drop Off Location"));
        panel.add(dLoc);
        panel.add(new JLabel("Phone Number"));
        panel.add(pNum);
    }
    
    public static void confirmationPrompt(JPanel panel, String fName, String lName,
    String vDesc, String cLoc, String dLoc, double f){

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(new JLabel("Name: " + fName + " " + lName));
        panel.add(new JLabel("Vehicle Description: " + vDesc));
        panel.add(new JLabel("Pick Up Location: " + cLoc));
        panel.add(new JLabel("Drop Off Location: " + dLoc));
        panel.add(new JLabel("Total Fare: $" + f));
        panel.add(new JLabel("---------"));
        panel.add(new JLabel("If you wish to place your order click OK"));
    }
    
    public static void employeeLoginPrompt(JPanel panel, JTextField uName, JTextField password){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(new JLabel("Username:"));
        panel.add(uName);
        panel.add(new JLabel("Password:"));
        panel.add(password);
        
    }
    
    public static void employeeJobUpdatePrompt(JPanel panel, JTextField job){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(new JLabel("Input Job ID to be completed"));
        panel.add(job);
    }
}
