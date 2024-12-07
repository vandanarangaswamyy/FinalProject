/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author dhaan
 */
public class JobWorkRequest extends WorkRequest{
    
    
    private String areaOfInterest;
    private String highestQualification;
    private String CandidateName;
    private String campus;
    

    public String getCandidateName() {
        return CandidateName;
    }
    
    
    public String getHighestQualification() {
        return highestQualification;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public String getCampus() {
        return campus;
    }
    
     public void setCandidateName(String CandidateName) {
        this.CandidateName = CandidateName;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }
    
}
