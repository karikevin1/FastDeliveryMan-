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
public interface RestaurantInterface<T> {
        public boolean addRestaurant(T newRestaurant);
        public void clearRestaurant();
        public T getRestaurantEntry(int givenRestaurantPosition);
        public int getNumberOfRestaurant();
        public boolean isRestaurantEmpty(); 
        public String toString();
}
