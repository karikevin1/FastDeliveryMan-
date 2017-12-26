/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.ui;

import Client.MainMenu;
import ModuleA.entity.Customer;
import ModuleC.entity.Order;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Sing Keat
 */
public class ShowOrderDetails extends JFrame{
    private final JPanel jplCustomer = new JPanel(new GridLayout(0, 2));
    private final JPanel jplOrder = new JPanel();
    private final JLabel jlbCustomerName = new JLabel("Customer Name: ", SwingConstants.RIGHT);
    private final JTextField jtfCustomerName;
    private final JLabel jlbCustomerIC = new JLabel("Customer IC: ", SwingConstants.RIGHT);
    private final JTextField jtfCustomerIC;
    private final JLabel jlbCustomerEmail = new JLabel("Customer Email: ", SwingConstants.RIGHT);
    private final JTextField jtfCustomerEmail;
    private final JLabel jlbCustomerPhoneNum = new JLabel("Customer Phone Number: ", SwingConstants.RIGHT);
    private final JTextField jtfCustomerPhoneNum;
    private final JLabel jlbCustomerAddress = new JLabel("Customer Address: ", SwingConstants.RIGHT);
    private final JTextField jtfCustomerAddress;
    private final JLabel jlbTotalPrice = new JLabel("Total Price (RM): ", SwingConstants.RIGHT);
    private final JLabel jlbPrice;
    private final JLabel jlbFoodName = new JLabel("Food Name");
    private final JLabel jlbFoodQuantity = new JLabel("Quantity");
    private final JButton jbtGenerateReceipt = new JButton("Generate Receipt");
    
    public ShowOrderDetails(Order selectedOrder) {
        /* customer information */
        Customer customer = selectedOrder.getCustomer();
        
        jtfCustomerName = new JTextField(customer.getCustName());
        jtfCustomerIC = new JTextField(customer.getCustIC());
        jtfCustomerEmail = new JTextField(customer.getCustEmail());
        jtfCustomerPhoneNum = new JTextField(customer.getCustTelNo());
        jtfCustomerAddress = new JTextField(customer.getCustAddress());
        jlbPrice = new JLabel(String.valueOf(selectedOrder.getItemList().calculateTotal()));
        
        jtfCustomerName.setEditable(false);
        jtfCustomerIC.setEditable(false);
        jtfCustomerEmail.setEditable(false);
        jtfCustomerPhoneNum.setEditable(false);
        jtfCustomerAddress.setEditable(false);
        
        jplCustomer.add(jlbCustomerName);
        jplCustomer.add(jtfCustomerName);
        jplCustomer.add(jlbCustomerIC);
        jplCustomer.add(jtfCustomerIC);
        jplCustomer.add(jlbCustomerEmail);
        jplCustomer.add(jtfCustomerEmail);
        jplCustomer.add(jlbCustomerPhoneNum);
        jplCustomer.add(jtfCustomerPhoneNum);
        jplCustomer.add(jlbCustomerAddress);
        jplCustomer.add(jtfCustomerAddress);
        /* customer information end */
        
        /* order information */
        jplOrder.setLayout(new GridLayout(0, 2));
        jlbFoodName.setBorder(new MatteBorder(3, 0, 3, 0, Color.BLACK));
        jlbFoodQuantity.setBorder(new MatteBorder(3, 0, 3, 0, Color.BLACK));
        jplOrder.add(jlbFoodName);
        jplOrder.add(jlbFoodQuantity);
        for (int loopCnt = 1 ; loopCnt <= selectedOrder.getItemList().getNumberOfItem() ; loopCnt++) {
            jplOrder.add(orderDetailFactory(selectedOrder.getItemList().getItem(loopCnt).getFoodItem().getFoodName()));
            jplOrder.add(orderDetailFactory(String.valueOf(selectedOrder.getItemList().getItem(loopCnt).getItemQTY())));
        }
        
        jbtGenerateReceipt.addActionListener((ActionEvent e) -> {
            new GenerateReceipt(selectedOrder);
        });
        
        jplOrder.add(new JLabel());
        jplOrder.add(new JLabel());
        jplOrder.add(jlbTotalPrice);
        jplOrder.add(jlbPrice);
        add(jbtGenerateReceipt);
        /* order information end */
        
        setTitle("Customer Details");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLayout(new GridLayout(0, 1));
        add(jplCustomer);
        add(jplOrder);
    }
    
    private JLabel orderDetailFactory(Object orderDetails) {
        return new JLabel(orderDetails.toString());
    }
    
    public class GenerateReceipt extends JFrame{
        private final JLabel jlbCompanyName = new JLabel("Fastest Delivery Man");
        private final JPanel jplReceiptHead = new JPanel(new GridLayout(0, 2));
        
        public GenerateReceipt(Order order) {
            jplReceiptHead.add(generatorLabel("Company Name : "));
            jplReceiptHead.add(jlbCompanyName);
            jplReceiptHead.add(generatorLabel("Order Date Time : "));
            jplReceiptHead.add(generatorLabel(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(order.getOrderDate())));
            jplReceiptHead.add(generatorLabel("Restaurant Name : "));
            jplReceiptHead.add(generatorLabel(order.getRestaurant().getName()));
            jplReceiptHead.add(generatorLabel("Customer Name : "));
            jplReceiptHead.add(generatorLabel(order.getCustomer().getCustName()));
            add(jplReceiptHead);
            add(jplOrder);
            
            setLayout(new GridLayout(0, 1));
            setTitle("Order Receipt");
            setSize(400, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
        
        private JLabel generatorLabel(String label) {
            return new JLabel(label);
        }
    }
}
