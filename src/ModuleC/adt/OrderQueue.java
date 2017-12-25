/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

import ModuleA.entity.Customer;
import ModuleB.entity.DeliveryMan;
import ModuleC.entity.Order;
import ModuleC.entity.Payment;
import java.util.Date;

/**
 *
 * @author Sing Keat
 */
public class OrderQueue<T> implements  OrderInterface<T> {
    private Node<T> firstOrder;
    private Node<T> lastOrder;
    private int numberOfOrder = 0;
    
    public OrderQueue () {
        clearQueue();
    }
    
    @Override
    public void clearQueue() {
        this.firstOrder = null;
        this.lastOrder = null;
        numberOfOrder = 0;
    }
    
    @Override
    public void enqueueOrder(T newOrder) {
        Order order = (Order)newOrder;
        order.setOrderTime(new Date());
        order.setPayment(new Payment(new Date()));
        order.getPayment().setTotalAmount(order.getItemList().calculateTotal());
        Node<T> newOrderLink = null;
        
        if (isEmpty()) {
            order.setOrderID(1);
            order.getPayment().setPaymentID(order.getOrderID());
            order.getPayment().setOrder(order);
            newOrderLink = new Node((T)order);
            firstOrder = newOrderLink;
        } else {
            order.setOrderID(((Order)lastOrder.getData()).getOrderID() + 1);
            order.getPayment().setPaymentID(order.getOrderID());
            order.getPayment().setOrder(order);
            newOrderLink = new Node((T)order);
            lastOrder.setNext(newOrderLink);
        }
        System.out.println("Enqueue");
        System.out.println(order.getOrderID());
        System.out.println(order.toString());
        lastOrder = newOrderLink;
        numberOfOrder++;
    }
    
    @Override
    public T dequeueOrder() {
        T first = null;
        
        if (!isEmpty()) {
            first = this.firstOrder.getData();
            this.firstOrder = (this.firstOrder.getNext());
            
            if (this.firstOrder == null)
                lastOrder = null;
        }
        
        numberOfOrder--;
        return first;
    }
    
    @Override
    public T getFirstOrder() {
        T first = null;
        
        if (!isEmpty())
            first = this.firstOrder.getData();
        
        return first;
    }
    
    @Override
    public T getOrder(int givenPosition) {
        T order = null;
        
        if ((givenPosition >= 1) && !isEmpty()) {
            order = getOrderAt(givenPosition).getData();
        }
        
        return order;
    }
    
    /**
     * match para order's id with each order in the queue
     * @param order
     * @return order | null, if order id not match with any order
     */
    @Override
    public T getOrder(T order) {
        T result = null;
        Node<T> currentOrder = firstOrder;
        
        for (int counter = 0; counter < getNumberOfOrder(); counter++) {
            if (((Order)currentOrder.getData()).getOrderID() == ((Order)order).getOrderID()) {
                result = (T)order;
            } else
                currentOrder = currentOrder.getNext();
        }
        return result;
    }
    
    /**
     * get the order that customer is para customer and delivery man is para deliveryMan
     * @param customer
     * @param deliveryMan
     * @return orderlist | null, if no order match
     */
    @Override
    public OrderInterface<T> getOrder(Customer customer, DeliveryMan deliveryMan) {
        Node<T> currentOrder = firstOrder;
        OrderInterface<Order> orderList = new OrderQueue<>();
        Order order;
        if (!isEmpty()) {
            for (int counter = 0; counter < getNumberOfOrder(); counter++) {
                order = (Order)currentOrder.getData();
                System.out.println("counter: " + counter);
                System.out.println("id: " + order.getOrderID());
                System.out.println(order.toString());
                if (order.getCustomer().getCustIC().equalsIgnoreCase(customer.getCustIC()) && order.getDelivery().getStaffID() == deliveryMan.getStaffID())
                    orderList.enqueueOrder(order);
                
                currentOrder = currentOrder.getNext();
            }
        }
        return (OrderInterface<T>) orderList;
    }
    
    private Node<T> getOrderAt(int givenPosition) {
        Node<T> currentOrder = firstOrder;

        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentOrder = currentOrder.getNext();
        }

        return currentOrder;
    }
    
    @Override
    public T getLastOrder() {
        T last = null;
        
        if (!isEmpty())
            last = this.lastOrder.getData();
        
        return last;
    }
    
    @Override
    public int getNumberOfOrder() {
        return this.numberOfOrder;
    }
    
    @Override
    public boolean isEmpty() {
        return (this.firstOrder == null) && (this.lastOrder == null);
    }
    
    public void displayChain() {
        System.out.println("Chain start");
        Node<T> currentNode = firstOrder;
        for (int i = 0 ; i < numberOfOrder ; i++) {
            System.out.println(currentNode.getData().toString());
            currentNode = currentNode.getNext();
        }
        System.out.println("Chain end");
    }
}
