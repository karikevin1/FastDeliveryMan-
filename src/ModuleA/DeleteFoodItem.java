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
import ModuleA.entity.Food;
import ModuleA.adt.FoodList;
import ModuleA.adt.FoodInterface;


/**
 *
 * @author User
 */
public class DeleteFoodItem extends JFrame{
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JLabel jblFoodName = new JLabel("Food Name :");
    private JLabel jblFoodPrice = new JLabel("Food Price :");
    private JLabel jblFoodDesc = new JLabel("Description :");
    
    
    private JTextField jtfFoodID = new JTextField();
    private JTextField jtfFoodName = new JTextField();
    private JTextField jtfFoodPrice = new JTextField();
    private JTextField jtfFoodDesc = new JTextField();   
    
    private JButton jbtDeleteFood = new JButton("Delete Food");
    private JButton jbtReset = new JButton("Reset");
    
    public FoodInterface<Food> foodList = new FoodList<>();

    
    public DeleteFoodItem(){
        FoodList();
        setTitle("Delete Food");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblFoodID.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblFoodID.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodName.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setVerticalAlignment(SwingConstants.CENTER);
        
   //     jtaFoodList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(6,2));
        jpNew.add(jblFoodID);
        jpNew.add(jtfFoodID);
        jpNew.add(jblFoodName);
        jpNew.add(jtfFoodName);
        jpNew.add(jblFoodPrice);
        jpNew.add(jtfFoodPrice);
        jpNew.add(jblFoodDesc);
        jpNew.add(jtfFoodDesc);
        jpNew.add(jbtDeleteFood);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        SearchListener foodListener = new SearchListener();
        jtfFoodID.addActionListener(foodListener);
        DeleteFoodListener updateListener = new DeleteFoodListener();
        jbtDeleteFood.addActionListener(updateListener);
        ResetListener resetListener = new ResetListener();
        jbtReset.addActionListener(resetListener);
    }
    
        private class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int foodID = Integer.parseInt(jtfFoodID.getText());
                    int foodID1 = foodList.getFoodEntry(1).getFoodID();
                    int foodID2 = foodList.getFoodEntry(2).getFoodID();
                    int foodID3 = foodList.getFoodEntry(3).getFoodID();
                    int foodID4 = foodList.getFoodEntry(4).getFoodID();
                    int foodID5 = foodList.getFoodEntry(5).getFoodID();
                    
                    if(foodID == foodID1){
                        jtfFoodName.setText("" + foodList.getFoodEntry(1).getFoodName());
                        jtfFoodPrice.setText("" + foodList.getFoodEntry(1).getFoodPrice());
                        jtfFoodDesc.setText("" + foodList.getFoodEntry(1).getFoodDesc());        
                    }else if(foodID == foodID2){
                        jtfFoodName.setText("" + foodList.getFoodEntry(2).getFoodName());
                        jtfFoodPrice.setText("" + foodList.getFoodEntry(2).getFoodPrice());
                        jtfFoodDesc.setText("" + foodList.getFoodEntry(2).getFoodDesc()); 
                    }else if(foodID == foodID3){
                        jtfFoodName.setText("" + foodList.getFoodEntry(3).getFoodName());
                        jtfFoodPrice.setText("" + foodList.getFoodEntry(3).getFoodPrice());
                        jtfFoodDesc.setText("" + foodList.getFoodEntry(3).getFoodDesc());
                    }else if(foodID == foodID4){
                        jtfFoodName.setText("" + foodList.getFoodEntry(4).getFoodName());
                        jtfFoodPrice.setText("" + foodList.getFoodEntry(4).getFoodPrice());
                        jtfFoodDesc.setText("" + foodList.getFoodEntry(4).getFoodDesc()); 
                    }else if(foodID == foodID5){
                        jtfFoodName.setText("" + foodList.getFoodEntry(5).getFoodName());
                        jtfFoodPrice.setText("" + foodList.getFoodEntry(5).getFoodPrice());
                        jtfFoodDesc.setText("" + foodList.getFoodEntry(5).getFoodDesc()); 
                    }else {
                        JOptionPane.showMessageDialog(null, "No such food items");
                        clearText();
                    }

                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "No such food items");
               }
            }
        }
        
        private class DeleteFoodListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int foodID = Integer.parseInt(jtfFoodID.getText());
                String foodName = jtfFoodName.getText();
                double foodPrice = Double.parseDouble(jtfFoodPrice.getText());
                String foodDesc = jtfFoodDesc.getText();
                Food food = new Food(foodID, foodName, foodPrice, foodDesc);
                
                for(int i = 1; i < foodList.getNumberOfFood(); i ++){
                foodList.DeleteFood(i).getFoodID();
                }
                JOptionPane.showConfirmDialog(null, "Do you want to delete this menu?");
                JOptionPane.showMessageDialog(null, "Menu has been deleted");
                clearText();
                
                
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Text field cannot be blank");
            }
            }
        }
        private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
             }
        }
        
        public void clearText(){
            jtfFoodID.setText("");
            jtfFoodName.setText("");
            jtfFoodPrice.setText("");
            jtfFoodDesc.setText("");
        }
        
        private void FoodList() {
            foodList.addFood(new Food(1, "McD", 9.00, "abc"));
            foodList.addFood(new Food(2, "KFC", 9.00, "abc"));
            foodList.addFood(new Food(3, "Pizza", 9.00, "abc"));
            foodList.addFood(new Food(4, "Domino", 9.00, "abc"));
            foodList.addFood(new Food(5, "Texas Chicken", 9.00, "abc"));
            //jtaMenuList.setText(menuInt.toMenuString());
            
        }     
    
    
}
