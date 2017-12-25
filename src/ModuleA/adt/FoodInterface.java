/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.entity.Food;

/**
 *
 * @author User
 */
public interface FoodInterface<T>{
        public boolean addFood(T newFood);
        public boolean addFood(int newFoodPosition, T newFood);
        public T DeleteFood(int givenFoodPosition); 
        public void clearFood();
        public boolean updateFood(int givenFoodPosition, T newFood);
        public T getFoodEntry(int givenFoodPosition);
        public int getNumberOfFood();
        public boolean isFoodEmpty();    
        public int getLength();
        public void sortHighestFoodPrice(T newEntry);
        public void sortLowestFoodPrice(T newEntry);
        public String toString();
}
