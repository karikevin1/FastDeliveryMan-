/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

import ModuleA.entity.Customer;
import ModuleB.entity.DeliveryMan;

/**
 *
 * @author Sing Keat
 */
public interface OrderInterface<T> {
    public void enqueueOrder(T newOrder);
    public T dequeueOrder();
    public T getFirstOrder();
    public T getOrder(int givenPosition);
    public T getOrder(T order);
    public OrderInterface<T> getOrder(Customer customer, DeliveryMan deliveryMan);
    public T getLastOrder();
    public int getNumberOfOrder();
    public boolean isEmpty();
    public void clearQueue();
    //sort by order's item size
    //sort by order date
}
