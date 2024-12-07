/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Student.StudentDirectory;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;
import Business.UserAccount.UserAccountDirectory;



/**
 *
 * @author anirudhraj
 */
public abstract class Organization {

    private static int counter=0;
    private String name;
    
    private int organizationID;
    private WorkQueue workQueue;
    
    private StudentDirectory vd;
    
    
    
    
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    public enum Type{
        Admin("Admin Organization"), 
        Doctor("Doctor Organization"), 
        Lab("Lab Organization"), 
        VocationalSchool("Part-Time Job"), 
        GradSchool("Grad School"), 
        TempHousing("Temporary Housing"), 
        PermHousing("Permanent Housing"),
        Student("Student"),
        PhysicalHealthCare("Physical HealthCare"),
        MentalHeathCare("Mental HealthCare"),
        Job("Job Organization");
        
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        //vd = new StudentDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }
    
    
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    

    

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    
    
    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    
    public int getOrganizationID() {
        return organizationID;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    

    public StudentDirectory getUserStudentDirectory() {
        return vd;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
}
