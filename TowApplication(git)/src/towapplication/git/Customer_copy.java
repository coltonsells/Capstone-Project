/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towapplication.git;

import java.math.RoundingMode;
import java.math.BigDecimal;
/**
 *
 * @author Colton Sells
 */
public class Customer_copy {
    private String firstName = "";
    private String lastName = "";
    private String vehicleDescription = "";
    private String currentLocation = "";
    private String desiredLocation = "";
    private String phoneNumber = "";
    private double distance = 0;
    private double fare = 0;
    
    public Customer_copy(String firstName, String lastName, String vehicleDescription, 
            String currentLocation, String desiredLocation, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vehicleDescription = vehicleDescription;
        this.currentLocation = currentLocation;
        this.desiredLocation = desiredLocation;
        this.phoneNumber = phoneNumber;
        
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String fName) {
        firstName = fName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lName){
        lastName = lName;
    }
    
    public String getVehicleDescription(){
        return vehicleDescription;
    }
    
    public void setVehicleDescription(String vDescrip){
        vehicleDescription = vDescrip;
    }
    
    public String getCurrentLocation(){
        return currentLocation;
    }
    
    public void setCurrentLocation(String cLoc){
        currentLocation = cLoc;
    }
    
    public String getDesiredLocation(){
        return desiredLocation;
    }
    
    public void setDesiredLocation(String dLoc){
        desiredLocation = dLoc;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }
    
    public void setFare(double f){
        fare = f;
    }
    
    public double getFare(){
        return fare;
    }
    
    public void setDistance(double d){
        distance = d;
    }
    
    public double getDistance(){
        return distance;
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
}
}
