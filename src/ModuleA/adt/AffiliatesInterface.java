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
public interface AffiliatesInterface<T> {
    public boolean addAffiliates(T newAffiliates);
        public boolean addAffiliates(int newAffiliatesPosition, T newAffiliates);
        public T DeleteAffiliates(int givenAffiliatesPosition); 
        public void clearAffiliates();
        public boolean updateAffiliates(int givenAffiliatesPosition, T newAffiliates);
        public T getAffiliatesEntry(int givenAffiliatesPosition);
        public int getNumberOfAffiliates();
        public boolean isAffiliatesEmpty(); 
        public String toString();
}

