/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.entity.Customer;
/**
 *
 * @author User
 */
public interface CustomerInterface<T> {
        public boolean addCust(T newCust);
        public boolean addCust(int newCustPosition, T newCust);
        public T DeleteCust(int givenCustPosition); 
        public void clearCust();
        public boolean updateCust(int givenCustPosition, T newCust);
        public T getCustEntry(int givenCustPosition);
        public int getNumberOfCust();
        public boolean isCustEmpty(); 
        public T getCustByPhoneNum(String phoneNum);
        public String toString();


}
