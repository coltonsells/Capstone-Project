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
public class Customer_copy {
    String firstName = "";
    String lastName = "";
    String vehicleDescription = "";
    String currentLocation = "";
    String desiredLocation = "";
    String phoneNumber = "";
    float distance = 0;
    float fare = 0;
    
    public Customer_copy(String firstName, String lastName, String vehicleDescription, 
            String currentLocation, String desiredLocation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicleDescription = vehicleDescription;
        this.currentLocation = currentLocation;
        this.desiredLocation = desiredLocation;
        this.phoneNumber = phoneNumber;
        
    }

}
