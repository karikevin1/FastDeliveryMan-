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
 * @param <T>
 */
public interface OrderInterface<T> {

    /**
     *
     * @param newOrder
     */
    public void enqueueOrder(T newOrder);

    /**
     *
     * @return
     */
    public T dequeueOrder();

    /**
     *
     * @return
     */
    public T getFirstOrder();

    /**
     *
     * @param givenPosition
     * @return
     */
    public T getOrder(int givenPosition);
    
    /**
     * Task: match parameter order id with each order id in the queue
     * @param order
     * @return order | null, if order id not match with any order
     */
    public T getOrder(T order);
    
    /**
     * Task: get the order that customer is parameter customer and delivery man is parameter deliveryMan
     * @param customer
     * @param deliveryMan
     * @return order list | null, if no order match
     */
    public OrderInterface<T> getOrder(Customer customer, DeliveryMan deliveryMan);

    /**
     *
     * @return
     */
    public T getLastOrder();

    /**
     *
     * @return
     */
    public int getNumberOfOrder();

    /**
     *
     * @return true | false it not empty
     */
    public boolean isEmpty();

    /**
     * Task: clear this queue to empty queue
     */
    public void clearQueue();

    /**
     * Task: display the data node by node
     */
    public void displayChain();
    
    /**
     * Task: sort the orders by highest total price
     */
    public void sortByTotalPrice();
    
}
