/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import userinterface.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Student.StudentDirectory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author anirudhraj
 */
public class SystemAdminRole extends Role

{
   
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system,StudentDirectory vd, UserAccountDirectory user_Dir) 
    
    {
        try 
        {
           
            return new SystemAdminWorkAreaJPanel(userProcessContainer, system,vd, user_Dir);
        } 
        catch (IOException ex)
        {
          
            Logger.getLogger(SystemAdminRole.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
        
    }


    
}
