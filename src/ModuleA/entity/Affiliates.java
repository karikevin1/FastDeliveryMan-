/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Affiliates {
    public int AffiliatesID;
    private String AffiliatesName;
    private String AffiliatesIC;
    private String AffiliatesTelNo;
    private String AffiliatesEmail;
    private String AffiliatesAddress;
    private String AffiliatesCompanyType;
    
    public Affiliates(){
        
    }
    
    public Affiliates(int AffiliatesID, String AffiliatesName, String AffiliatesIC, String AffiliatesTelNo, String AffiliatesEmail, String AffiliatesAddress, String AffiliatesCompanyType){
        this.AffiliatesID = AffiliatesID;
        this.AffiliatesName = AffiliatesName;
        this.AffiliatesIC = AffiliatesIC;
        this.AffiliatesTelNo = AffiliatesTelNo;
        this.AffiliatesEmail = AffiliatesEmail;
        this.AffiliatesAddress = AffiliatesAddress;
        this.AffiliatesCompanyType = AffiliatesCompanyType;
     }

    public int getAffiliatesID() {
        return AffiliatesID;
    }

    public void setAffiliatesID(int AffiliatesID) {
        this.AffiliatesID = AffiliatesID;
    }

    public String getAffiliatesName() {
        return AffiliatesName;
    }

    public void setAffiliatesName(String AffiliatesName) {
        this.AffiliatesName = AffiliatesName;
    }

    public String getAffiliatesIC() {
        return AffiliatesIC;
    }

    public void setAffiliatesIC(String AffiliatesIC) {
        this.AffiliatesIC = AffiliatesIC;
    }

    public String getAffiliatesTelNo() {
        return AffiliatesTelNo;
    }

    public void setAffiliatesTelNo(String AffiliatesTelNo) {
        this.AffiliatesTelNo = AffiliatesTelNo;
    }

    public String getAffiliatesEmail() {
        return AffiliatesEmail;
    }

    public void setAffiliatesEmail(String AffiliatesEmail) {
        this.AffiliatesEmail = AffiliatesEmail;
    }

    public String getAffiliatesAddress() {
        return AffiliatesAddress;
    }

    public void setAffiliatesAddress(String AffiliatesAddress) {
        this.AffiliatesAddress = AffiliatesAddress;
    }

    public String getAffiliatesCompanyType() {
        return AffiliatesCompanyType;
    }

    public void setAffiliatesCompanyType(String AffiliatesCompanyType) {
        this.AffiliatesCompanyType = AffiliatesCompanyType;
    }
    
    

    
    
    
    
  
    @Override
  public String toString() {
      return String.format("%-4d%30s%30s%30s%30s%30s%30s", AffiliatesID, AffiliatesName, AffiliatesIC, AffiliatesAddress, AffiliatesTelNo, AffiliatesEmail, AffiliatesCompanyType);
    
  }
  
  
}

