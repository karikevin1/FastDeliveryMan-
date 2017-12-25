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
public interface RatingInterface<T> {
        public boolean addRating(T newRating);
        public boolean addRating(int newRatingPosition, T newRating);
        public void clearRating();
        public T getRatingEntry(int givenRatingPosition);
        public int getNumberOfRating();
        public boolean isRatingEmpty();
        public void sortHighestRatingScore(T newEntry);  
        public void sortLowestRatingScore(T newEntry);
        public String toString();
}
