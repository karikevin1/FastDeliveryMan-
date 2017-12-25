/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.entity.Restaurant;
/**
 *
 * @author User
 */
public class RestaurantList<T> implements RestaurantInterface<T> {
    private RestaurantData firstRest;
    private RestaurantData lastRest;
    private int numberRestOfEntries;
    
    public RestaurantList(){
        clearRestaurant();
    }

    @Override
    public boolean addRestaurant(T newRestaurant) {
        RestaurantData<T> newRestData = new RestaurantData<>(newRestaurant);
        
        if (isRestaurantEmpty()) {
         firstRest = newRestData;
        } else {
        RestaurantData<T> lastRest = getRestAt(numberRestOfEntries);
        lastRest.setNextRestaurant(newRestData);
    }

    numberRestOfEntries++;
    return true;
    }

    @Override
    public final void clearRestaurant() {
        firstRest = null;
        lastRest = null;
        numberRestOfEntries = 0;
    }

    @Override
    public T getRestaurantEntry(int givenRestaurantPosition) {
        T result = null;

    if ((givenRestaurantPosition >= 1) && (givenRestaurantPosition <= numberRestOfEntries)) {
      result = getRestAt(givenRestaurantPosition).getRestaurantData();
    }

    return result;
    }

    @Override
    public int getNumberOfRestaurant() {
        return numberRestOfEntries;
    }

    @Override
    public boolean isRestaurantEmpty() {
       boolean result;

    if (numberRestOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
    }
    
    private RestaurantData<T> getRestAt(int givenRestaurantPosition) {
        RestaurantData<T> currentRest = firstRest;

    for (int counter = 1; counter < givenRestaurantPosition; counter++) {
        currentRest = currentRest.getNextRestaurant();
    }

        return currentRest;
    }
    
    private class RestaurantData<T> {

    private T restaurantData;
    private RestaurantData nextRestaurant;

    private RestaurantData(T restaurantData) {
      this.restaurantData = restaurantData;
      this.nextRestaurant = null;
    }

    private RestaurantData(T restaurantData, RestaurantData nextRestaurant) {
      this.restaurantData = restaurantData;
      this.nextRestaurant = nextRestaurant;
    }
     public void setRestaurantData(T restaurantData) {
        this.restaurantData = restaurantData;
    }

     public void setNextRestaurant(RestaurantData nextRestaurant) {
        this.nextRestaurant = nextRestaurant;
    }

    public T getRestaurantData() {
        return restaurantData;
    }

     public RestaurantData getNextRestaurant() {
        return nextRestaurant;
     }
  }
    
    

    
}


