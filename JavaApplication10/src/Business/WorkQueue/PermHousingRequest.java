/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author dhaan
 */
public class PermHousingRequest extends WorkRequest{
   int listingId;
    String Area;
    String City;
    String PinCode;
    String StreetName;
    String DoorNumber;
    String Comment;
    int availibility;

    public int getAvailibility() {
        return availibility;
    }

    public void setAvailibility(int availibility) {
        this.availibility = availibility;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getComment() {
    return Comment;
    }
    
    public int getListingId() {
        return listingId;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }
    
        public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    public String getArea() {
        return Area;
    }

    public String getStreetName() {
        return StreetName;
    }

    public void setDoorNumber(String DoorNumber) {
        this.DoorNumber = DoorNumber;
    }

    public String getCity() {
        return City;
    }
    
    public void setStreetName(String StreetName) {
        this.StreetName = StreetName;
    }

    public String getDoorNumber() {
        return DoorNumber;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPinCode() {
        return PinCode;
    }

    public void setPinCode(String PinCode) {
        this.PinCode = PinCode;
    }
    
    
   
    
    
}
