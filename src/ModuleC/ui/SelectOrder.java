/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.ui;

import ModuleA.entity.Customer;
import ModuleB.entity.DeliveryMan;
import ModuleC.adt.OrderInterface;
import ModuleC.adt.OrderQueue;
import ModuleC.entity.Order;
import static ModuleC.ui.OrderUI.CUSTOMER_LIST;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Sing Keat
 */
public class SelectOrder extends JPanel{
    private final JPanel jplPhoneNumber = new JPanel(new GridLayout(0, 2));
    private final JPanel jplOrderList = new JPanel();
    private final JLabel jlbPhoneNum = new JLabel("Customer Phone Number: ", SwingConstants.RIGHT);
    private final JTextField jtfPhoneNum = new JTextField();
    private final JButton jbtRetrieveOrder = new JButton("Retrieve Order");
    private final JButton jbtBack = new JButton("Back");
    private OrderInterface<Order> orderList = new OrderQueue<>();
    
    public SelectOrder() {
        RetrieveOrderActList retrieveOrderAct = new RetrieveOrderActList();
        
        jbtRetrieveOrder.addActionListener(retrieveOrderAct);
        jbtBack.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new OrderUIType());
        });
        jplPhoneNumber.add(jlbPhoneNum);
        jplPhoneNumber.add(jtfPhoneNum);
        jplPhoneNumber.add(jbtBack);
        jplPhoneNumber.add(jbtRetrieveOrder);
        setLayout(new BorderLayout());
        add(jplPhoneNumber, BorderLayout.NORTH);
        add(jplOrderList, BorderLayout.CENTER);
    }
    
    public void initOrderListPanel() {
        jplOrderList.removeAll();
        
        for (int loopCnt = 1 ; loopCnt <= orderList.getNumberOfOrder() ; loopCnt++) {
            System.out.println(orderList.getOrder(loopCnt).getOrderID());
            System.out.println(orderList.getNumberOfOrder());
            jplOrderList.add(orderListFactory(orderList.getOrder(loopCnt).getOrderID()));
            jplOrderList.add(viewButtonFactory(orderList.getOrder(loopCnt)));
        }
        jplOrderList.validate();
        jplOrderList.repaint();
    }
    
    public JLabel orderListFactory(Object orderDetail) {
        return new JLabel(orderDetail.toString());
    }
    
    public JButton viewButtonFactory(Order order) {
        JButton jbtView = new JButton("Select");
        jbtView.addActionListener((ActionEvent e) -> {
            new ShowOrderDetails(order);
        });
        return jbtView;
    }
    
    private class RetrieveOrderActList implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Customer customer = CUSTOMER_LIST.getCustByPhoneNum(jtfPhoneNum.getText());
                
                orderList = OrderUI.ORDER_QUEUE.getOrder(customer, new DeliveryMan("LimKH",1629,"0162903850", "no2, jln6", "Male", "970629-14-5571",2000.00,2,15,12,20));
                
                initOrderListPanel();
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Please enter another phone number.", "Phone Number not found", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
