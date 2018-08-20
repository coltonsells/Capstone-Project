

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import towapplication.git.employee;
import towapplication.git.Customer_copy;

/**
 *
 * @author Colton Sells
 */
public class objectClassTests {
    
    @Test
    public void testGetUsername() {
        String username = "testUsername";
        String password = "testPassword";
        
        employee testEmployee = new employee(username, password);
        String retrieveUsername = testEmployee.getUsername();

        assertEquals(retrieveUsername, username);

    }
    
    @Test
    public void testGetPassword() {
        String username = "testUsername";
        String password = "testPassword";
        
        employee testEmployee = new employee(username, password);
        String retrievePassword = testEmployee.getPassword();
        
        assertEquals(retrievePassword, password);
    }
    
    @Test
    public void testGetFirstName(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedFirstName = testCustomer.getFirstName();
    assertEquals(retrievedFirstName, firstName);
    }
    
    @Test
    public void testGetLastName(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedlastName = testCustomer.getLastName();
    assertEquals(retrievedlastName, lastName);
    }
    
    @Test
    public void testGetVehicleDescription(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedDescription = testCustomer.getVehicleDescription();
    assertEquals(retrievedDescription, vehicleDescription);
    }
    
    @Test
    public void testGetCurrentLocation(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedCurrent = testCustomer.getCurrentLocation();
    assertEquals(retrievedCurrent, currentLocation);
    }
    
    @Test
    public void testGetDesiredLocation(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedDesired = testCustomer.getDesiredLocation();
    assertEquals(retrievedDesired, desiredLocation);
    }
    
    @Test
    public void testGetPhoneNumber(){
    String firstName = "testFirst";
    String lastName = "testLast";
    String vehicleDescription = "testDescription";
    String currentLocation = "testCurrent";
    String desiredLocation = "testDesired";
    String phoneNumber = "testPhone";
    
    Customer_copy testCustomer = new Customer_copy(firstName, lastName, vehicleDescription,
    currentLocation, desiredLocation, phoneNumber);
    
    String retrievedPhone = testCustomer.getPhoneNumber();
    assertEquals(retrievedPhone, phoneNumber);
    }
}
