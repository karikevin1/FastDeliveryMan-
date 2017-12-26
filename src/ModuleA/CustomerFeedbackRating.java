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
import ModuleA.entity.CustomerRating;
import ModuleA.adt.RatingList;
import ModuleA.adt.RatingInterface;

/**
 *
 * @author User
 */
public class CustomerFeedbackRating extends JFrame {
    private JLabel jblRatingID = new JLabel("Rating ID :");
    private JLabel jblcustRatingName = new JLabel("Name :");
    private JLabel jblCompanyType = new JLabel("Select Company that want to review :");
    private JLabel jblratingScore = new JLabel("Rating Score(1 to 5 only) :");
    private JLabel jblratingComment = new JLabel("Comment :");
    
    private JTextField jtfRatingID = new JTextField();
    private JTextField jtfcustRatingName = new JTextField();
    String[] ratingCompanyTypeList = new String[]{"McD", "KFC", "Pizza Hut", "Texas Chicken", "Domino Pizza"};
    JComboBox<String> jcbratingCompanyType = new JComboBox<>(ratingCompanyTypeList);
    private JTextField jtfratingScore = new JTextField();
    
    private JTextField jtfratingComment = new JTextField();   
    private JTextArea jtaRatingList = new JTextArea(20, 20);
    
    private JButton jbtSubmitRating = new JButton("Submit Rating");
    private JButton jbtReset = new JButton("Reset");
    
    public RatingInterface<CustomerRating> ratingList = new RatingList<>();
    
    public CustomerFeedbackRating(){
        ratingList();
        setTitle("Customer Rating Feedback");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblRatingID.setHorizontalAlignment(SwingConstants.CENTER);
        jblcustRatingName.setHorizontalAlignment(SwingConstants.CENTER);
        jblCompanyType.setHorizontalAlignment(SwingConstants.CENTER);
        jblratingScore.setHorizontalAlignment(SwingConstants.CENTER);
        jblratingComment.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblRatingID.setVerticalAlignment(SwingConstants.CENTER);
        jblcustRatingName.setVerticalAlignment(SwingConstants.CENTER);
        jblCompanyType.setVerticalAlignment(SwingConstants.CENTER);
        jblratingScore.setVerticalAlignment(SwingConstants.CENTER);
        jblratingComment.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaRatingList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(6,2));
        jpNew.add(jblRatingID);
        jpNew.add(jtfRatingID);
        jpNew.add(jblcustRatingName);
        jpNew.add(jtfcustRatingName);
        jpNew.add(jblCompanyType);
        jpNew.add(jcbratingCompanyType);
        jpNew.add(jblratingScore);
        jpNew.add(jtfratingScore);
        jpNew.add(jblratingComment);
        jpNew.add(jtfratingComment);
        jpNew.add(jbtSubmitRating);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        CustomerRatingListener ratingListener = new CustomerRatingListener();
        jbtSubmitRating.addActionListener(ratingListener);
        JScrollPane scrollPane = new JScrollPane(jtaRatingList);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private class CustomerRatingListener implements ActionListener{
            public void actionPerformed(ActionEvent e){   
                try{

                int ratingID = Integer.parseInt(jtfRatingID.getText());
                String custRatingName = jtfcustRatingName.getText();
                String companyType = jcbratingCompanyType.getSelectedItem().toString();
                int ratingScore = Integer.parseInt(jtfratingScore.getText());
                String ratingComment = jtfratingComment.getText();
                
                CustomerRating rating = new CustomerRating(ratingID, custRatingName, companyType , ratingScore, ratingComment);
                
                
                ratingList.addRating(ratingID, rating);
                
                
                JOptionPane.showConfirmDialog(null, "Do you want to submit this rating ?");
                JOptionPane.showMessageDialog(null, "Rating form has been submitted");
                
                
                jtaRatingList.setText("Rating ID        Customer Name       Rating Company                          Rating Score                                        Comment\n" + ratingList.getRatingEntry(ratingID).toString() + "\n\nCurrent Food List added :" + ratingList.getNumberOfRating());
                
                rating.setRatingID(Integer.parseInt(jtfRatingID.getText()));
                rating.setCustRatingName(jtfcustRatingName.getText());
                rating.setCompanyType(jcbratingCompanyType.getSelectedItem().toString());
                rating.setRatingScore(Integer.parseInt(jtfratingScore.getText()));
                rating.setRatingComment(jtfratingComment.getText());

                clearText();
          
            }catch(Exception ex){
                jtaRatingList.setText("Wrong Format / Text Field cannot be blank");
            }
            }

             public void clearText(){
                jtfRatingID.setText("");
                jtfcustRatingName.setText("");
                jtfratingScore.setText("");
                jtfratingComment.setText("");
            }
            
             
        }
     
        
            private void ratingList() {
                
            }

}
