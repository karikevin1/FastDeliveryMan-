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
public class DeleteAffiliates extends JFrame {
    private JLabel jblAffiliatesID = new JLabel("Affiliates ID : ");
    private JLabel jblAffiliatesName = new JLabel("Affiliates Name : ");
    private JLabel jblAffiliatesIC = new JLabel("IC Number : ");
    private JLabel jblAffiliatesTelNo = new JLabel("Telephone Number : ");
    private JLabel jblAffiliatesAddress = new JLabel("Address : ");
    private JLabel jblAffiliatesEmail = new JLabel("Email : ");
    private JLabel jblAffiliatesCompanyType = new JLabel("Company Type");
    
    private JTextField jtfAffiliatesID = new JTextField();
    private JTextField jtfAffiliatesName = new JTextField();
    private JTextField jtfAffiliatesIC = new JTextField();
    private JTextField jtfAffiliatesTelNo = new JTextField();
    private JTextField jtfAffiliatesAddress = new JTextField();   
    private JTextField jtfAffiliatesEmail = new JTextField();   
    private JTextField jtfAffiliatesCompanyType = new JTextField();
    
    private JButton jbtdeleteAffiliates = new JButton("Delete Affiliates");
    private JButton jbtReset = new JButton("Reset");
    
    public AffiliatesInterface<Affiliates> affiliatesList = new AffiliatesList<>();
    
    
    public DeleteAffiliates(){
        affiliatesList();
        setTitle("Delete Affiliates");
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
        
        
        JPanel jpNew = new JPanel(new GridLayout(10,2));
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
        jpNew.add(jtfAffiliatesCompanyType);
        jpNew.add(jbtdeleteAffiliates);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        SearchListener affiliatesListener = new SearchListener();
        jtfAffiliatesID.addActionListener(affiliatesListener);
        DeleteAffiliatesListener deleteListener = new DeleteAffiliatesListener();
        jbtdeleteAffiliates.addActionListener(deleteListener);
        
    }
    private class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int affiliatesID = Integer.parseInt(jtfAffiliatesID.getText());
                    
                    int affiliatesID1 = affiliatesList.getAffiliatesEntry(1).getAffiliatesID();
                    int affiliatesID2 = affiliatesList.getAffiliatesEntry(2).getAffiliatesID();
                    int affiliatesID3 = affiliatesList.getAffiliatesEntry(3).getAffiliatesID();
                    int affiliatesID4 = affiliatesList.getAffiliatesEntry(4).getAffiliatesID();
                    int affiliatesID5 = affiliatesList.getAffiliatesEntry(5).getAffiliatesID();
                    
                     if(affiliatesID == affiliatesID1){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesEmail());
                        jtfAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesCompanyType());
                        
                        
                    }else if(affiliatesID == affiliatesID2){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesEmail());
                        jtfAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID3){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesEmail());
                        jtfAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID4){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesEmail());
                        jtfAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID5){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesEmail());
                        jtfAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesCompanyType());
                    }else {
                        JOptionPane.showMessageDialog(null, "No such affiliates");
                        clearText();
                    }
                }catch(Exception ex){
                     JOptionPane.showMessageDialog(null, "No such affiliates");
                }
            }
    }
            private class DeleteAffiliatesListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                     for(int i = 1; i < affiliatesList.getNumberOfAffiliates() ; i ++){
                        affiliatesList.DeleteAffiliates(i).getAffiliatesID();
                }
                    JOptionPane.showConfirmDialog(null, "Do you want to delete this affiliates?");
                    JOptionPane.showMessageDialog(null, "Affiliates has been deleted");
                    clearText();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Text Field cannot be blank");
                }
            }
            }

             private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
             }
        }
         public void clearText(){
            jtfAffiliatesName.setText("");
            jtfAffiliatesIC.setText("");
            jtfAffiliatesTelNo.setText("");
            jtfAffiliatesAddress.setText("");
            jtfAffiliatesEmail.setText("");
            jtfAffiliatesCompanyType.setText("");
            
        }
    private void affiliatesList() {
        affiliatesList.addAffiliates(new Affiliates(1, "abc", "abc", "abc", "abc", "abc", "MCD"));
        affiliatesList.addAffiliates(new Affiliates(2, "def", "abc", "abc", "abc", "abc", "KFC"));
        affiliatesList.addAffiliates(new Affiliates(3, "ghi", "abc", "abc", "abc", "abc", "Pizza Hut"));
        affiliatesList.addAffiliates(new Affiliates(4, "jkl", "abc", "abc", "abc", "abc", "Domino Pizza"));
        affiliatesList.addAffiliates(new Affiliates(5, "mno", "abc", "abc", "abc", "abc", "Texas Chicken"));
    } 

    }

    
