/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author dhaan
 */
public class UserAccount {
    
    
    private String password;
    private String username;
    private Role role;
    private Employee employee;
    
    
    private WorkQueue workQueue;

    public UserAccount() {
        workQueue = new WorkQueue();
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Employee getEmployee() {
        return employee;
    }
    
    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return username;
    }
    
    
    
}