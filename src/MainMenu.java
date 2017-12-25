
import ModuleA.ModuleAMenu;
import ModuleB.DeliveryManManagement;
import ModuleC.ui.OrderUI;
import ModuleD.ModuleDDriver;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin lim
 */
public class MainMenu extends JFrame {
    private JButton restaurant = new JButton("Restaurant&Affilates");
    private JButton profile = new JButton("DeliveryMan HR");
    private JButton order = new JButton("Order");
    private JButton schedule = new JButton("DelverySchedule");
    
       public static String username = new LoginSystem().getUsername();
     public static String password = new LoginSystem().getPassword();
     
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        LoginSystem.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        LoginSystem.password = password;
    } 
    
    public MainMenu(){
        setTitle("Fast Delivery Man");
        Font fontTitle = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        restaurant.setFont(font);
        profile.setFont(font);
        order.setFont(font);
        schedule.setFont(font);
        
        JPanel jplMenu = new JPanel(new GridLayout(0,2));
        jplMenu.add(restaurant);
        jplMenu.add(profile);
        jplMenu.add(order);
        jplMenu.add(schedule);
        add(jplMenu, BorderLayout.CENTER);
        
        RestButtonListener listener = new RestButtonListener();
        restaurant.addActionListener(listener);
        
        ProfileButtonListener listener2 = new ProfileButtonListener();
        profile.addActionListener(listener2);
        
        OrderButtonListener listener3 = new OrderButtonListener();
        order.addActionListener(listener3);
        
        ScheduleButtonListener listener4 = new ScheduleButtonListener();
        schedule.addActionListener(listener4);
    }
    
    private class RestButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    ModuleAMenu frame = new ModuleAMenu();
                    frame.getContentPane().setPreferredSize(new Dimension(650, 600));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
            }
    }
    
    private class ProfileButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    DeliveryManManagement frame = new DeliveryManManagement();
                    frame.getContentPane().setPreferredSize(new Dimension(650, 600));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
            }
    }
    
    private class OrderButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    OrderUI frame = new OrderUI();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
            }
    }
    
    private class ScheduleButtonListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                    ModuleDDriver frame = new ModuleDDriver();
                    frame.getContentPane().setPreferredSize(new Dimension(650, 600));
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
            }
    }
    
    
}
