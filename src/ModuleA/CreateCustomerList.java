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
public class CreateCustomerList extends JFrame{
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
    
    private JButton jbtCreateCust = new JButton("Create Customer");
    private JButton jbtReset = new JButton("Reset");
    
    public CustomerInterface<Customer> custList = new CustomerList<>();
    
    

    
    public CreateCustomerList(){
        custList();
        setTitle("Create Customer List");
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
        jpNew.add(jbtCreateCust);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        CreateCustListener createListener = new CreateCustListener();
        jbtCreateCust.addActionListener(createListener);
        JScrollPane scrollPane = new JScrollPane(jtaCustList);
        add(scrollPane, BorderLayout.CENTER);
        
        

    }
     private class CreateCustListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int custID = Integer.parseInt(jtfcustID.getText());
                String custName = jtfcustName.getText();
                String custIC = jtfcustIC.getText();
                String custTelNo = jtfcustTelNo.getText();
                String custAddress = jtfcustAddress.getText();
                String custEmail = jtfcustEmail.getText();
               
                
                Customer cust = new Customer(custID, custName, custIC, custTelNo, custAddress, custEmail);
                
                custList.addCust(custID, cust);
                JOptionPane.showConfirmDialog(null, "Do you want to create this customer list?");
                JOptionPane.showMessageDialog(null, "Customer List has been created");
                
                    
                jtaCustList.setText("Customer ID        Customer Name        IC Number       Telephone Number     Address      Email\n" + custList.getCustEntry(custID) + "\n\nCurrent Customer List added :" + custList.getNumberOfCust());
                
                cust.setCustID(Integer.parseInt(jtfcustID.getText()));
                cust.setCustName(jtfcustName.getText());
                cust.setCustIC(jtfcustIC.getText());
                cust.setCustTelNo(jtfcustTelNo.getText());
                cust.setCustAddress(jtfcustAddress.getText());
                cust.setCustEmail(jtfcustEmail.getText());

                clearText();
                
                
               
                
            }catch(Exception ex){
                jtaCustList.setText("Wrong Format / Text Field cannot be blank");
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
            
             
        }
     
        
            private void custList() {

            }     
            
     }
        
