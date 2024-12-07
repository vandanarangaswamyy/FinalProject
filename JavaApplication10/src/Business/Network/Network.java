/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;

/**
 *
 * @author anirudhraj
 */
public class Network {
    
    private EnterpriseDirectory enterpriseDirectory;
    
    
    private String name;
    
    
    public Network(){
        enterpriseDirectory=new EnterpriseDirectory();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    public String getName() {
        return name;
    }

    
public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }
    
    
    @Override
    public String toString(){
        return name;
    }
    
}
