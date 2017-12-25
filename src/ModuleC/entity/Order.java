package ModuleC.entity;

import ModuleC.adt.ItemInterface;
import ModuleA.entity.Customer;
import ModuleC.adt.ItemList;
import ModuleD.entity.Schedule;
import java.util.Date;

public class Order{
    private ItemInterface<OrderItem> itemList = new ItemList<>();
    private int orderID;
    private Customer customer;
    private Date orderDate;
    private Schedule delivery;
    private Payment payment;
    
    public Order() {}
    
    public Order(int orderID) {
        this.orderID = orderID;
    }

    public Order(int orderID, Customer customer, Date orderDate, Schedule delivery, Payment payment) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.delivery = delivery;
        this.payment = payment;
    }
    
    public void setItemList(ItemInterface<OrderItem> itemList) {
        this.itemList = itemList;
    }
    
    public ItemInterface<OrderItem> getItemList(){
        return itemList;
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    
    public int getOrderID() {
        return orderID;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderTime(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Schedule getDelivery() {
        return delivery;
    }

    public void setDelivery(Schedule delivery) {
        this.delivery = delivery;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    @Override
    public String toString(){
        String formatOutput = "";
        for (int i = 1 ; i <= itemList.getNumberOfItem(); i++) {
            formatOutput += i + ".\t" + itemList.getItem(i).getFoodItem().getFoodName() + "\t" + itemList.getItem(i).getItemQTY() + "\n";
        }
        return formatOutput;
    }
}