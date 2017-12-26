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
import ModuleA.entity.Customer;
import ModuleA.adt.CustomerList;
import ModuleA.adt.CustomerInterface;
/**
 *
 * @author User
 */
public class UpdateCustomerList extends JFrame{
    private JLabel jblcustID = new JLabel("Customer ID : ");
    private JLabel jblcustName = new JLabel("Customer Name : ");
    private JLabel jblcustIC = new JLabel("IC Number : ");
    private JLabel jblcustTelNo = new JLabel("Telephone Number : ");
    private JLabel jblcustAddress = new JLabel("Address : ");
    private JLabel jblcustEmail = new JLabel("Email : ");
    
    
    private JTextField jtfcustID = new JTextField();
    private JTextField jtfcustName = new JTextField();
    private JTextField jtfcustIC = new JTextField();
    private JTextField jtfcustTelNo = new JTextField();
    private JTextField jtfcustAddress = new JTextField();   
    private JTextField jtfcustEmail = new JTextField();   
    private JTextArea jtaCustList = new JTextArea(20, 20);
    
    private JButton jbtUpdateCust = new JButton("Update Customer");
    private JButton jbtReset = new JButton("Reset");
    
    public CustomerInterface<Customer> custList = new CustomerList<>();
    
    public UpdateCustomerList(){
        custList();
        setTitle("Update Customer List");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblcustID.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustName.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustIC.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustTelNo.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustAddress.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustEmail.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblcustID.setVerticalAlignment(SwingConstants.CENTER);
        jblcustName.setVerticalAlignment(SwingConstants.CENTER);
        jblcustIC.setVerticalAlignment(SwingConstants.CENTER);
        jblcustTelNo.setVerticalAlignment(SwingConstants.CENTER);
        jblcustAddress.setVerticalAlignment(SwingConstants.CENTER);
        jblcustEmail.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaCustList.setEditable(false);
        jtfcustName.setEditable(false);
        jtfcustIC.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(8,2));
        jpNew.add(jblcustID);
        jpNew.add(jtfcustID);
        jpNew.add(jblcustName);
        jpNew.add(jtfcustName);
        jpNew.add(jblcustIC);
        jpNew.add(jtfcustIC);
        jpNew.add(jblcustTelNo);
        jpNew.add(jtfcustTelNo);
        jpNew.add(jblcustAddress);
        jpNew.add(jtfcustAddress);
        jpNew.add(jblcustEmail);
        jpNew.add(jtfcustEmail);
        jpNew.add(jbtUpdateCust);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        SearchListener custListener = new SearchListener();
        jtfcustID.addActionListener(custListener);
        UpdateCustListener updateListener = new UpdateCustListener();
        jbtUpdateCust.addActionListener(updateListener);
        ResetListener resetListener = new ResetListener();
        jbtReset.addActionListener(resetListener);
        JScrollPane scrollPane = new JScrollPane(jtaCustList);
        add(scrollPane, BorderLayout.CENTER);
    }
     private class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int custID = Integer.parseInt(jtfcustID.getText());
                    
                    int custID1 = custList.getCustEntry(1).getCustID();
                    int custID2 = custList.getCustEntry(2).getCustID();
                    int custID3 = custList.getCustEntry(3).getCustID();
                    int custID4 = custList.getCustEntry(4).getCustID();
                    int custID5 = custList.getCustEntry(5).getCustID();
                    
                    if(custID == custID1){
                        jtfcustName.setText("" + custList.getCustEntry(1).getCustName());
                        jtfcustIC.setText("" + custList.getCustEntry(1).getCustIC());
                        jtfcustTelNo.setText("" + custList.getCustEntry(1).getCustTelNo()); 
                        jtfcustAddress.setText("" + custList.getCustEntry(1).getCustAddress());
                        jtfcustEmail.setText("" + custList.getCustEntry(1).getCustEmail());
                    }else if(custID == custID2){
                        jtfcustName.setText("" + custList.getCustEntry(2).getCustName());
                        jtfcustIC.setText("" + custList.getCustEntry(2).getCustIC());
                        jtfcustTelNo.setText("" + custList.getCustEntry(2).getCustTelNo()); 
                        jtfcustAddress.setText("" + custList.getCustEntry(2).getCustAddress());
                        jtfcustEmail.setText("" + custList.getCustEntry(2).getCustEmail());
                    }else if(custID == custID3){
                        jtfcustName.setText("" + custList.getCustEntry(3).getCustName());
                        jtfcustIC.setText("" + custList.getCustEntry(3).getCustIC());
                        jtfcustTelNo.setText("" + custList.getCustEntry(3).getCustTelNo()); 
                        jtfcustAddress.setText("" + custList.getCustEntry(3).getCustAddress());
                        jtfcustEmail.setText("" + custList.getCustEntry(3).getCustEmail());
                    }else if(custID == custID4){
                        jtfcustName.setText("" + custList.getCustEntry(4).getCustName());
                        jtfcustIC.setText("" + custList.getCustEntry(4).getCustIC());
                        jtfcustTelNo.setText("" + custList.getCustEntry(4).getCustTelNo()); 
                        jtfcustAddress.setText("" + custList.getCustEntry(4).getCustAddress());
                        jtfcustEmail.setText("" + custList.getCustEntry(4).getCustEmail());
                    }else if(custID == custID5){
                        jtfcustName.setText("" + custList.getCustEntry(5).getCustName());
                        jtfcustIC.setText("" + custList.getCustEntry(5).getCustIC());
                        jtfcustTelNo.setText("" + custList.getCustEntry(5).getCustTelNo()); 
                        jtfcustAddress.setText("" + custList.getCustEntry(5).getCustAddress());
                        jtfcustEmail.setText("" + custList.getCustEntry(5).getCustEmail());
                    }else {
                        JOptionPane.showMessageDialog(null, "No such customer");
                        clearText();
                    }
                }catch(Exception ex){
               }
            }
        }
        
        private class UpdateCustListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int custID = Integer.parseInt(jtfcustID.getText());
                String custName = jtfcustName.getText();
                String custIC = jtfcustIC.getText();
                String custTelNo = jtfcustTelNo.getText();
                String custAddress = jtfcustAddress.getText();
                String custEmail = jtfcustEmail.getText();
                
                Customer cust = new Customer(custID, custName, custIC, custTelNo, custAddress, custEmail);
                
                custList.updateCust(custID, cust);
                
                
                JOptionPane.showConfirmDialog(null, "Do you want to update this customer?");
                JOptionPane.showMessageDialog(null, "Customer has been updated");
                jtaCustList.setText("Customer ID        Customer Name        IC Number       Telephone Number                       Address                     Email\n" + custList.getCustEntry(custID));
                cust.setCustID(Integer.parseInt(jtfcustID.getText()));
                cust.setCustName(jtfcustName.getText());
                cust.setCustIC(jtfcustIC.getText());
                cust.setCustTelNo(jtfcustTelNo.getText());
                cust.setCustAddress(jtfcustAddress.getText());
                cust.setCustEmail(jtfcustEmail.getText());

                clearText();
            }catch(Exception ex){
                jtaCustList.setText("Text field cannot be blank");
            }
            }
        
            }
        
        private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
             }
        }
        
        public void clearText(){
            jtfcustID.setText("");
            jtfcustName.setText("");
            jtfcustIC.setText("");
            jtfcustTelNo.setText("");
            jtfcustAddress.setText("");
            jtfcustEmail.setText("");
        }
        
        private void custList() {
            custList.addCust(new Customer(1, "Lim", "900000-00-0000", "012-3456789", "Ampang", "abc@email.com"));
            custList.addCust(new Customer(2, "Low", "911111-11-1111", "013-4567890", "Setapak", "def@email.com"));
            custList.addCust(new Customer(3, "Leong", "922222-22-2222", "014-5678901", "Gombak", "ghi@email.com"));
            custList.addCust(new Customer(4, "Aw", "933333-33-3333", "015-6789012", "Kepong", "jkl@email.com"));
            custList.addCust(new Customer(5, "X", "944444-44-4444", "016-7890123", "Selayang", "mno@email.com"));
        } 

}
