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
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sing Keat
 */
public class GenerateReport extends JPanel {
    private final JPanel jplReportConstraint = new JPanel(new GridLayout(0, 2));
    private final JPanel jplOutput = new JPanel(new GridLayout(0, 5));
    private final JLabel jlbMonth = new JLabel("Select a month");
    private final String[] monthArr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private final JComboBox jcbMonth = new JComboBox(monthArr);
    private final JButton jbtGenerateReport = new JButton("Generate Report");
    private OrderInterface<Order> orderList = new OrderQueue<>();
    
    public GenerateReport() {
        initGUIComponents();
    }
    
    public void initGUIComponents() {
        jcbMonth.setSelectedIndex(0);
        
        jbtGenerateReport.addActionListener((ActionEvent e) -> {
            Date orderMonth = null;
            
            for (String monthStr : monthArr) {
                if (jcbMonth.getSelectedItem().toString().equals(monthStr)) {
                    try {
                        orderMonth = new SimpleDateFormat("MMMMM").parse(monthStr);
                    } catch (ParseException ex) {
                        Logger.getLogger(GenerateReport.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            orderList = MainMenu.ORDER_QUEUE.getOrder(orderMonth);
            generateReport();
        });
        
        setLayout(new BorderLayout());
        jplReportConstraint.add(jlbMonth);
        jplReportConstraint.add(jcbMonth);
        jplReportConstraint.add(new JLabel());
        jplReportConstraint.add(jbtGenerateReport);
        
        add(jplReportConstraint, BorderLayout.NORTH);
        add(jplOutput, BorderLayout.CENTER);
    }
    
    public void generateReport() {
        String formattedReport = "Monthy Order Report: " + jcbMonth.getSelectedItem().toString() + "\n";
        System.out.println(formattedReport);
        jplOutput.removeAll();
        jplOutput.add(generatorLabel("Monthy Order Report: "));
        jplOutput.add(generatorLabel(jcbMonth.getSelectedItem().toString()));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        
        jplOutput.add(generatorLabel("Total Number of Order"));
        jplOutput.add(generatorLabel("Total Number of Food Ordered"));
        jplOutput.add(generatorLabel("Average Number of Food Ordered"));
        jplOutput.add(generatorLabel("Total Price of Order (RM)"));
        jplOutput.add(generatorLabel("Average Price of Order (RN)"));
        
        int totalOrder = orderList.getNumberOfOrder(), totalOrderItem = 0, avgOrderItem = 0;
        double totalPrice = 0, avgPrice = 0;
        
        for (int i = 1 ; i <= totalOrder ; i++) {
            Order tempOrder = orderList.getOrder(i);
            totalOrderItem += tempOrder.getItemList().getNumberOfItem();
            totalPrice += tempOrder.getPayment().getTotalAmount();
        }
        
        if (totalOrder != 0) {
            avgOrderItem = totalOrderItem / totalOrder;
            avgPrice = totalPrice / totalOrder;
        }
            
        jplOutput.add(generatorTextField(String.valueOf(totalOrder)));
        jplOutput.add(generatorTextField(String.valueOf(totalOrderItem)));
        jplOutput.add(generatorTextField(String.valueOf(avgOrderItem)));
        jplOutput.add(generatorTextField(String.valueOf(totalPrice)));
        jplOutput.add(generatorTextField(String.valueOf(avgPrice)));
        
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        jplOutput.add(generatorLabel(""));
        
        
        add(jplReportConstraint, BorderLayout.NORTH);
        add(jplOutput, BorderLayout.CENTER);
        validate();
        repaint();
    }
    
    private JLabel generatorLabel(String label) {
        JLabel jlb = new JLabel(label);
        jlb.setFont(new Font("Arial", Font.BOLD, 12));
        return jlb;
    }
    
    private JTextField generatorTextField(String text) {
        JTextField jtfText = new JTextField(text);
        jtfText.setEnabled(true);
        jtfText.setBackground(Color.white);
        jtfText.setEditable(false);
        return jtfText;
    }
}
