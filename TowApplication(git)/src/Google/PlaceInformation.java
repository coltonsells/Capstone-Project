/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Google;

/**
 *
 * @author Colton Sells
 */
public class PlaceInformation {
    String name = "";
    String address = "";
    String tag = "";
    double latitude = 0;
    double longitude = 0;
    GeoLocation gLoc = new GeoLocation(latitude, longitude);
    
    
    public PlaceInformation(String name, String address, String tag,
                        double latitude, double longitude){
        this.name = name;
        this.address = address;
        this.tag = tag;
        this.latitude = latitude;
        this.longitude = longitude;
        gLoc.latitude = latitude;
        gLoc.longitude = longitude;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getTag(){
        return tag;
    }
    public String toString(){
        return name + "(" +address+ ", "+ latitude + "," + longitude + ")";
    }
    public GeoLocation getLocation(){
        return gLoc;
    }
    public double distanceFrom(GeoLocation spot){
        return gLoc.distanceFrom(spot);
    }

    
}

