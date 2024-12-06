/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import java.util.ArrayList;
import Business.Role.Role;
import Business.Role.MentalHealthCareRole;
import Business.Role.PhysicalHealthCareRole;



/**
 *
 * @author anirudhraj
 */
public class MentalHealthCareOrganzition extends Organization{
  
    public MentalHealthCareOrganzition()
    {
    
        super(Organization.Type.MentalHeathCare.getValue());
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        
        roles.add(new MentalHealthCareRole());
        return roles;
    }
}
