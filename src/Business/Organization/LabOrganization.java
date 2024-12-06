/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import java.util.ArrayList;

import Business.Role.Role;
import Business.Role.LabAssistantRole;


/**
 *
 * @author anirudhraj
 */
public class LabOrganization extends Organization{

    
    
    public LabOrganization() 
    {
        super(Organization.Type.Lab.getValue());
    }

    
    
    @Override
    public ArrayList<Role> getSupportedRole() 
    {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new LabAssistantRole());
        return roles;
    }
     
   
    
    
}
