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
public class employee {
    
    String username = "";
    String password = "";
    
    public employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setUsername(String uName){
        username = uName;
    }
    
    public void setPassword(String pWord){
        password = pWord;
    }
}
