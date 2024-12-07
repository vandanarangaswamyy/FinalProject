/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author dhaan
 */


public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private Date requestDate;
    private Date resolveDate;
    private String streetAddress;
    private String status;
    

   
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public WorkRequest() {
        requestDate = new Date();
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }
    
        public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }
        
            public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }


     @Override
    public String toString() {
        return message;
    }
}
