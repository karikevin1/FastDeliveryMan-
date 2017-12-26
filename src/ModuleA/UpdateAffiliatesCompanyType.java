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
public class UpdateAffiliatesCompanyType extends JFrame{
    private JLabel jblAffiliatesID = new JLabel("Affiliates ID : ");
    private JLabel jblAffiliatesName = new JLabel("Affiliates Name : ");
    private JLabel jblAffiliatesIC = new JLabel("IC Number : ");
    private JLabel jblAffiliatesTelNo = new JLabel("Telephone Number : ");
    private JLabel jblAffiliatesAddress = new JLabel("Address : ");
    private JLabel jblAffiliatesEmail = new JLabel("Email : ");
    private JLabel jblcurrentAffiliatesCompanyType = new JLabel("Company Type");
    private JLabel jblAffiliatesCompanyType = new JLabel("Select Company Type :");
    
    private JTextField jtfAffiliatesID = new JTextField();
    private JTextField jtfAffiliatesName = new JTextField();
    private JTextField jtfAffiliatesIC = new JTextField();
    private JTextField jtfAffiliatesTelNo = new JTextField();
    private JTextField jtfAffiliatesAddress = new JTextField();   
    private JTextField jtfAffiliatesEmail = new JTextField();   
    private JTextField jtfcurrentAffiliatesCompanyType = new JTextField();
    String[] AffiliatesCompanyTypeList = new String[]{"McD", "KFC", "Pizza Hut", "Texas Chicken", "Domino Pizza"};
    JComboBox<String> jcbAffiliatesCompanyType = new JComboBox<>(AffiliatesCompanyTypeList);
    private JTextArea jtaAffiliatesList = new JTextArea(20, 20);

    
    private JButton jbtUpdateAffiliates = new JButton("Update Affiliates Company Type");
    private JButton jbtReset = new JButton("Reset");
    
    public AffiliatesInterface<Affiliates> affiliatesList = new AffiliatesList<>();
    
