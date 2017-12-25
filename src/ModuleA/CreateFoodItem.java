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
import ModuleA.adt.MenuInterface;
import ModuleA.adt.MenuList;
import ModuleA.entity.Menu;


/**
 *
 * @author User
 */
public class CreateFoodItem extends JFrame{
    private JLabel jblFoodID = new JLabel("Food ID :");
    private JLabel jblFoodName = new JLabel("Food Name :");
    private JLabel jblFoodPrice = new JLabel("Food Price :");
    private JLabel jblFoodDesc = new JLabel("Description :");
    
    
    private JTextField jtfFoodID = new JTextField();
    private JTextField jtfFoodName = new JTextField();
    private JTextField jtfFoodPrice = new JTextField();
    private JTextField jtfFoodDesc = new JTextField();   
    private JTextArea jtaFoodList = new JTextArea(20, 20);
    
    private JButton jbtCreateFood = new JButton("Create Food");
    private JButton jbtReset = new JButton("Reset");
    
    public FoodInterface<Food> foodList = new FoodList<>();
    public MenuInterface<Menu> menuList = new MenuList<>();
    
    

    
    public CreateFoodItem(){
        foodList();
        setTitle("Create Food");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblFoodID.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodName.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setHorizontalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblFoodID.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodName.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodPrice.setVerticalAlignment(SwingConstants.CENTER);
        jblFoodDesc.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaFoodList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(6,2));
        jpNew.add(jblFoodID);
        jpNew.add(jtfFoodID);
        jpNew.add(jblFoodName);
        jpNew.add(jtfFoodName);
        jpNew.add(jblFoodPrice);
        jpNew.add(jtfFoodPrice);
        jpNew.add(jblFoodDesc);
        jpNew.add(jtfFoodDesc);
        jpNew.add(jbtCreateFood);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        
        CreateFoodListener createListener = new CreateFoodListener();
        jbtCreateFood.addActionListener(createListener);
        JScrollPane scrollPane = new JScrollPane(jtaFoodList);
        add(scrollPane, BorderLayout.CENTER);
        

        

    }
     private class CreateFoodListener implements ActionListener{
            public void actionPerformed(ActionEvent e){   
                try{

                int foodID = Integer.parseInt(jtfFoodID.getText());
                String foodName = jtfFoodName.getText();
                double foodPrice = Double.parseDouble(jtfFoodPrice.getText());
                String foodDesc = jtfFoodDesc.getText();
                
                Food food = new Food(foodID, foodName, foodPrice, foodDesc);
                
                
                foodList.addFood(foodID, food);
                
                
                JOptionPane.showConfirmDialog(null, "Do you want to create this Food?");
                JOptionPane.showMessageDialog(null, "Food has been created");
                
                
                jtaFoodList.setText("Food ID        Food Name       Food Price(RM)     Description\n" + foodList.getFoodEntry(foodID).toString() + "\n\nCurrent Food List added :" + foodList.getNumberOfFood());
                
                food.setFoodID(Integer.parseInt(jtfFoodID.getText()));
                food.setFoodName(jtfFoodName.getText());
                food.setFoodPrice(Double.parseDouble(jtfFoodPrice.getText()));
                food.setFoodDesc(jtfFoodDesc.getText());

                clearText();
          
            }catch(Exception ex){
                jtaFoodList.setText("Wrong Format / Text Field cannot be blank");
            }
            }

             public void clearText(){
                jtfFoodID.setText("");
                jtfFoodName.setText("");
                jtfFoodPrice.setText("");
                jtfFoodDesc.setText("");
            }
            
             
        }
     
        
            private void foodList() {
                foodList.addFood(new Food(1, "McD", 9.00, "abc"));
                foodList.addFood(new Food(2, "KFC", 9.00, "abc"));
                foodList.addFood(new Food(3, "Pizza", 9.00, "abc"));
                foodList.addFood(new Food(4, "Domino", 9.00, "abc"));
                foodList.addFood(new Food(5, "Texas Chicken", 9.00, "abc"));
            }     
            
     }
        
