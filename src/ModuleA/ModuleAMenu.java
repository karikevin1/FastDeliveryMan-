/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import Client.MainMenu;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
/**
 *
 * @author User
 */
public class ModuleAMenu extends JFrame{
    private JLabel jblTitle = new JLabel("Module A Management");
    private JButton createAffiliates = new JButton("Create Affiliates");
    private JButton updateAffiliates = new JButton("Update Affiliates Company Type");
    private JButton CustomerFeedbackRating = new JButton("Customer Feedback Rating");
    private JButton createFood = new JButton("Create Food");
    private JButton updateFood = new JButton("Update Food");
    private JButton deleteFood = new JButton("Delete Food");
    private JButton updateMenuStatus = new JButton("Update Menu Status");
    private JButton createCust = new JButton("Create Customer");
    private JButton updateCust = new JButton("Update Customer");
    private JButton sortingMethod = new JButton("Sort Method");
    private JButton generateRatingReport = new JButton("Generate Rating Report");
    
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    
    public ModuleAMenu(){
        setTitle("Module A Management");
        Font fontInstruction = new Font("Arial", Font.BOLD, 36);
        
        
        jblTitle.setFont(fontInstruction);
        jblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(jblTitle, BorderLayout.NORTH);
        
        JPanel jpButton = new JPanel(new FlowLayout());
        
        

        if (MainMenu.user.getType().equalsIgnoreCase("manager")){
            jpButton.add(createFood);
            jpButton.add(updateFood);
            jpButton.add(deleteFood);
            jpButton.add(updateMenuStatus);
            jpButton.add(sortingMethod);
            jpButton.add(generateRatingReport);
        }else if (MainMenu.user.getType().equalsIgnoreCase("customer")){
            jpButton.add(createCust);
            jpButton.add(updateCust);
            jpButton.add(CustomerFeedbackRating);
            jpButton.add(createAffiliates);
            jpButton.add(updateAffiliates);
        }
        jPanel1.add(jpButton, BorderLayout.CENTER);
        
        createAffiliatesListener listnener10 = new createAffiliatesListener();
        createAffiliates.addActionListener(listnener10);
        updateAffiliatesListener listnener11 = new updateAffiliatesListener();
        updateAffiliates.addActionListener(listnener11);
        ratingListener listener13 = new ratingListener();
        CustomerFeedbackRating.addActionListener(listener13);
        CreateFoodListener listener = new CreateFoodListener();
        createFood.addActionListener(listener);
        UpdateFoodListener listener2 = new UpdateFoodListener();
        updateFood.addActionListener(listener2);
        DeleteFoodListener listener3 = new DeleteFoodListener();
        deleteFood.addActionListener(listener3);
        UpdateMenuStatusListener listener5 = new UpdateMenuStatusListener();
        updateMenuStatus.addActionListener(listener5);
        CreateCustListener listener7 = new CreateCustListener();
        createCust.addActionListener(listener7);
        UpdateCustListener listener8 = new UpdateCustListener();
        updateCust.addActionListener(listener8);
        SortingListener listener14 = new SortingListener();
        if (MainMenu.user.getType().equalsIgnoreCase("customer"))
        sortingMethod.addActionListener(listener14);
        GenerateRatingReportListener listener15 = new GenerateRatingReportListener();
        generateRatingReport.addActionListener(listener15);
        add(jPanel1);
        
    }
    private class createAffiliatesListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            CreateAffiliates frame = new CreateAffiliates();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    
     private class updateAffiliatesListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            UpdateAffiliatesCompanyType frame = new UpdateAffiliatesCompanyType();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    
     private class ratingListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            CustomerFeedbackRating frame = new CustomerFeedbackRating();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
     
     
    private class CreateFoodListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            CreateFoodItem frame = new CreateFoodItem();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    private class UpdateFoodListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            UpdateFoodItem frame = new UpdateFoodItem();
            frame.getContentPane().setPreferredSize(new Dimension(400, 300));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    private class DeleteFoodListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            DeleteFoodItem frame = new DeleteFoodItem();
            frame.getContentPane().setPreferredSize(new Dimension(400, 200));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }

    private class UpdateMenuStatusListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            UpdateMenuStatus frame = new UpdateMenuStatus();
            frame.getContentPane().setPreferredSize(new Dimension(400, 300));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    

    private class CreateCustListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            CreateCustomerList frame = new CreateCustomerList();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true);
         }
    }
    private class UpdateCustListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            UpdateCustomerList frame = new UpdateCustomerList();
            frame.getContentPane().setPreferredSize(new Dimension(600, 500));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true); 
         }
    }
    

    private class SortingListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            SortingMethod frame = new SortingMethod();
            frame.getContentPane().setPreferredSize(new Dimension(600, 400));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true); 
         }
    }
    
    private class GenerateRatingReportListener implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            GenerateRatingReport frame = new GenerateRatingReport();
            frame.getContentPane().setPreferredSize(new Dimension(600, 400));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(true); 
         }
    }
     public static void main(String[] args) {
        ModuleAMenu frame = new ModuleAMenu();
        frame.getContentPane().setPreferredSize(new Dimension(600, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    }

    /**
     * @param args the command line arguments
     */
   
    

