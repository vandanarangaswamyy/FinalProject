/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
//import Business.Organization.DoctorOrganization;
import Business.Organization.GradSchoolOrganization;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.Organization.Organization;
import Business.Student.StudentDirectory;
import userinterface.GradSchoolRole.GradSchoolWorkAreaJPanel;

/**
 *
 * @author anirudhraj
 */
public class GradSchoolRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,StudentDirectory vd,UserAccountDirectory user_Dir) {
        
        
        
        return new GradSchoolWorkAreaJPanel(userProcessContainer, account, (GradSchoolOrganization)organization, enterprise, vd, business);
    }


    
}
