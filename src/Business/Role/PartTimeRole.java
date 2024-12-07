/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import javax.swing.JPanel;
import userinterface.PartTimeRole.PartTImeAreaJPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Organization.PartTimeOrganization;
import Business.UserAccount.UserAccountDirectory;

import Business.Student.StudentDirectory;


/**
 *
 * @author anirudhraj
 */
public class PartTimeRole extends Role 

{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,StudentDirectory vd, UserAccountDirectory user_Dir)
    {
        
        return new PartTImeAreaJPanel(userProcessContainer, account, (PartTimeOrganization)organization, enterprise, vd, business);
    }


    
}
