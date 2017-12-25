/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.adt;

import ModuleC.entity.OrderItem;

/**
 *
 * @author Sing Keat
 */
public class ItemList<T> implements ItemInterface<T> {
    private Node<T> firstItem;
    private int numberOfItem;
    
    public ItemList() {
        clearItem();
    }
    
    @Override
    public void clearItem() {
        firstItem = null;
        numberOfItem = 0;
    }
    
    @Override
    public boolean addItem(T newItem) { // add at the back
        Node<T> newItemLink = new Node(newItem);	// create the new node

        if (isEmpty()) { // if empty list
            firstItem = newItemLink;
            numberOfItem++;
//            System.out.println("new");
        } else { // add to end of nonempty list
//                System.out.println("non empty");
            if (!checkItemExistency(newItem)) {
                Node<T> lastItemLink = getNodeAt(getNumberOfItem());
                lastItemLink.setNext(newItemLink);
                numberOfItem++;
//                System.out.println("add");
            } else {
                removeItem(newItem);
//                System.out.println("remove");
            }
        }
        
        updateSubTotal(newItem);
        return true;
    }
    
    @Override
    public T removeItem(int givenPosition) {
        T result = null;                 // return value

        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            if (givenPosition == 1) {      // case 1: remove first entry
                result = firstItem.getData();     // save entry to be removed
                firstItem = firstItem.getNext();
            } else {                         // case 2: givenPosition > 1
                Node<T> nodeBefore = getNodeAt(givenPosition - 1);
                Node<T> nodeToRemove = nodeBefore.getNext();
                Node<T> nodeAfter = nodeToRemove.getNext(); // nodeBefore.next.next
                nodeBefore.setNext(nodeAfter);
                result = nodeToRemove.getData();  // save entry to be removed
            } // one to be deleted (to disconnect node from chain)

            numberOfItem--;
        }

        return result; // return removed entry, or null
    }
    
    @Override
    public T removeItem(T item) {
        T result = null; // return value

        if (!isEmpty()) {
            int position = getItemPosition(item);
            if ((position >= 1) && (position <= getNumberOfItem())) {
                if (position == 1) {      // case 1: remove first entry
                    result = firstItem.getData();     // save entry to be removed
                    firstItem = firstItem.getNext();
                } else {                         // case 2: givenPosition > 1
                    Node<T> nodeBefore = getNodeAt(position - 1);
                    Node<T> nodeToRemove = nodeBefore.getNext();
                    Node<T> nodeAfter = nodeToRemove.getNext(); // nodeBefore.next.next
                    nodeBefore.setNext(nodeAfter);
                    result = nodeToRemove.getData();  // save entry to be removed
                } // one to be deleted (to disconnect node from chain)

                numberOfItem--;
            }
        }
        
        return result; // return removed entry, or null
    }

    @Override
    public boolean replaceItem(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            Node<T> desiredNode = getNodeAt(givenPosition);
            desiredNode.setData(newEntry);
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    @Override
    public T getItem(int givenPosition) {
        T result = null;
        
        if ((givenPosition >= 1) && (givenPosition <= getNumberOfItem())) {
            result = getNodeAt(givenPosition).getData();
        }

        return result;
    }

//    @Override
//    public boolean containsItem(T anEntry) {
//        boolean found = false;
//        Node<T> currentItem = firstItem;
//
//        while (!found && (currentItem != null)) {
//            if (anEntry.equals(currentItem.getData())) {
//                found = true; // break
//            } else {
//                currentItem = currentItem.getNext();
//            }
//        }
//
//        return found;
//    }

    @Override
    public boolean checkItemExistency(T selectedItem) {
        Node currentItem = firstItem;
        OrderItem orderItem;
        OrderItem selectedFood = (OrderItem)selectedItem;
        boolean result = false;
        for (int counter = 0; counter < getNumberOfItem(); counter++) {
            orderItem = (OrderItem)currentItem.getData();

            if (orderItem.getFoodItem().getFoodID() == selectedFood.getFoodItem().getFoodID()) {
                return true;
            }
            
            currentItem = currentItem.getNext();
        }
        
        return result;
    }
    
    @Override
    public int getItemPosition(T item) {
        Node currentItem = firstItem;
        OrderItem orderItem;
        OrderItem selectedItem = (OrderItem)item;
        for (int i = 0 ; i < getNumberOfItem(); i++) {
            orderItem = (OrderItem)currentItem.getData();
            if (orderItem.getFoodItem().getFoodID() == selectedItem.getFoodItem().getFoodID()) {
                return i + 1;
            }
            currentItem = currentItem.getNext();
        }
        
        return 0;
    }
    
    @Override
    public int getNumberOfItem() {
        return numberOfItem;
    }

    @Override
    public boolean isEmpty() {
        boolean result;

        result = getNumberOfItem() == 0;

        return result;
    }

    private Node<T> getNodeAt(int givenPosition) {
        Node<T> currentItem = firstItem;

        // traverse the list to locate the desired node
        for (int counter = 1; counter < givenPosition; counter++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }
    
    @Override
    public int subtractQuantity(T item, int value) {
        OrderItem orderItem = (OrderItem)item;
        int quantity = orderItem.getItemQTY() - value;
        orderItem.setItemQTY(quantity);
        updateSubTotal(item);
        
        return quantity;
    }
    
    @Override
    public int addQuantity(T item, int value) {
        OrderItem orderItem = (OrderItem)item;
        int quantity = orderItem.getItemQTY() + value;
        orderItem.setItemQTY(quantity);
        updateSubTotal(item);
        return quantity;
    }
    
    @Override
    public double updateSubTotal(T item) {
        OrderItem orderItem = (OrderItem)item;
        double subTotal = orderItem.getItemQTY() * orderItem.getFoodItem().getFoodPrice();
        orderItem.setSubTotal(subTotal);
        
        return subTotal;
    }
    
    @Override
    public double calculateTotal() {
        double total = 0;
        
        if (!isEmpty()) {
            Node<T> currentItem = firstItem;
            return calculateTotal(total, currentItem);
        }
        
        return total;
    }
    
    private double calculateTotal(double total, Node<T> currentItem) {
        
        if (currentItem.getNext() != null) {
            total += calculateTotal(total, currentItem.getNext());
        }
        
        return total + updateSubTotal(currentItem.getData());
    }

    @Override
    public String toString() {
        String outputStr = "";
        Node<T> currentItem = firstItem;
        while (currentItem != null) {
            outputStr += currentItem.getData() + "\n";
            currentItem = currentItem.getNext();
        }
        return outputStr;
    }

}
