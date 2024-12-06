/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import javax.swing.JPanel;
import userinterface.PermHousing.PermHousingWorkAreaJPanel;
import Business.Organization.Organization;
import Business.Organization.PermHousingOrganization;
import Business.UserAccount.UserAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;


/**
 *
 * @author anirudhraj
 */

public class PermHousingRole extends Role

{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, StudentDirectory vd , UserAccountDirectory user_Dir)
    {
        
        return new PermHousingWorkAreaJPanel(userProcessContainer, account, organization, enterprise, vd,business);
    }


    
}
