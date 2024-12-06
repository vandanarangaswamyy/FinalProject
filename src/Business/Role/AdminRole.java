/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.UserAccount.UserAccount;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import userinterface.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;
import Business.Student.StudentDirectory;
import Business.UserAccount.UserAccountDirectory;



/**
 *
 * @author anirudhraj
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,StudentDirectory vd,UserAccountDirectory user_Dir) {
        
        
        return new AdminWorkAreaJPanel(userProcessContainer, enterprise, vd, user_Dir);
    }


    
    
}
