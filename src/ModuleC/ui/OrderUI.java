package ModuleC.ui;

import ModuleA.adt.AffiliatesInterface;
import ModuleA.adt.AffiliatesList;
import ModuleA.adt.CustomerInterface;
import ModuleA.adt.CustomerList;
import ModuleA.entity.Customer;
import ModuleA.entity.Food;
import ModuleA.entity.Menu;
import ModuleA.entity.Restaurant;
import ModuleC.adt.ItemInterface;
import ModuleC.adt.ItemList;
import ModuleC.adt.OrderInterface;
import ModuleC.adt.OrderQueue;
import ModuleC.entity.Order;
import ModuleC.entity.OrderItem;
import ModuleC.entity.Payment;
import ModuleD.Client;
import ModuleD.adt.ScheduleInterface;
import ModuleD.entity.Schedule;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderUI extends JFrame{
    private final static JPanel JP_CONTENT = new JPanel();
    final static public OrderInterface<Order> ORDER_QUEUE = new OrderQueue<>();
    final static public AffiliatesInterface<Restaurant> RESTAURANT_LIST = new AffiliatesList<>();
    final static public CustomerInterface<Customer> CUSTOMER_LIST = new CustomerList<>();
    
    public OrderUI() {
        setTitle("Order");
        setSize(1000, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        JP_CONTENT.setLayout(new BoxLayout(JP_CONTENT, BoxLayout.Y_AXIS));
        add(JP_CONTENT);
        changePanel(new OrderUIType());
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        RESTAURANT_LIST.addAffiliates(new Restaurant("McD", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("KFC", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("Pizza Hut", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("Domino Pizza", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant5", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant6", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant7", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant8", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant9", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.addAffiliates(new Restaurant("restaurant10", "jalan ampang", "0342563124"));
        RESTAURANT_LIST.getAffiliatesEntry(1).setMenu(new Menu(1, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).setMenu(new Menu(2, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).setMenu(new Menu(3, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).setMenu(new Menu(4, "X'mas", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).setMenu(new Menu(5, "Lunar New Year", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).setMenu(new Menu(6, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).setMenu(new Menu(7, "X'mas", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).setMenu(new Menu(8, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).setMenu(new Menu(9, "Chinese New Year", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(4).setMenu(new Menu(10, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(4).setMenu(new Menu(11, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(4).setMenu(new Menu(12, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(5).setMenu(new Menu(13, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(5).setMenu(new Menu(14, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(5).setMenu(new Menu(15, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(6).setMenu(new Menu(16, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(6).setMenu(new Menu(17, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(6).setMenu(new Menu(18, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(7).setMenu(new Menu(19, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(7).setMenu(new Menu(20, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(7).setMenu(new Menu(21, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(8).setMenu(new Menu(22, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(8).setMenu(new Menu(23, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(8).setMenu(new Menu(24, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(9).setMenu(new Menu(25, "X'mas", "available", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(9).setMenu(new Menu(26, "Lunar New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(9).setMenu(new Menu(27, "Chinese New Year", "unavailable", "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFoodList().addFood(new Food(1, "McD Chicken", 8.50, "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFoodList().addFood(new Food(2, "Ayam goreng", 8.50,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFoodList().addFood(new Food(3, "name02", 2.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFoodList().addFood(new Food(4, "name03", 3.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFoodList().addFood(new Food(5, "KFC Chizza", 12.50,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFoodList().addFood(new Food(6, "name12", 12.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFoodList().addFood(new Food(7, "name13", 13.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFoodList().addFood(new Food(8, "name14", 14.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).getMenu(3).getFoodList().addFood(new Food(9, "Pepperoni", 15.00,"promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).getMenu(3).getFoodList().addFood(new Food(10, "name22", 22.00, "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(3).getMenu(3).getFoodList().addFood(new Food(11, "name23", 23.00, "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(4).getMenu(1).getFoodList().addFood(new Food(12, "BBQ Chicken", 13.00, "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(5).getMenu(1).getFoodList().addFood(new Food(13, "name41", 41.00, "promo"));
        RESTAURANT_LIST.getAffiliatesEntry(5).getMenu(1).getFoodList().addFood(new Food(14, "name42", 42.00, "promo"));
        
        CUSTOMER_LIST.addCust(new Customer(1, "Lim Kah Him", "971234-12-1234", "011-1111111", "No1/A, jalan a, taman b, 533000 Kuala Lumpur", "kevimlim@gmail.com"));
        CUSTOMER_LIST.addCust(new Customer(2, "Lim Kah Wai", "950827-10-9431", "013-3333333", "No2/A, jalan a, taman b, 533000 Kuala Lumpur", "khlim@gmail.com"));
        CUSTOMER_LIST.addCust(new Customer(3, "Low Sing Keat", "971010-14-5050", "012-2222222", "No3/A, jalan a, taman c, 533000 Kuala Lumpur", "sklow@gmail.com"));
        CUSTOMER_LIST.addCust(new Customer(4, "Ng Wen Da", "95050-08-0202", "014-4444444", "No4/A, jalan a, taman b, 533000 Kuala Lumpur", "wdng@gmail.com"));
        
        
        ScheduleInterface<Schedule> deliveryList = new Client().getDeliList();
        
        Order order2 = new Order();
        ItemInterface<OrderItem> itemList2 = new ItemList<>();
        order2.setCustomer(CUSTOMER_LIST.getCustEntry(1));
        itemList2.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(1), 1));
        itemList2.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(2), 1));
        order2.setDelivery(deliveryList.getSchedule(0));
        order2.setItemList(itemList2);
        order2.setPayment(new Payment("Cash"));
        ORDER_QUEUE.enqueueOrder(order2);
        
        Order order = new Order();
        ItemInterface<OrderItem> itemList = new ItemList<>();
        itemList.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(1), 2));
        itemList.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(2), 5));
        itemList.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(3), 1));
        itemList.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(4), 8));
        itemList.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(1).getMenu(1).getFood(4), 8));
        order.setCustomer(CUSTOMER_LIST.getCustEntry(1));
        order.setDelivery(deliveryList.getSchedule(0));
        order.setItemList(itemList);
        order.setPayment(new Payment("Cash"));
        ORDER_QUEUE.enqueueOrder(order);
        
        
        
        Order order3 = new Order();
        ItemInterface<OrderItem> itemList3 = new ItemList<>();
        order3.setCustomer(CUSTOMER_LIST.getCustEntry(3));
        itemList3.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFood(1), 9));
        itemList3.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFood(3), 6));
        itemList3.addItem(new OrderItem(RESTAURANT_LIST.getAffiliatesEntry(2).getMenu(2).getFood(2), 1));
        order3.setDelivery(deliveryList.getSchedule(1));
        order3.setItemList(itemList3);
        order3.setPayment(new Payment("Cash"));
        ORDER_QUEUE.enqueueOrder(order3);
        
        new OrderUI();
    }
    
    //move this to main page, change the jpSelectRestaurant name
    public static void changePanel(JPanel newPanel){
        JP_CONTENT.removeAll();
        JP_CONTENT.add(newPanel);
        JP_CONTENT.validate();
        JP_CONTENT.repaint();
    }
}

class OrderUIType extends JPanel {
    private final JLabel jlbWelcomeBanner = new JLabel("Welcome to Fast Food Delivery.", SwingConstants.CENTER);
    private final JButton jbtOrder = new JButton("Create Order");
    private final JButton jbtViewOrder = new JButton("View Orders");
    private final JPanel jplButtons = new JPanel(new FlowLayout());
    
    public OrderUIType() {
        UITypeActionListnr typeAct = new UITypeActionListnr();
        jbtOrder.addActionListener(typeAct);
        jbtViewOrder.addActionListener(typeAct);
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        jplButtons.add(jbtOrder);
        jplButtons.add(jbtViewOrder);
        add(jlbWelcomeBanner);
        add(jplButtons);
    }
    
    private class UITypeActionListnr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            
            if (src.equals(jbtOrder)){
                OrderUI.changePanel(new SelectRestaurant());
            }else if (src.equals(jbtViewOrder)){
                OrderUI.changePanel(new SelectOrder());
            }
        }
    }
}