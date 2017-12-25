/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.entity;

/**
 *
 * @author User
 */
public class CustomerRating {
        private int ratingID;
        private String custRatingName;
        private int ratingScore;
        private String companyType;
        private String ratingComment;
        
        public CustomerRating(){
            
        }

    public CustomerRating(int ratingID, String custRatingName, String companyType, int ratingScore, String ratingComment) {
        this.ratingID = ratingID;
        this.custRatingName = custRatingName;
        this.ratingScore = ratingScore;
        this.companyType = companyType;
        this.ratingComment = ratingComment;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public String getCustRatingName() {
        return custRatingName;
    }

    public void setCustRatingName(String custRatingName) {
        this.custRatingName = custRatingName;
    }

    public int getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(int ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getRatingComment() {
        return ratingComment;
    }

    public void setRatingComment(String ratingComment) {
        this.ratingComment = ratingComment;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    
    
        
    public String toString(){
        return String.format("%4d%30s%45s%50d%60s",ratingID, custRatingName, companyType, ratingScore, ratingComment);
    }
}
