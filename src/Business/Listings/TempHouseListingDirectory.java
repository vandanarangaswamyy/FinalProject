/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Listings;

import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import userinterface.MainJFrame;
import userinterface.PermHousing.AddListingJPanel;

/**
 *
 * @author anirudhraj
 */
public class TempHouseListingDirectory {
    
    
    
    
    MainJFrame main;
    
    int Total_count=0;
    
    UserAccountDirectory useracc;
    
    private ArrayList<TempHouseListing> TempHouseListing_Dir; 
    private HouseListingDirectory HouseLisitng_Di;
    
    private ArrayList<HouseListing> houseList;
    
   
     
     AddListingJPanel addlisting;
     

     public TempHouseListingDirectory(){
      TempHouseListing_Dir = new ArrayList<TempHouseListing>();
    }
     
     
    public int getTotal_count() {
        return Total_count;
    }

    public void setTotal_count(int Total_count) {
        this.Total_count = Total_count;
    }

      
 
    

    public ArrayList<TempHouseListing> getTempHouseListing_Dir() {
        return TempHouseListing_Dir;
    }

    
    
    public void setTempHouseListing_Dir(ArrayList<TempHouseListing> TempHouseListing_Dir) {
        this.TempHouseListing_Dir = TempHouseListing_Dir;
    }
    
    
    
    public void DeleteTempHouseListing(HouseListing h)
    {
        
        TempHouseListing_Dir.remove(h);
        Total_count = TempHouseListing_Dir.size();
        
    }
    
    
    
     public TempHouseListing addTempHouseListing()
    {
        TempHouseListing h = new TempHouseListing();
        TempHouseListing_Dir.add(h);
        //Total_count += h.getNumberOfPeople();
        //Total_count = TempHouseListing_Dir.size();
        return h;
    }
     
     
    
}
