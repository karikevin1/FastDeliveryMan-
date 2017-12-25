/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.adt.CustomerInterface;
import ModuleA.entity.Customer;
/**
 *
 * @author User
 */
public class CustomerList<T> implements CustomerInterface<T> {
    private CustData firstCust;
    private int numberCustOfEntries;
    
    public CustomerList(){
        clearCust();
    }
    
    public final void clearCust(){
        firstCust = null;
        numberCustOfEntries = 0;
    }
    
    public boolean addCust(T newCust){
        CustData<T> newCustData = new CustData<>(newCust);
        
        if (isCustEmpty()) {
         firstCust = newCustData;
        } else {
        CustData<T> lastCust = getCustAt(numberCustOfEntries);
        lastCust.setNextCust(newCustData);
    }

    numberCustOfEntries++;
    return true;
    }
    
    public boolean addCust(int newCustPosition, T newCust){
     boolean isSuccessful = true;

    if ((newCustPosition >= 1) && (newCustPosition <= numberCustOfEntries + 1)) {
      CustData<T> newCustData = new CustData<T>(newCust);

      if (isCustEmpty() || (newCustPosition == 1)) {    
        newCustData.setNextCust(firstCust);
        firstCust = newCustData;
      } else {								                  
        CustData custBefore = getCustAt(newCustPosition - 1);
        CustData custAfter = custBefore.getNextCust();
        newCustData.setNextCust(custAfter);
        custBefore.setNextCust(newCustData);
      }

      numberCustOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public boolean updateCust(int givenCustPosition, T newCust){
    boolean isSuccessful = true;

    if ((givenCustPosition >= 1) && (givenCustPosition <= numberCustOfEntries)) {
      CustData<T> desiredCust = getCustAt(givenCustPosition);
      desiredCust.setCustData(newCust);
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
    }
    
    public T getCustEntry(int givenCustPosition){
    T result = null;

    if ((givenCustPosition >= 1) && (givenCustPosition <= numberCustOfEntries)) {
      result = getCustAt(givenCustPosition).getCustData();
    }

    return result;
    }


    public int getNumberOfCust(){
        return numberCustOfEntries;
    }
    
    
    public boolean isCustEmpty() {
    boolean result;

    if (numberCustOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }
    
    /**
     * Sing Keat
     * @param phoneNum
     * @return customer | null, if not found
     * retrieve customer data by param phoneNum
     * search the customer from first node to last node
     */
    public T getCustByPhoneNum(String phoneNum) {
        T result = null;
        CustData currentCustomer = firstCust;
        Customer customer;
        
        for (int counter = 0 ; counter < getNumberOfCust() ; counter++) {
            customer = (Customer)currentCustomer.custData;
            if (customer.getCustTelNo().equalsIgnoreCase(phoneNum)){
                result = (T)customer;
                break;
            }
            else
                currentCustomer = currentCustomer.getNextCust();
        }
        
        return result;
    }

    public String toString() {
    String outputStr = "";
    CustData<T> currentCust = firstCust;
    while (currentCust != null) {
      outputStr += currentCust.getCustData() + "\n";;
      currentCust = currentCust.getNextCust();
    }
    return outputStr;
  }   
    
    private CustData<T> getCustAt(int givenCustPosition) {
        CustData<T> currentCust = firstCust;

    for (int counter = 1; counter < givenCustPosition; counter++) {
        currentCust = currentCust.getNextCust();
    }

        return currentCust;
    }
private class CustData<T> {

    private T custData;
    private CustData nextCust;

    private CustData(T custData) {
      this.custData = custData;
      this.nextCust = null;
    }

    private CustData(T cutData, CustData nextCust) {
      this.custData = custData;
      this.nextCust = nextCust;
    }
     public void setCustData(T custData) {
        this.custData = custData;
    }

     public void setNextCust(CustData nextCust) {
        this.nextCust = nextCust;
    }

    public T getCustData() {
        return custData;
    }

     public CustData getNextCust() {
        return nextCust;
     }
  }    
}
