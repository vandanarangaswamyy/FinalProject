/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import java.util.ArrayList;
import Business.Role.Role;
import Business.Role.GradSchoolRole;
import Business.Role.PartTimeRole;



/**
 *
 * @author anirudhraj
 */
public class GradSchoolOrganization extends Organization{

    public GradSchoolOrganization() {
        super(Organization.Type.GradSchool.getValue());
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new GradSchoolRole());
        return roles;
    }
    
     
     
}
