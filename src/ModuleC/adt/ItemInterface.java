/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

/**
 *
 * @author Sing Keat
 */
public interface ItemInterface<T> {
    public boolean addItem(T newItem);
    public T removeItem(int givenPosition);
    public T removeItem(T item);
    public void clearItem();
    public boolean replaceItem(int givenPosition, T newItem);
    public T getItem(int givenPosition);
    public boolean checkItemExistency(T selectedItem);
    public int getItemPosition(T item);
//    public boolean containsItem(T newItem);
    public int getNumberOfItem();
    public boolean isEmpty();
    public int subtractQuantity(T item, int value);
    public int addQuantity(T item, int value);
    public double updateSubTotal(T item);
    public double calculateTotal();
}
