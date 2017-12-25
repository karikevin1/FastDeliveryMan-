/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import ModuleA.adt.RatingInterface;
import ModuleA.adt.RatingList;
import ModuleA.entity.CustomerRating;
import ModuleA.entity.Food;
import ModuleA.adt.FoodList;
import ModuleA.adt.FoodInterface;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;


/**
 *
 * @author User
 */
public class SortingMethod extends JFrame{
    private JLabel jblSortingMethod = new JLabel("Choose Sorting Method");
    String[] SortingMethod = new String[]{"Food Price(High to low)", "Food Price(Low to high)", "Customer Rating(High to low)", "Customer Rating(Low to high)"};
    JComboBox<String> jcbSortingMethod = new JComboBox<>(SortingMethod);
    
    private JTextArea jtaSortingList = new JTextArea(20, 20);
    
    private JButton jbtSort = new JButton("Sort");
    
    public FoodInterface<Food> sortHighestFoodList = new FoodList<>();
    public FoodInterface<Food> sortLowestFoodList = new FoodList<>();
    public RatingInterface<CustomerRating> sortHighestRatingList = new RatingList<>();
    public RatingInterface<CustomerRating> sortLowestRatingList = new RatingList<>();
    
    public SortingMethod(){
        SortFoodList();
        SortRatingList();
        setTitle("Sorting Method");
        jblSortingMethod.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblSortingMethod.setVerticalAlignment(SwingConstants.CENTER);
        
        jtaSortingList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(3,2));
        jpNew.add(jblSortingMethod);
        jpNew.add(jcbSortingMethod);
        jpNew.add(jbtSort);
        add(jpNew, BorderLayout.NORTH);
        
        SortingListener sortListener = new SortingListener();
        jbtSort.addActionListener(sortListener);
        JScrollPane scrollPane = new JScrollPane(jtaSortingList);
        add(scrollPane, BorderLayout.CENTER);
        
    }
    
    private class SortingListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(jcbSortingMethod.getSelectedItem().equals("Food Price(High to low)")){
                    jtaSortingList.setText("Food ID         Food Name                       Price                       Description\n" + sortHighestFoodList.getFoodEntry(1).toString() + "\n" + sortHighestFoodList.getFoodEntry(2).toString() + "\n" + sortHighestFoodList.getFoodEntry(3).toString() + "\n" + sortHighestFoodList.getFoodEntry(4).toString() + "\n" + sortHighestFoodList.getFoodEntry(5).toString());
                }else if(jcbSortingMethod.getSelectedItem().equals("Customer Rating(High to low)")){
                    jtaSortingList.setText("Rating ID       Customer Name                       Company Type                                Rating Score                     Comment\n" + sortHighestRatingList.getRatingEntry(1).toString() + "\n" + sortHighestRatingList.getRatingEntry(2).toString() + "\n" + sortHighestRatingList.getRatingEntry(3).toString() + "\n" + sortHighestRatingList.getRatingEntry(4).toString() + "\n" + sortHighestRatingList.getRatingEntry(5).toString());
                }else if(jcbSortingMethod.getSelectedItem().equals("Food Price(Low to high)")){
                    jtaSortingList.setText("Food ID         Food Name                       Price                       Description\n" + sortLowestFoodList.getFoodEntry(1).toString() + "\n" + sortLowestFoodList.getFoodEntry(2).toString() + "\n" + sortLowestFoodList.getFoodEntry(3).toString() + "\n" + sortLowestFoodList.getFoodEntry(4).toString() + "\n" + sortLowestFoodList.getFoodEntry(5).toString());
                }else if(jcbSortingMethod.getSelectedItem().equals("Customer Rating(Low to high)")){
                    jtaSortingList.setText("Rating ID       Customer Name                       Company Type                                Rating Score                     Comment\n" + sortLowestRatingList.getRatingEntry(1).toString() + "\n" + sortLowestRatingList.getRatingEntry(2).toString() + "\n" + sortLowestRatingList.getRatingEntry(3).toString() + "\n" + sortLowestRatingList.getRatingEntry(4).toString() + "\n" + sortLowestRatingList.getRatingEntry(5).toString());
                }
            }
    }
    
    public void SortFoodList(){
            sortHighestFoodList.sortHighestFoodPrice(new Food(1, "McD", 17.00, "abc"));
            sortHighestFoodList.sortHighestFoodPrice(new Food(2, "KFC", 7.00, "abc"));
            sortHighestFoodList.sortHighestFoodPrice(new Food(3, "Pizza", 50.00, "abc"));
            sortHighestFoodList.sortHighestFoodPrice(new Food(4, "Domino", 30.00, "abc"));
            sortHighestFoodList.sortHighestFoodPrice(new Food(5, "Texas Chicken", 25.00, "abc")); 
            
            sortLowestFoodList.sortLowestFoodPrice(new Food(1, "McD", 17.00, "abc"));
            sortLowestFoodList.sortLowestFoodPrice(new Food(2, "KFC", 7.00, "abc"));
            sortLowestFoodList.sortLowestFoodPrice(new Food(3, "Pizza", 50.00, "abc"));
            sortLowestFoodList.sortLowestFoodPrice(new Food(4, "Domino", 30.00, "abc"));
            sortLowestFoodList.sortLowestFoodPrice(new Food(5, "Texas Chicken", 25.00, "abc"));
    }
    
    public void SortRatingList(){
            sortHighestRatingList.sortHighestRatingScore(new CustomerRating(1, "Lim", "McD", 4, "abc"));
            sortHighestRatingList.sortHighestRatingScore(new CustomerRating(2, "a", "KFC", 5, "abc"));
            sortHighestRatingList.sortHighestRatingScore(new CustomerRating(3, "b", "Pizza", 1, "abc"));
            sortHighestRatingList.sortHighestRatingScore(new CustomerRating(4, "c", "Domino", 3, "abc"));
            sortHighestRatingList.sortHighestRatingScore(new CustomerRating(5, "d", "Chicken", 2, "abc"));
            
            sortLowestRatingList.sortLowestRatingScore(new CustomerRating(1, "Lim", "McD", 4, "abc"));
            sortLowestRatingList.sortLowestRatingScore(new CustomerRating(2, "a", "KFC", 5, "abc"));
            sortLowestRatingList.sortLowestRatingScore(new CustomerRating(3, "b", "Pizza", 1, "abc"));
            sortLowestRatingList.sortLowestRatingScore(new CustomerRating(4, "c", "Domino", 3, "abc"));
            sortLowestRatingList.sortLowestRatingScore(new CustomerRating(5, "d", "Chicken", 2, "abc"));
            
            
            
    }

}
