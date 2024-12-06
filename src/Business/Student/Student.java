/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Student;

/**
 *
 * @author dhaan
 */
public class Student {
    
    private String student_ID;
    private String firstName;
    private String lastName;
    
    private String password;
    private String username;
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }
    public String getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(String student_ID) {
        this.student_ID = student_ID;
    }
    private String residentAddress;
    private String armyType;
    
    private String age;
    private String gender;
    
    private String educationalDetails;
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    public String getArmyType() {
        return armyType;
    }


    public String getResidentAddress() {
        return residentAddress;
    }

    
    public void setArmyType(String armyType) {
        this.armyType = armyType;
    }

    public String getGender() {
        return gender;
    }
    
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public void setEducationalDetails(String educationalDetails) {
    this.educationalDetails = educationalDetails;
    }

    public String getEducationalDetails() {
        return educationalDetails;
    }

    @Override
    public String toString() {
        return firstName;
    }
}