    public UpdateAffiliatesCompanyType(){
        affiliatesList();
        setTitle("Update Affiliates Company Type");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblAffiliatesID.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesName.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesIC.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesTelNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesAddress.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesEmail.setHorizontalAlignment(SwingConstants.CENTER);
        jblcurrentAffiliatesCompanyType.setHorizontalAlignment(SwingConstants.CENTER);
        jblAffiliatesCompanyType.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblAffiliatesID.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesName.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesIC.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesTelNo.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesAddress.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesEmail.setVerticalAlignment(SwingConstants.CENTER);
        jblcurrentAffiliatesCompanyType.setVerticalAlignment(SwingConstants.CENTER);
        jblAffiliatesCompanyType.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaAffiliatesList.setEditable(false);
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
        jpNew.add(jblcurrentAffiliatesCompanyType);
        jpNew.add(jtfcurrentAffiliatesCompanyType);
        jpNew.add(jblAffiliatesCompanyType);
        jpNew.add(jcbAffiliatesCompanyType);
        jpNew.add(jbtUpdateAffiliates);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        SearchListener affiliatesListener = new SearchListener();
        jtfAffiliatesID.addActionListener(affiliatesListener);
        UpdateAffiliatesListener updateListener = new UpdateAffiliatesListener();
        jbtUpdateAffiliates.addActionListener(updateListener);
        JScrollPane scrollPane = new JScrollPane(jtaAffiliatesList);
        add(scrollPane, BorderLayout.CENTER);
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
                        jtfcurrentAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(1).getAffiliatesCompanyType());
                        
                        
                    }else if(affiliatesID == affiliatesID2){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesEmail());
                        jtfcurrentAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(2).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID3){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesEmail());
                        jtfcurrentAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(3).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID4){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesEmail());
                        jtfcurrentAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(4).getAffiliatesCompanyType());
                    }else if(affiliatesID == affiliatesID5){
                        jtfAffiliatesName.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesName());
                        jtfAffiliatesIC.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesIC());
                        jtfAffiliatesTelNo.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesTelNo());
                        jtfAffiliatesAddress.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesAddress());
                        jtfAffiliatesEmail.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesEmail());
                        jtfcurrentAffiliatesCompanyType.setText("" + affiliatesList.getAffiliatesEntry(5).getAffiliatesCompanyType());
                    }else {
                        JOptionPane.showMessageDialog(null, "No such affiliates");
                        clearText();
                    }

                }catch(Exception ex){

               }
            }
        }
    private class UpdateAffiliatesListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int affiliatesID = Integer.parseInt(jtfAffiliatesID.getText());
                String affiliatesName = jtfAffiliatesName.getText();
                String AffiliatesIC = jtfAffiliatesIC.getText();
                String AffiliatesTelNo = jtfAffiliatesTelNo.getText();
                String AffiliatesAddress = jtfAffiliatesAddress.getText();
                String AffiliatesEmail = jtfAffiliatesEmail.getText();
                String currentaffiliatesCompanyType = jtfcurrentAffiliatesCompanyType.getText();
                String affiliatesCompanyType = jcbAffiliatesCompanyType.getSelectedItem().toString();
                
                Affiliates affiliates = new Affiliates(affiliatesID, affiliatesName, AffiliatesIC, AffiliatesTelNo, AffiliatesAddress, AffiliatesEmail,affiliatesCompanyType);
                
                affiliatesList.updateAffiliates(affiliatesID, affiliates);
                
                
                JOptionPane.showConfirmDialog(null, "Do you want to update this affiliates profile?");
                JOptionPane.showMessageDialog(null, "Affiliates profile has been updated");
                jtaAffiliatesList.setText("Affiliates ID        Affiliates Name        IC Number                    Email                               Telephone Number             Address                   Company Type\n" + affiliatesList.getAffiliatesEntry(affiliatesID) + "\n");
                affiliates.setAffiliatesID(Integer.parseInt(jtfAffiliatesID.getText()));
                affiliates.setAffiliatesName(jtfAffiliatesName.getText());
                affiliates.setAffiliatesIC(jtfAffiliatesIC.getText());
                affiliates.setAffiliatesTelNo(jtfAffiliatesTelNo.getText());
                affiliates.setAffiliatesAddress(jtfAffiliatesAddress.getText());
                affiliates.setAffiliatesEmail(jtfAffiliatesEmail.getText());
                affiliates.setAffiliatesCompanyType(jtfcurrentAffiliatesCompanyType.getText());
                affiliates.setAffiliatesCompanyType(jcbAffiliatesCompanyType.getSelectedItem().toString());
                
                
                
                
                clearText();
            }catch(Exception ex){
                jtaAffiliatesList.setText("Text field cannot be blank");
            }
            }
        
            }
        
        private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
                 //jtaMenuList.setText(menuInt.toMenuString());
             }
        }
        
        public void clearText(){
            jtfAffiliatesID.setText("");
            jtfAffiliatesName.setText("");
            jtfAffiliatesIC.setText("");
            jtfAffiliatesTelNo.setText("");
            jtfAffiliatesAddress.setText("");
            jtfAffiliatesEmail.setText("");
            jtfcurrentAffiliatesCompanyType.setText("");
        }
        
        private void affiliatesList() {
        affiliatesList.addAffiliates(new Affiliates(1, "Lim", "900000-00-0000", "012-3456789", "abc@email.com", "Ampang", "MCD"));
        affiliatesList.addAffiliates(new Affiliates(2, "Low", "911111-11-1111", "013-4567890", "def@email.com", "Setapak", "KFC"));
        affiliatesList.addAffiliates(new Affiliates(3, "Leong ", "922222-22-2222", "014-5678901", "ghi@email.com", "Gombak", "Pizza Hut"));
        affiliatesList.addAffiliates(new Affiliates(4, "Aw", "933333-33-3333", "015-6789012", "jkl@email.com", "Kepong", "Domino Pizza"));
        affiliatesList.addAffiliates(new Affiliates(5, "X", "944444-44-4444", "016-7890123", "mno@email.com", "Selayang", "Texas Chicken"));
            
            
        } 
    
    
}
