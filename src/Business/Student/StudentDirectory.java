/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Student;

import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;
import userinterface.MainJFrame;

/**
 *
 * @author Shreyas
 */

public class StudentDirectory {
    
    UserAccountDirectory useracc;
   private ArrayList<Student> student_Dir; 
     private StudentDirectory student_Di;
 MainJFrame main;

      
 
    public StudentDirectory(){
      student_Dir = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudent_Dir() {
        return student_Dir;
    }

    public void setStudent_Dir(ArrayList<Student> student_Dir) {
        this.student_Dir = student_Dir;
    }
    
     public Student addStudent()
    {
        Student v = new Student();
        student_Dir.add(v);
        return v;
    }
     public StudentDirectory getStudentDirectory() {
        StudentDirectory vd = main.getDir();
        return vd;
    }

    
}
