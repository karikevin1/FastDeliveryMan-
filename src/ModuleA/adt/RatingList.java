/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.entity.CustomerRating;

/**
 *
 * @author User
 */
public class RatingList<T> implements RatingInterface<T> {
    private RatingData firstRating;
    private RatingData lastRating;
    private int numberRatingOfEntries;
    
    public RatingList(){
        clearRating();
    }
    
    public final void clearRating(){
        firstRating = null;
        lastRating = null;
        numberRatingOfEntries = 0;
    }

    public boolean addRating(T newRating) {
        RatingData<T> newRatingData = new RatingData<>(newRating);
        
        if (isRatingEmpty()) {
         firstRating = newRatingData;
        } else {
        RatingData<T> lastRating = getRatingAt(numberRatingOfEntries);
        lastRating.setNextRating(newRatingData);
    }

    numberRatingOfEntries++;
    return true;
    }

    @Override
    public boolean addRating(int newRatingPosition, T newRating) {
        boolean isSuccessful = true;

    if ((newRatingPosition >= 1) && (newRatingPosition <= numberRatingOfEntries + 1)) {
      RatingData<T> newRatingData = new RatingData<T>(newRating);

      if (isRatingEmpty() || (newRatingPosition == 1)) {    
        newRatingData.setNextRating(firstRating);
        firstRating = newRatingData;
      } else {								                     
        RatingData ratingBefore = getRatingAt(newRatingPosition - 1);
        RatingData ratingAfter = ratingBefore.getNextRating();
        newRatingData.setNextRating(ratingAfter);
        ratingBefore.setNextRating(newRatingData);
      }

      numberRatingOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }


    @Override
    public T getRatingEntry(int givenRatingPosition) {
        T result = null;

    if ((givenRatingPosition >= 1) && (givenRatingPosition <= numberRatingOfEntries)) {
      result = getRatingAt(givenRatingPosition).getRatingData();
    }
    

    return result;
    }
    

    @Override
    public int getNumberOfRating() {
        return numberRatingOfEntries;
    }

    @Override
    public boolean isRatingEmpty() {
        boolean result;

        if (numberRatingOfEntries == 0) {
            result = true;
        } else {
            result = false;
    }

    return result;
    }

    private RatingData<T> getRatingAt(int givenRatingPosition) {
        RatingData<T> currentRating = firstRating;

    for (int counter = 1; counter < givenRatingPosition; counter++) {
        currentRating = currentRating.getNextRating();
    }

        return currentRating;
    }

    public void sortHighestRatingScore(T newEntry){        
       boolean verify = false;
       RatingData newRatingData = new RatingData(newEntry, null);
       
       CustomerRating newRating = (CustomerRating) newEntry;
       RatingData currentRating = firstRating;
       
       if(isRatingEmpty()){
           firstRating = newRatingData;
           lastRating = newRatingData;
           verify = true;
       }
       while(!verify && currentRating != null){
           CustomerRating currRating = (CustomerRating)currentRating.ratingData;
           if(newRating.getRatingScore()  < currRating.getRatingScore()){
               if(currentRating.nextRating == null){
                   currentRating.nextRating = newRatingData;
                   lastRating = newRatingData;
                   verify = true;
               
               }else if(((CustomerRating)currentRating.nextRating.ratingData).getRatingScore() < newRating.getRatingScore()){
                   newRatingData.nextRating = currentRating.nextRating;
                   currentRating.nextRating = newRatingData;
                   verify = true;
           }else{
                   currentRating = currentRating.nextRating;
               }
           }else{
               newRatingData.nextRating = currentRating;
               lastRating = currentRating;
               firstRating = newRatingData;
               verify = true;
           }
       }
       numberRatingOfEntries++;
    }
    
    public void sortLowestRatingScore(T newEntry){        
       boolean verify = false;
       RatingData newRatingData = new RatingData(newEntry, null);
       
       CustomerRating newRating = (CustomerRating) newEntry;
       RatingData currentRating = firstRating;
       
       if(isRatingEmpty()){
           firstRating = newRatingData;
           lastRating = newRatingData;
           verify = true;
       }
       while(!verify && currentRating != null){
           CustomerRating currRating = (CustomerRating)currentRating.ratingData;
           if(newRating.getRatingScore()  > currRating.getRatingScore()){
               if(currentRating.nextRating == null){
                   currentRating.nextRating = newRatingData;
                   lastRating = newRatingData;
                   verify = true;
               
               }else if(((CustomerRating)currentRating.nextRating.ratingData).getRatingScore() > newRating.getRatingScore()){
                   newRatingData.nextRating = currentRating.nextRating;
                   currentRating.nextRating = newRatingData;
                   verify = true;
           }else{
                   currentRating = currentRating.nextRating;
               }
           }else{
               newRatingData.nextRating = currentRating;
               lastRating = currentRating;
               firstRating = newRatingData;
               verify = true;
           }
       }
       numberRatingOfEntries++;
    }
    
    
     public String toString() {
    String outputStr = "";
    RatingData<T> currentRating = firstRating;
    while (currentRating != null) {
      outputStr += currentRating.getRatingData() + "\n";;
      currentRating = currentRating.getNextRating();
    }
    return outputStr;
  }   
    
    private class RatingData<T> {

    private T ratingData;
    private RatingData nextRating;

    private RatingData(T ratingData) {
      this.ratingData = ratingData;
      this.nextRating = null;
    }

    private RatingData(T ratingData, RatingData nextRating) {
      this.ratingData = ratingData;
      this.nextRating = nextRating;
    }
     public void setRatingData(T ratingData) {
        this.ratingData = ratingData;
    }

     public void setNextRating(RatingData nextRating) {
        this.nextRating = nextRating;
    }

    public T getRatingData() {
        return ratingData;
    }

     public RatingData getNextRating() {
        return nextRating;
     }
  }
    
}
