/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Listings;

/**
 *
 * @author anirudhraj
 */
public class HouseListing {
    int listingId;
    String Area;
    String StreetName;
    String DoorNumber;
    String City;
    String PinCode;
    int Availability = 0;

    public int getAvailability() {
        return Availability;
    }
    
    public String getDoorNumber() {
        return DoorNumber;
    }
    
    public void setPinCode(String PinCode) {
        this.PinCode = PinCode;
    }

    

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    
    public String getStreetName() {
        return StreetName;
    }

    
    
    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
    public String getCity() {
        return City;
    }

    
    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    

    public void setDoorNumber(String DoorNumber) {
        this.DoorNumber = DoorNumber;
    }

    

    public void setCity(String City) {
        this.City = City;
    }

    public String getPinCode() {
        return PinCode;
    }

    
    public String getArea() {
        return Area;
    }
    
    
      @Override
    public String toString() {
        return Area;
    }
}
