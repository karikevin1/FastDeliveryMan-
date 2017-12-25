package ModuleC.ui;

import Client.MainMenu;
import ModuleA.adt.FoodInterface;
import ModuleA.adt.FoodList;
import ModuleA.entity.Customer;
import ModuleA.entity.Food;
import ModuleA.entity.Menu;
import ModuleC.entity.Order;
import ModuleC.entity.OrderItem;
import ModuleC.entity.Payment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectMenuItem extends JPanel{
    private final JButton[] jbtFoodList;
    private JButton[] jbtDecrease;
    private JButton[] jbtIncrease;
    private JTextField[] jtfQuantity;
    private final JButton jbtOrder = new JButton("Confirm Order");
    private final JButton jbtCancel = new JButton("Cancel Order");
    private final JButton jbtReset = new JButton("Clear Cart");
    private final JPanel jpSelectFood;
    private final JPanel jpOrder = new JPanel(new BorderLayout());
    private final JPanel jpItemList = new JPanel();
    private final JPanel jpOrderAction = new JPanel();
    public OrderUI orderUI;
    public Order order = new Order();
    public FoodInterface<Food> foodList = new FoodList<>();
    
    public SelectMenuItem(Menu selectedMenu){
        foodList = selectedMenu.getFoodList(); // get food list
        jbtFoodList = new JButton[foodList.getNumberOfFood()]; // allocate the jbutton size refer to food item quantity.
        jpSelectFood = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        PassSelectedFood passSelectedFood = new PassSelectedFood();
        // show all available Item on the Frame
        for (int i = 0, loopCnt = 1; i < foodList.getNumberOfFood() ; i++, loopCnt++){
            String foodButton = String.format("%s %n%nRM %.2f", foodList.getFoodEntry(loopCnt).getFoodName(), foodList.getFoodEntry(loopCnt).getFoodPrice());
            jbtFoodList[i] = new JButton("" + foodButton); // get the food from the list to buttons
            jbtFoodList[i].addActionListener(passSelectedFood);
            jpSelectFood.add(jbtFoodList[i], gbc);
            if (gbc.gridx < 3) {
                gbc.gridx++;
            } else {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }
        
        //initialize GUI
        setLayout(new BorderLayout());
        OrderActListn orderAL = new OrderActListn();
        jbtOrder.addActionListener(orderAL);
        jbtCancel.addActionListener(orderAL);
        jbtReset.addActionListener(orderAL);
        add(jpSelectFood, BorderLayout.CENTER);
        
        jpOrderAction.add(jbtOrder);
        jpOrderAction.add(jbtCancel);
        jpOrderAction.add(jbtReset);
        jpOrder.add(jpItemList, BorderLayout.CENTER);
        jpOrder.add(jpOrderAction, BorderLayout.SOUTH);
        add(jpOrder, BorderLayout.EAST);
    }
    
    private class PassSelectedFood implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            //get the selected button to update the item list.
            for (int loopCnt = 0 ; loopCnt < jbtFoodList.length ; loopCnt++) {
                if (jbtFoodList[loopCnt] == buttonClicked){
                    order.getItemList().addItem(new OrderItem(foodList.getFoodEntry(loopCnt + 1), order));
                    break;
                }
            }
            System.out.print(order.toString());
            updateItemPanel();
        } 
    }
    
    public void updateItemPanel(){
        jbtDecrease = new JButton[order.getItemList().getNumberOfItem()];
        jbtIncrease = new JButton[order.getItemList().getNumberOfItem()];
        jtfQuantity = new JTextField[order.getItemList().getNumberOfItem()];

        createAndShowGUI();
    }
    
    private class UpdateQuantity implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            // update the quantity of the item
            for (int loopCnt = 0; loopCnt < order.getItemList().getNumberOfItem() ; loopCnt++) {
                if (jbtDecrease[loopCnt] == buttonClicked)
                    order.getItemList().subtractQuantity(order.getItemList().getItem(loopCnt + 1), 1);
                else if (jbtIncrease[loopCnt] == buttonClicked)
                    order.getItemList().addQuantity(order.getItemList().getItem(loopCnt + 1), 1);
                
                // if the quantity is 0, remove it from the list
                if (order.getItemList().getItem(loopCnt + 1).getItemQTY() == 0)
                    order.getItemList().removeItem(loopCnt + 1);
                else
                    jtfQuantity[loopCnt].setText(String.valueOf(order.getItemList().getItem(loopCnt + 1).getItemQTY()));
            }
            createAndShowGUI();
        }
    }
    
    public void createAndShowGUI() {
        UpdateQuantity updQty = new UpdateQuantity();
        jpItemList.removeAll();
        jpItemList.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(1, 1, 1, 1);
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int loopCnt = 0; loopCnt < order.getItemList().getNumberOfItem() ; loopCnt++) {
            jpItemList.add(new JLabel(order.getItemList().getItem(loopCnt + 1).getFoodItem().getFoodName()), gbc);
            gbc.gridx++;
            jbtDecrease[loopCnt] = new JButton("-");
            jbtDecrease[loopCnt].addActionListener(updQty);
            jbtIncrease[loopCnt] = new JButton("+");
            jbtIncrease[loopCnt].addActionListener(updQty);
            
            jtfQuantity[loopCnt] = new JTextField(String.valueOf(order.getItemList().getItem(loopCnt + 1).getItemQTY()));
            jtfQuantity[loopCnt].setFont(new Font("Arial", Font.BOLD, 18));
            jtfQuantity[loopCnt].setBackground(Color.white);
            jtfQuantity[loopCnt].setEditable(false);
            
            jpItemList.add(jbtDecrease[loopCnt], gbc);
            gbc.gridx++;
            jpItemList.add(jbtIncrease[loopCnt], gbc);
            gbc.gridx++;
            jpItemList.add(jtfQuantity[loopCnt], gbc);
            
            gbc.gridx = 0;
            gbc.gridy++;
        }
        jpItemList.validate();
        jpItemList.repaint();
    }
    
    public void createConfirmationBox() {
        if (order.getItemList().getNumberOfItem() == 0) { // if no food selected prompt warning message
            JOptionPane.showMessageDialog(null, "Please select at least 1 food.", "Warning", JOptionPane.ERROR_MESSAGE);
        } else {
            JDialog.setDefaultLookAndFeelDecorated(true);
            String formattedString = String.format("%3s %-20s %15s %8s%n", "No.", "FoodName", "Quantity", "Sub Total");
            double total = order.getItemList().calculateTotal();
            for (int i = 0 ; i < order.getItemList().getNumberOfItem() ; i++) {
                String orderListString = String.format("%3d %-20s %8d RM %.2f%n", (i + 1), order.getItemList().getItem(i + 1).getFoodItem().getFoodName(), order.getItemList().getItem(i + 1).getItemQTY(), order.getItemList().getItem(i + 1).getSubTotal());
                formattedString += orderListString;
            }
            formattedString += "---------------------------------------------------------\n";
            formattedString += String.format("Total: RM %.2f%n", total);
            formattedString += "---------------------------------------------------------\n";
            formattedString += "Do you want to continue?";
            int response = JOptionPane.showConfirmDialog(null, formattedString, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            switch (response) {
                case JOptionPane.NO_OPTION:
                    System.out.println("No button clicked");
                    break;
                case JOptionPane.YES_OPTION:
                    System.out.println("Yes button clicked");
                    createNewOrder();
                    break;
                case JOptionPane.CLOSED_OPTION:
                    System.out.println("JOptionPane closed");
                    break;
                default:
                    break;
            }
        }
    }
    
    public void createNewOrder() {
        String phoneNumber = JOptionPane.showInputDialog("Please provide your phone number. (xxx-xxxxxxx)");
        order.setCustomer(findCustomerByPhoneNumber(phoneNumber));
        if (order.getCustomer() == null) { // if the phone number not match with any customer's phone number
            if (phoneNumber != null) {
                JOptionPane.showMessageDialog(null, "Please enter another phone number.", "Phone Number not found", JOptionPane.ERROR_MESSAGE);
                createNewOrder();
            }
        } else {
            /* move this out */
            Object[] options = {"Cash", "Card"};
            int response = JOptionPane.showOptionDialog(null, "Please select payment method.", "Payment Method", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
            String method = null;
            switch (response) {
                case JOptionPane.YES_OPTION:
                    method = "Cash";
                    order.setPayment(new Payment(method));
                    MainMenu.ORDER_QUEUE.enqueueOrder(order);
                    JOptionPane.showMessageDialog(null, "Your order has been created. Thank you for ordering.");
                    new ShowOrderDetails(MainMenu.ORDER_QUEUE.getLastOrder());
                    OrderUI.changePanel(new OrderUIType());
                    break;
                case JOptionPane.NO_OPTION:
                    method = "Card";
                    String cardNumber = JOptionPane.showInputDialog("Please provide your card number.");
                    if (cardNumber != null) {
                        order.setPayment(new Payment(method));
                        MainMenu.ORDER_QUEUE.enqueueOrder(order);
                        JOptionPane.showMessageDialog(null, "Your order has been created. Thank you for ordering.");
                        new ShowOrderDetails(MainMenu.ORDER_QUEUE.getLastOrder());
                        OrderUI.changePanel(new OrderUIType());
                    }
                    break;
                default:
                    break;
            }
            
            
            /* this end */
        }
    }
    
    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = null;
        
        for (int loopCnt = 1 ; loopCnt <= MainMenu.CUSTOMER_LIST.getNumberOfCust(); loopCnt++) {
            customer = MainMenu.CUSTOMER_LIST.getCustEntry(loopCnt); // retrieve the customer from the list
            if (customer.getCustTelNo().equals(phoneNumber))
                break;
            else
                customer = null;
        }
        
        return customer;
    }
    
    private class OrderActListn implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            
            if (src.equals(jbtOrder)){
                System.out.println("Order button clicked");
                createConfirmationBox();
            }else if (src.equals(jbtReset)){
                System.out.println("Clear Cart button clicked");
                order.getItemList().clearItem();
                updateItemPanel();
            }else if (src.equals(jbtCancel)){
                System.out.println("Cancel Order button clicked");
                order.getItemList().clearItem();
                OrderUI.changePanel(new SelectRestaurant());
            }
        }
    }
}
