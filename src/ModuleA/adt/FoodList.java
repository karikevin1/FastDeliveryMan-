/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.FoodList;
import ModuleA.entity.Restaurant;
import ModuleA.entity.Menu;
import ModuleA.entity.Food;
/**
 *
 * @author User
 */
public class FoodList<T> implements FoodInterface<T> {
    private FoodData firstFood;
    private FoodData lastFood;
    private int numberFoodOfEntries;
    
    public FoodList(){
        clearFood();
    }
    
    public final void clearFood(){
        firstFood = null;
        lastFood = null;
        numberFoodOfEntries = 0;
    }
    
    public boolean addFood(T newFood){
        FoodData<T> newFoodData = new FoodData<>(newFood);
        
        if (isFoodEmpty()) {
         firstFood = newFoodData;
        } else {
        FoodData<T> lastFood = getFoodAt(numberFoodOfEntries);
        lastFood.setNextFood(newFoodData);
    }

    numberFoodOfEntries++;
    return true;
    }
    
    public boolean addFood(int newFoodPosition, T newFood){
     boolean isSuccessful = true;

    if ((newFoodPosition >= 1) && (newFoodPosition <= numberFoodOfEntries + 1)) {
      FoodData<T> newFoodData = new FoodData<T>(newFood);

      if (isFoodEmpty() || (newFoodPosition == 1)) {    
        newFoodData.setNextFood(firstFood);
        firstFood = newFoodData;
      } else {								                     
        FoodData foodBefore = getFoodAt(newFoodPosition - 1);
        FoodData foodAfter = foodBefore.getNextFood();
        newFoodData.setNextFood(foodAfter);
        foodBefore.setNextFood(newFoodData);
      }

      numberFoodOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T DeleteFood(int givenFoodPosition){
     T result = null;

    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      if (givenFoodPosition == 1) {     
        result = (T)firstFood.getFoodData();   
        firstFood = firstFood.getNextFood();
      } else {                       
        FoodData<T> foodBefore = getFoodAt(givenFoodPosition - 1);
        FoodData<T> foodToRemove = foodBefore.getNextFood();
        FoodData<T> foodAfter = foodToRemove.getNextFood();
        foodBefore.setNextFood(foodAfter); 
        result = foodToRemove.getFoodData();  
      }

      numberFoodOfEntries--;
    }

    return result;
    }
    public boolean updateFood(int givenFoodPosition, T newFood){
    boolean isSuccessful = true;
    
    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      FoodData<T> desiredFood = getFoodAt(givenFoodPosition);
      desiredFood.setFoodData(newFood);
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T getFoodEntry(int givenFoodPosition){
    T result = null;

    if ((givenFoodPosition >= 1) && (givenFoodPosition <= numberFoodOfEntries)) {
      result = getFoodAt(givenFoodPosition).getFoodData();
    }

    return result;
    }


    public int getNumberOfFood(){
        return numberFoodOfEntries;
    }
    
    
    public boolean isFoodEmpty() {
    boolean result;

    if (numberFoodOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

    public String toString() {
    String outputStr = String.format("%-20d%-20s        %.2f %30s\n", "Food ID", "Food Name", "Price", "Description");
    FoodData<T> currentFood = firstFood;
    while (currentFood != null) {
      outputStr += currentFood.getFoodData() + "\n";;
      currentFood = currentFood.getNextFood();
    }
    return outputStr;
  }
    
    
    private FoodData<T> getFoodAt(int givenFoodPosition) {
        FoodData<T> currentFood = firstFood;

    for (int counter = 1; counter < givenFoodPosition; counter++) {
        currentFood = currentFood.getNextFood();
    }

        return currentFood;
    }

    @Override
    public int getLength() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void sortHighestFoodPrice(T newEntry){
        boolean validate = false;
        FoodData newFoodData =new FoodData(newEntry, null);
        
        Food newFood = (Food) newEntry;
        FoodData currentFood = firstFood;
        
        if(isFoodEmpty()){
            firstFood = newFoodData;
            lastFood = newFoodData;
            validate = true;
        }
        
        while(!validate&&currentFood!=null){
            Food CurrentFood = (Food) currentFood.foodData;
            if(newFood.getFoodPrice() < CurrentFood.getFoodPrice()){
                if(currentFood.nextFood==null){
                    currentFood.nextFood = newFoodData;
                    lastFood = newFoodData;
                    validate = true;
                }else if(((Food)currentFood.nextFood.foodData).getFoodPrice() < newFood.getFoodPrice()){
                    newFoodData.nextFood = currentFood.nextFood;
                    currentFood.nextFood = newFoodData;
                    validate = true;
                }else{
                    currentFood = currentFood.nextFood;
                }
            }else{
                newFoodData.nextFood = currentFood;
                lastFood = currentFood;
                firstFood = newFoodData;
                validate = true;
            }
        }
        numberFoodOfEntries++;
    }
    
    public void sortLowestFoodPrice(T newEntry){
        boolean validate = false;
        FoodData newFoodData =new FoodData(newEntry, null);
        
        Food newFood = (Food) newEntry;
        FoodData currentFood = firstFood;
        
        if(isFoodEmpty()){
            firstFood = newFoodData;
            lastFood = newFoodData;
            validate = true;
        }
        
        while(!validate&&currentFood!=null){
            Food CurrentFood = (Food) currentFood.foodData;
            if(newFood.getFoodPrice() > CurrentFood.getFoodPrice()){
                if(currentFood.nextFood==null){
                    currentFood.nextFood = newFoodData;
                    lastFood = newFoodData;
                    validate = true;
                }else if(((Food)currentFood.nextFood.foodData).getFoodPrice() > newFood.getFoodPrice()){
                    newFoodData.nextFood = currentFood.nextFood;
                    currentFood.nextFood = newFoodData;
                    validate = true;
                }else{
                    currentFood = currentFood.nextFood;
                }
            }else{
                newFoodData.nextFood = currentFood;
                lastFood = currentFood;
                firstFood = newFoodData;
                validate = true;
            }
        }
        numberFoodOfEntries++;
    }
   
         
    
private class FoodData<T> {

    private T foodData;
    private FoodData nextFood;

    private FoodData(T foodData) {
      this.foodData = foodData;
      this.nextFood = null;
    }

    private FoodData(T foodData, FoodData nextFood) {
      this.foodData = foodData;
      this.nextFood = nextFood;
    }
     public void setFoodData(T foodData) {
        this.foodData = foodData;
    }

     public void setNextFood(FoodData nextFood) {
        this.nextFood = nextFood;
    }

    public T getFoodData() {
        return foodData;
    }

     public FoodData getNextFood() {
        return nextFood;
     }
  }    
}
