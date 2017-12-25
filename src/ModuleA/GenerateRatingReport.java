/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import ModuleA.entity.CustomerRating;
import ModuleA.adt.RatingInterface;
import ModuleA.adt.RatingList;
/**
 *
 * @author User
 */
public class GenerateRatingReport extends JFrame {
    private JLabel jblName = new JLabel("Name:");
    private JLabel jblComment = new JLabel("Comment:");
    
    private JTextField jtfName = new JTextField();
    private JTextField jtfComment = new JTextField();
    private JTextArea jtaRatingReport = new JTextArea(20, 20);
    
    private JButton generateRatingReport = new JButton("Generate Rating Report");
    
    public RatingInterface ratingReport = new RatingList();
    
    public GenerateRatingReport(){
        addReportRating();
        setTitle("Rating Report");
        
        jblName.setHorizontalAlignment(SwingConstants.CENTER);
        jblComment.setHorizontalAlignment(SwingConstants.CENTER);
   
        jblName.setHorizontalAlignment(SwingConstants.CENTER);
        jblComment.setHorizontalAlignment(SwingConstants.CENTER);
        
        jtaRatingReport.setEditable(false);
        
         JPanel jpInfo = new JPanel(new GridLayout(4,2));
            jpInfo.add(jblName);
            jpInfo.add(jtfName);
            jpInfo.add(jblComment);
            jpInfo.add(jtfComment);
            jpInfo.add(generateRatingReport);
            
            add(jpInfo, BorderLayout.NORTH);
            
            GenerateReportListener listener = new GenerateReportListener();
            generateRatingReport.addActionListener(listener);
            
            JScrollPane scrollPane = new JScrollPane(jtaRatingReport);
            add(scrollPane, BorderLayout.CENTER);
    }
    
     private class GenerateReportListener implements ActionListener {
            @Override
                public void actionPerformed(ActionEvent e) {
                    
                        String resultStr = "Rating Report \n";
                        resultStr += "Name :" + jtfName.getText() + "\nGenerate Date :" + java.time.LocalTime.now() + "";
                        resultStr += "\nComment: " + jtfComment.getText();
                        resultStr += "\nRating ID       Customer Name                       Company Type                                Rating Score                     Comment";
                        resultStr += "\n" + ratingReport.toString();
                        int totalratingScore = 0;
                        CustomerRating temp = new CustomerRating();
                        totalratingScore += temp.getRatingScore();
                        resultStr += "\nTotal Rating Score : 10";
                        jtaRatingReport.setText(resultStr);
                    
                        
                
                }
     }
    
    public void addReportRating(){
        ratingReport.addRating(new CustomerRating(1, "Lim", "McD", 1, "abc"));
        ratingReport.addRating(new CustomerRating(2, "Lima", "KFC", 4, "abc"));
        ratingReport.addRating(new CustomerRating(3, "Limb", "McD", 5, "abc"));
        
    }
    
    /**
     * @param args the command line arguments
     */

    
}
