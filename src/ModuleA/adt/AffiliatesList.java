/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;

/**
 *
 * @author User
 */
public class AffiliatesList<T> implements AffiliatesInterface<T> {
    private AffiliatesData firstAffiliates;
    private int numberAffiliatesOfEntries;
    
    public AffiliatesList(){
        clearAffiliates();
    }
    
    public final void clearAffiliates(){
        firstAffiliates = null;
        numberAffiliatesOfEntries = 0;
    }
    
    public boolean addAffiliates(T newAffiliates){
        AffiliatesData<T> newAffiliatesData = new AffiliatesData<>(newAffiliates);
        
        if (isAffiliatesEmpty()) {
         firstAffiliates = newAffiliatesData;
        } else {
        AffiliatesData<T> lastAffiliates = getAffiliatesAt(numberAffiliatesOfEntries);
        lastAffiliates.setNextAffiliates(newAffiliatesData);
    }

    numberAffiliatesOfEntries++;
    return true;
    }
    
    public boolean addAffiliates(int newAffiliatesPosition, T newAffiliates){
     boolean isSuccessful = true;

    if ((newAffiliatesPosition >= 1) && (newAffiliatesPosition <= numberAffiliatesOfEntries + 1)) {
      AffiliatesData<T> newAffiliatesData = new AffiliatesData<T>(newAffiliates);

      if (isAffiliatesEmpty() || (newAffiliatesPosition == 1)) {    
        newAffiliatesData.setNextAffiliates(firstAffiliates);
        firstAffiliates = newAffiliatesData;
      } else {								                 
        AffiliatesData  affiliatesBefore = getAffiliatesAt(newAffiliatesPosition - 1);
        AffiliatesData affiliatesAfter = affiliatesBefore.getNextAffiliates();
        newAffiliatesData.setNextAffiliates(affiliatesAfter);
        affiliatesBefore.setNextAffiliates(newAffiliatesData);
      }

      numberAffiliatesOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    

    
    public boolean updateAffiliates(int givenAffiliatesPosition, T newAffiliates){
    boolean isSuccessful = true;

    if ((givenAffiliatesPosition >= 1) && (givenAffiliatesPosition <= numberAffiliatesOfEntries)) {
      AffiliatesData<T> desiredAffiliates = getAffiliatesAt(givenAffiliatesPosition);
      desiredAffiliates.setAffiliatesData(newAffiliates);
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T getAffiliatesEntry(int givenAffiliatesPosition){
    T result = null;

    if ((givenAffiliatesPosition >= 1) && (givenAffiliatesPosition <= numberAffiliatesOfEntries)) {
      result = getAffiliatesAt(givenAffiliatesPosition).getAffiliatesData();
    }

    return result;
    }


    public int getNumberOfAffiliates(){
        return numberAffiliatesOfEntries;
    }
    
    
    public boolean isAffiliatesEmpty() {
    boolean result;

    if (numberAffiliatesOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

    public String toString() {
    String outputStr = "";
    AffiliatesData<T> currentAffiliates = firstAffiliates;
    while (currentAffiliates != null) {
      outputStr += currentAffiliates.getAffiliatesData() + "\n";;
      currentAffiliates = currentAffiliates.getNextAffiliates();
    }
    return outputStr;
  }   
    
   private AffiliatesData<T> getAffiliatesAt(int givenAffiliatesPosition) {
        AffiliatesData<T> currentAffiliates = firstAffiliates;

    for (int counter = 1; counter < givenAffiliatesPosition; counter++) {
        currentAffiliates = currentAffiliates.getNextAffiliates();
    }

        return currentAffiliates;
    }
private class AffiliatesData<T> {

    private T affiliatesData;
    private AffiliatesData nextAffiliates;

    private AffiliatesData(T affiliatesData) {
      this.affiliatesData = affiliatesData;
      this.nextAffiliates = null;
    }

    private AffiliatesData(T affiliatesData, AffiliatesData nextAffiliates) {
      this.affiliatesData = affiliatesData;
      this.nextAffiliates = nextAffiliates;
    }
     public void setAffiliatesData(T affiliatesData) {
        this.affiliatesData = affiliatesData;
    }

     public void setNextAffiliates(AffiliatesData nextAffiliates) {
        this.nextAffiliates = nextAffiliates;
    }

    public T getAffiliatesData() {
        return affiliatesData;
    }

     public AffiliatesData getNextAffiliates() {
        return nextAffiliates;
     }
  }    
    
}
