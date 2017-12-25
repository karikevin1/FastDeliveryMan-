package ModuleC.ui;

import ModuleA.entity.Restaurant;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectRestaurant extends JPanel{
    private final JButton[] jbtRestaurantList;
    private final JButton jbtBack = new JButton("Back");
    private final JPanel jpSelectRestaurant;
    private static Restaurant SELECTED_REST = null;
    
    public SelectRestaurant(){
        PassSelectedRest passSelectedRest = new PassSelectedRest();

        jbtRestaurantList = new JButton[OrderUI.RESTAURANT_LIST.getNumberOfAffiliates()];
        jpSelectRestaurant = new JPanel(new GridLayout(0, 5));
        //change the loop refer to restaurantlist size
        for (int i = 0, loopCnt = 1 ; i < OrderUI.RESTAURANT_LIST.getNumberOfAffiliates() ; i++, loopCnt++){
            jbtRestaurantList[i] = new JButton("" + OrderUI.RESTAURANT_LIST.getAffiliatesEntry(loopCnt).getName()); // get the restaurants from the list to buttons
            jbtRestaurantList[i].addActionListener(passSelectedRest);
            jpSelectRestaurant.add(jbtRestaurantList[i]);
        }

        jbtBack.addActionListener((ActionEvent e) -> {
            OrderUI.changePanel(new OrderUIType());
        });
        
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(jpSelectRestaurant);
        add(jbtBack);
    }
    
    private class PassSelectedRest implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Object buttonClicked = e.getSource();
            
            for (int loopCnt = 0 ; loopCnt < OrderUI.RESTAURANT_LIST.getNumberOfAffiliates() ; loopCnt++) {
                if (jbtRestaurantList[loopCnt] == buttonClicked)
                    SELECTED_REST = OrderUI.RESTAURANT_LIST.getAffiliatesEntry(loopCnt + 1);
            }
            
            for (int loopCnt = 0 ; loopCnt < SELECTED_REST.getMenuList().getNumberOfMenu() ; loopCnt++) {
                if (SELECTED_REST.getMenu(loopCnt + 1).getMenuStatus().equalsIgnoreCase("available")) {
                    OrderUI.changePanel(new SelectMenuItem((SELECTED_REST.getMenu(loopCnt + 1))));
                    break;
                }
            }
        }
    }
}
