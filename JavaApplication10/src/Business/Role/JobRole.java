/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import javax.swing.JPanel;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import Business.Organization.JobOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccountDirectory;
import Business.Student.StudentDirectory;

import userinterface.JobRole.JobWorkAreaJPanel;
//import userinterface.PermHousing.PermHousingWorkAreaJPanel;

/**
 *
 * @author anirudhraj
 */
public class JobRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, StudentDirectory vd , UserAccountDirectory user_Dir)
    {
        return new JobWorkAreaJPanel(userProcessContainer, account, (JobOrganization) organization, enterprise, vd,business);
    }
    
    
    
}
