/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

import ModuleA.entity.Customer;
import ModuleB.entity.DeliveryMan;
import ModuleC.entity.Order;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
        order.getPayment().setPaymentDate(new Date());
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
    
    @Override
    public T getOrder(T order) {
        T result = null;
        Node<T> currentOrder = firstOrder;
        
        for (int counter = 0; counter < getNumberOfOrder(); counter++) {
            if (((Order)currentOrder.getData()).getOrderID() == ((Order)order).getOrderID()) {
                result = (T)order;
                break;
            } else
                currentOrder = currentOrder.getNext();
        }
        return result;
    }
    
    @Override
    public OrderInterface<T> getOrder(Date orderMonth) {
        Node<T> currentOrder = firstOrder;
        OrderInterface<Order> orderList = new OrderQueue<>();
        Order order;
        DateFormat dateFormat = new SimpleDateFormat("MM");
        if (!isEmpty()) {
            for (int counter = 0; counter < getNumberOfOrder(); counter++) {
                order = (Order)currentOrder.getData();
                
                if (dateFormat.format(order.getPayment().getPaymentDate()).equals(dateFormat.format(orderMonth)))
                    orderList.enqueueOrder(order);
                
                currentOrder = currentOrder.getNext();
            }
        }
        
        
        return (OrderInterface<T>)orderList;
    }
    
    @Override
    public OrderInterface<T> getOrder(Customer customer, DeliveryMan deliveryMan) {
        Node<T> currentOrder = firstOrder;
        OrderInterface<Order> orderList = new OrderQueue<>();
        Order order;
        if (!isEmpty()) {
            for (int counter = 0; counter < getNumberOfOrder(); counter++) {
                order = (Order)currentOrder.getData();
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
    
    @Override
    public void displayChain() {
        System.out.println("Chain start");
        Node<T> currentNode = firstOrder;
        for (int i = 0 ; i < numberOfOrder ; i++) {
            System.out.println(currentNode.getData().toString());
            currentNode = currentNode.getNext();
        }
        System.out.println("Chain end");
    }

    @Override
    public void sortByTotalPrice() {
        quickSort();
    }
    
    /* Quicksort part start */
    private void quickSort() {
        firstOrder = quickSort(firstOrder, lastOrder);
    }
  
    private Node<T> quickSort(Node<T> first, Node<T> last) {
        /* Base condition */
        if (first == last || first == null || first.getNext() == null)
            return first;
        
        /* Partition the list */
        // PartitionResult contain left first node, left last node, pivot, right first node, right last node
        PartitionResult partitionResult = partition(first, last);
        Node<T> leftFirst = partitionResult.leftFirst;
        Node<T> leftLast = partitionResult.leftLast;
        Node<T> pivot = partitionResult.pivot;
        Node<T> rightFirst = partitionResult.rightFirst;
        Node<T> rightLast = partitionResult.rightLast;
        
        /* Recur left part */
        Node<T> resultLeft = null;
        if (null != leftFirst)
            resultLeft = quickSort(leftFirst, leftLast);
        
        /* Recur right part */
        Node<T> resultRight = null;
        if (null != rightFirst)
            resultRight = quickSort(rightFirst, rightLast);
        
        /* Link pivot with the right first node */
        if (resultRight != null)
            pivot.setNext(resultRight);
        
        /* Return first node */
        if (null == resultLeft) {
            // If left part has nothing, return pivot. (Pivot is the first node)
            return pivot;
        } else {
            // Else return the first node of the left part
            firstOrder = resultLeft;
            lastOrder = rightLast;
            leftFirst.setNext(pivot);
            return resultLeft;
        }
    }
    
    private PartitionResult partition(Node<T> first, Node<T> last) {
        Node<T> pivot = last;
        Node<T> tailNode = last;
        Node<T> currentNode = first;
        Node<T> previousNode = null;
        Node<T> newFirst = null;
        
        while (currentNode != pivot && currentNode != null){
            Node<T> nextNode = currentNode.getNext();
            Order currentOrder = (Order)currentNode.getData();
            Order pivotOrder = (Order)pivot.getData();
            
            /* Compare the total amount of the orders. */
            if (currentOrder.getPayment().getTotalAmount() < pivotOrder.getPayment().getTotalAmount()) {
                if (null != previousNode) {
                    previousNode.setNext(currentNode.getNext());
                }
                currentNode.setNext(null);
                tailNode.setNext(currentNode);
                tailNode = currentNode;
            } else {
                if (newFirst == null)
                    newFirst = currentNode;
                if (previousNode != null)
                    previousNode.setNext(currentNode);
                previousNode = currentNode;
            }
            
            currentNode = nextNode;
        }
        
        PartitionResult partitionResult = new PartitionResult();
        partitionResult.rightLast = tailNode;
        partitionResult.rightFirst = pivot.getNext();
        partitionResult.pivot = pivot;
        partitionResult.leftLast = previousNode;
        partitionResult.leftFirst = newFirst;
        
        return partitionResult;
    }
    
    class PartitionResult<T> {
        public Node<T> leftFirst;
        public Node<T> leftLast;
        public Node<T> pivot;
        public Node<T> rightFirst;
        public Node<T> rightLast;
    }
    
    /* Quicksort part end */
}
