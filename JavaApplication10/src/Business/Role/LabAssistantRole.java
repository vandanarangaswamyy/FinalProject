/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import javax.swing.JPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;

import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;

import userinterface.LabAssistantRole.LabAssistantWorkAreaJPanel;


/**
 *
 * @author anirudhraj
 */
public class LabAssistantRole extends Role 
{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, StudentDirectory vd, UserAccountDirectory user_Dir) 
    {
       
        return new LabAssistantWorkAreaJPanel(userProcessContainer, account, organization, business, vd);
    }

    
    
}
