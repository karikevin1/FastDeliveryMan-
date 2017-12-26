/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleA.entity.Affiliates;
import ModuleA.adt.AffiliatesList;
import ModuleA.adt.AffiliatesInterface;


/**
 *
 * @author User
 */
public class CreateAffiliates extends JFrame {
    private JLabel jblAffiliatesID = new JLabel("Affiliates ID : ");
    private JLabel jblAffiliatesName = new JLabel("Affiliates Name : ");
    private JLabel jblAffiliatesIC = new JLabel("IC Number : ");
    private JLabel jblAffiliatesTelNo = new JLabel("Telephone Number : ");
    private JLabel jblAffiliatesAddress = new JLabel("Address : ");
    private JLabel jblAffiliatesEmail = new JLabel("Email : ");
    private JLabel jblAffiliatesCompanyType = new JLabel("Company Type :");
    
    private JTextField jtfAffiliatesID = new JTextField();
    private JTextField jtfAffiliatesName = new JTextField();
    private JTextField jtfAffiliatesIC = new JTextField();
    private JTextField jtfAffiliatesTelNo = new JTextField();
    private JTextField jtfAffiliatesAddress = new JTextField();   
    private JTextField jtfAffiliatesEmail = new JTextField();   
    String[] AffiliatesCompanyTypeList = new String[]{"McD", "KFC", "Pizza Hut", "Texas Chicken", "Domino Pizza"};
    JComboBox<String> jcbAffiliatesCompanyType = new JComboBox<>(AffiliatesCompanyTypeList);
    private JTextArea jtaAffiliatesList = new JTextArea(20, 20);
    
    private JButton jbtCreateAffiliates = new JButton("Create Affiliates");
    private JButton jbtReset = new JButton("Reset");
    
    public AffiliatesInterface<Affiliates> affiliatesList = new AffiliatesList<>();
    
    

    
    public CreateAffiliates(){
        affiliatesList();
        setTitle("Create Affiliates");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblAffiliatesID.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesName.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesIC.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesTelNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesAddress.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesEmail.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesCompanyType.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblAffiliatesID.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesName.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesIC.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesTelNo.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesAddress.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesEmail.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesCompanyType.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaAffiliatesList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(9,2));
        jpNew.add(jblAffiliatesID);
        jpNew.add(jtfAffiliatesID);
        jpNew.add(jblAffiliatesName);
        jpNew.add(jtfAffiliatesName);
        jpNew.add(jblAffiliatesIC);
        jpNew.add(jtfAffiliatesIC);
        jpNew.add(jblAffiliatesTelNo);
        jpNew.add(jtfAffiliatesTelNo);
        jpNew.add(jblAffiliatesAddress);
        jpNew.add(jtfAffiliatesAddress);
        jpNew.add(jblAffiliatesEmail);
        jpNew.add(jtfAffiliatesEmail);
        jpNew.add(jblAffiliatesCompanyType);
        jpNew.add(jcbAffiliatesCompanyType);
        jpNew.add(jbtCreateAffiliates);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        CreateAffiliatesListener createListener = new CreateAffiliatesListener();
        jbtCreateAffiliates.addActionListener(createListener);
        JScrollPane scrollPane = new JScrollPane(jtaAffiliatesList);
        add(scrollPane, BorderLayout.CENTER);
        
        

    }
     private class CreateAffiliatesListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int AffiliatesID = Integer.parseInt(jtfAffiliatesID.getText());
                String AffiliatesName = jtfAffiliatesName.getText();
                String AffiliatesIC = jtfAffiliatesIC.getText();
                String AffiliatesTelNo = jtfAffiliatesTelNo.getText();
                String AffiliatesAddress = jtfAffiliatesAddress.getText();
                String AffiliatesEmail = jtfAffiliatesEmail.getText();
                String jblAffiliatesCompanyType = jcbAffiliatesCompanyType.getSelectedItem().toString();
               
                
                Affiliates affiliates = new Affiliates(AffiliatesID, AffiliatesName, AffiliatesIC, AffiliatesTelNo, AffiliatesAddress, AffiliatesEmail, jblAffiliatesCompanyType);
                
                affiliatesList.addAffiliates(AffiliatesID, affiliates);
                JOptionPane.showConfirmDialog(null, "Do you want to create this Affiliates profile?");
                JOptionPane.showMessageDialog(null, "Affiliates profile has been created");
                
                    
                jtaAffiliatesList.setText("Affiliates ID        Affiliates Name        IC Number                    Email                               Telephone Number             Address                   Company Type\n" + affiliatesList.getAffiliatesEntry(AffiliatesID).toString() + "\n\nCurrent Affiliates List added :" + affiliatesList.getNumberOfAffiliates());
                
                affiliates.setAffiliatesID(Integer.parseInt(jtfAffiliatesID.getText()));
                affiliates.setAffiliatesName(jtfAffiliatesName.getText());
                affiliates.setAffiliatesIC(jtfAffiliatesIC.getText());
                affiliates.setAffiliatesTelNo(jtfAffiliatesTelNo.getText());
                affiliates.setAffiliatesAddress(jtfAffiliatesAddress.getText());
                affiliates.setAffiliatesEmail(jtfAffiliatesEmail.getText());
                affiliates.setAffiliatesCompanyType(jcbAffiliatesCompanyType.getSelectedItem().toString());

                clearText();
                
                
               
                
            }catch(Exception ex){
                jtaAffiliatesList.setText("Wrong Format / Text Field cannot be blank");
            }
            }
            
            
             
            public void clearText(){
                jtfAffiliatesID.setText("");
                jtfAffiliatesName.setText("");
                jtfAffiliatesIC.setText("");
                jtfAffiliatesTelNo.setText("");
                jtfAffiliatesAddress.setText("");
                jtfAffiliatesEmail.setText("");
            }
            
             
        }
     
        
            private void affiliatesList() {
                
            }     
}
