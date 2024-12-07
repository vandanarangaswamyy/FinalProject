/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import java.util.ArrayList;
import Business.Role.PartTimeRole;
import Business.Role.Role;


/**
 *
 * @author anirudhraj
 */
public class PartTimeOrganization extends Organization{

    public PartTimeOrganization() 
    {
        
        
        super(Organization.Type.VocationalSchool.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        
        
        roles.add(new PartTimeRole());
        return roles;
    }
     
}
