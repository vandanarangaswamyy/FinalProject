/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import javax.swing.JPanel;
import Business.Organization.Organization;
import Business.Student.StudentDirectory;


/**
 *
 * @author anirudhraj
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        VocationalSchool("Vocational School"), 
        GradSchool("Grad School"), 
        TempHousing("Temporary Housing"), 
        PermHousing("Permanent Housing"),
        Student("Student");
        
        private String value;
        private RoleType(String value){
            this.value = value;
            
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
        
        
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business,
            StudentDirectory vd,
            UserAccountDirectory user_Dir);
   
 
    
    
    

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}