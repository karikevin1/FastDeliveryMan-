/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.entity;

import java.util.Date;

/**
 *
 * @author Sing Keat
 */
public class Payment {
    private int paymentID;
    private Date paymentDate;
    private double totalAmount;
    private String method;
    private Order order;

    public Payment() {}

    public Payment(String method) {
        this.method = method;
    }

    public Payment(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Payment(int paymentID, Date paymentDate, double totalAmount, String method, Order order) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
        this.method = method;
        this.order = order;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
