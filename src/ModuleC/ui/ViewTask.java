/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleC.ui;

import Client.MainMenu;
import ModuleC.adt.OrderInterface;
import ModuleC.adt.OrderQueue;
import ModuleC.entity.Order;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Sing Keat
 */
public class ViewTask extends JPanel {
    private final JPanel jplPhoneNumber = new JPanel(new GridLayout(0, 2));
    private final JPanel jplOrderList = new JPanel();
    private final JLabel jlbStaffID = new JLabel("Staff ID: ", SwingConstants.RIGHT);
    private final JLabel jlbSortByPrice = new JLabel("Sort orders by total price: ", SwingConstants.RIGHT);
    private final JButton jbtSortByPrice = new JButton("Highest Price");
    private final JButton jbtRetrieveOrder = new JButton("Retrieve Order by Order Time");
    private final JButton jbtBack = new JButton("Back");
    private final String[] deliveryManIDArr;
    private final JComboBox jcbID;
    private OrderInterface<Order> orderList = new OrderQueue<>();
    
    public ViewTask() {
        deliveryManIDArr = new String[MainMenu.DELIVERYPROFILE_LIST.getNumberOfEntries()];
        
        for (int i = 0 ; i < MainMenu.DELIVERYPROFILE_LIST.getNumberOfEntries() ; i++) {
            deliveryManIDArr[i] = String.valueOf(MainMenu.DELIVERYPROFILE_LIST.getPositionProfile(i + 1).getStaffID());
        }
        
        jcbID = new JComboBox(deliveryManIDArr);
        
        jbtRetrieveOrder.addActionListener((ActionEvent e) -> {
            retrieveOrderAct();
            initOrderListPanel();
        });
        jbtBack.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new OrderUIType());
        });
        jbtSortByPrice.addActionListener((ActionEvent e) -> {
            retrieveOrderAct();
            orderList.sortByTotalPrice();
            initOrderListPanel();
        });
        
        jplPhoneNumber.add(jlbStaffID);
        jplPhoneNumber.add(jcbID);
        jplPhoneNumber.add(jbtBack);
        jplPhoneNumber.add(jbtRetrieveOrder);
        jplPhoneNumber.add(jlbSortByPrice);
        jplPhoneNumber.add(jbtSortByPrice);
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
    
    public void retrieveOrderAct() {
      try {
            int staffID = Integer.valueOf(jcbID.getSelectedItem().toString());
            orderList = MainMenu.ORDER_QUEUE.getOrder(MainMenu.DELIVERYPROFILE_LIST.getSelectedProfile(staffID));

            System.out.println();

      } catch (Exception ex) {
          JOptionPane.showMessageDialog(null, "Please enter another phone number.", "Phone Number not found", JOptionPane.ERROR_MESSAGE);
      }
    }
}
