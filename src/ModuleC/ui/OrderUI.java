package ModuleC.ui;

import Client.MainMenu;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderUI extends JFrame{
    private final static JPanel JP_CONTENT = new JPanel();
    
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
    private final JButton jbtReport = new JButton("View Monthy Report");
    private final JPanel jplButtons = new JPanel(new FlowLayout());
    
    public OrderUIType() {
        jbtOrder.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new SelectRestaurant());
        });
        jbtViewOrder.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new SelectOrder());
        });
        jbtReport.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new GenerateReport());
        });
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        
       if (MainMenu.user.getType().equalsIgnoreCase("customer"))
            jplButtons.add(jbtOrder);
        else if (MainMenu.user.getType().equalsIgnoreCase("manager"))
            jplButtons.add(jbtReport);
        else if (MainMenu.user.getType().equalsIgnoreCase("deliveryman"))
            jplButtons.add(jbtViewOrder);
        
        add(jlbWelcomeBanner);
        add(jplButtons);
    }
}