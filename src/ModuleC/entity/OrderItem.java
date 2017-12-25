package ModuleC.entity;

import ModuleA.entity.Food;

public class OrderItem {
    private Food foodItem;
    private Order orderID;
    private int itemQTY;
    private double subTotal;

    public OrderItem() {}
    
    public OrderItem(Food item) {
        this.foodItem = item;
        this.itemQTY = 1;
    }
    
    public OrderItem(Food item, int quantity) {
        this.foodItem = item;
        this.itemQTY = quantity;
    }
    
    public Food getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(Food foodItem) {
        this.foodItem = foodItem;
    }
    
    public Order getOrderID() {
        return orderID;
    }

    public void setOrderID(Order orderID) {
        this.orderID = orderID;
    }

    public int getItemQTY() {
        return itemQTY;
    }

    public void setItemQTY(int itemQTY) {
        this.itemQTY = itemQTY;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

}
