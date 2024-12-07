/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import javax.swing.JPanel;
import userinterface.StudentRole.StudentWorkAreaJPanel;
import Business.EcoSystem;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;


/**
 *
 * @author anirudhraj
 */
public class StudentRole extends Role 
{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, StudentDirectory vd, UserAccountDirectory user_Dir) 
    
    {
        
        return new StudentWorkAreaJPanel(userProcessContainer, account, (StudentOrganization) organization, enterprise, vd);
    }
}
