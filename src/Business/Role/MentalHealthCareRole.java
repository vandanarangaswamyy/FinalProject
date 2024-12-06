/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.PermHousing.PermHousingWorkAreaJPanel;
import Business.EcoSystem;
import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;
import Business.Enterprise.Enterprise;
import javax.swing.JPanel;
import userinterface.MentalHealthCare.MentalHealthCareWorkAreaJPanel;


/**
 *
 * @author anirudhraj
 */
public class MentalHealthCareRole  extends Role
{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, StudentDirectory vd , UserAccountDirectory user_Dir) 
    {
        
        return new MentalHealthCareWorkAreaJPanel(userProcessContainer, account, organization, enterprise, vd , business);
    }

}
