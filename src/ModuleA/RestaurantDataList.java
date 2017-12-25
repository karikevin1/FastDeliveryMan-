/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import ModuleA.adt.RestaurantInterface;
import ModuleA.adt.RestaurantList;
import ModuleA.entity.Restaurant;

/**
 *
 * @author User
 */
public class RestaurantDataList {
    
    public RestaurantDataList(){
        restaurantList();
    }
    
    RestaurantInterface<Restaurant> restList = new RestaurantList<>();
    
    public void restaurantList(){
        restList.addRestaurant(new Restaurant("KFC", "Jln Ampang", "012-3456789"));
        restList.addRestaurant(new Restaurant("McD", "Jln Gombak", "013-4567890"));
        restList.addRestaurant(new Restaurant("Pizza Hut", "Jln Setapak", "014-5678901"));
        restList.addRestaurant(new Restaurant("Texas Chicken", "Jln Kepong", "015-6789012"));
        restList.addRestaurant(new Restaurant("Domino Pizza", "Jln Selayang", "016-7890123"));
    }
}

    

