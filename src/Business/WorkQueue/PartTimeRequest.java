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
public class PartTimeRequest extends WorkRequest {

    
    private String campus;
    private String highestQualification;
    private String fundingRequired;
    private String HousingRequest;
    private String areaOfInterest;
    

    public String getFundingRequired() {
        return fundingRequired;
    }

    public void setFundingRequired(String fundingRequired) {
        this.fundingRequired = fundingRequired;
    }
    
    private String additionalComments;

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public String getCampus() {
        return campus;
    }
    
    public String getHousingRequest() {
    return HousingRequest;
    }

    public void setHousingRequest(String HousingRequest) {
        this.HousingRequest = HousingRequest;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
    
        public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public String getHighestQualification() {
        return highestQualification;
    }


    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public String getHousingAddress() {
        return HousingRequest;
    }

    public void setHousingAddress(String HousingAddress) {
        this.HousingRequest = HousingAddress;
    }

}
