/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import java.util.ArrayList;
//import Business.Role.GradSchoolRole;
import Business.Role.Role;
import Business.Role.JobRole;



/**
 *
 * @author anirudhraj
 */
public class JobOrganization extends Organization {
    
    
     public JobOrganization() {
        super(Organization.Type.Job.getValue());
    }
     
     
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new JobRole());
        return roles;
    }
}
