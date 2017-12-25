/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA;
import ModuleA.adt.MenuInterface;
import ModuleA.adt.MenuList;
import ModuleA.entity.Menu;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class UpdateMenuStatus extends JFrame{
    private JLabel jblmenuID = new JLabel("Menu ID :");
    private JLabel jblmenuName = new JLabel("Menu Name :");
    private JLabel jblcurrentMenuStatus = new JLabel("Menu Status");
    private JLabel jblcurrentPromotion = new JLabel("Promotion Status");
    private JLabel jblselectStatus = new JLabel("Select Menu Status");
    private JLabel jblselectPromotion = new JLabel("Select Promotion Status");
    
    private JTextField jtfmenuID = new JTextField();
    private JTextField jtfmenuName = new JTextField();
    private JTextField jtfmenuStatus = new JTextField();
    private JTextField jtfPromotionStatus = new JTextField();
    String[] promoStatusList = new String[]{"In Promotion", "Not in Promotion"};
    JComboBox<String> jcbpromoStatus = new JComboBox<>(promoStatusList);
    String[] menuStatusList = new String[]{"Available", "Not Available"};
    JComboBox<String> jcbmenuStatus = new JComboBox<>(menuStatusList);
    
    
    private JTextArea jtamenuList = new JTextArea(20, 20);
    
    private JButton jbtUpdateMenu = new JButton("Update Menu");
    private JButton jbtReset = new JButton("Reset");
    
    
    public MenuInterface<Menu> menuList = new MenuList<>();
    
    public UpdateMenuStatus(){
        menuList();
        setTitle("Update Menu Status");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblmenuID.setHorizontalAlignment(SwingConstants.CENTER);
        jblmenuName.setHorizontalAlignment(SwingConstants.CENTER);
        jblcurrentMenuStatus.setHorizontalAlignment(SwingConstants.CENTER);
        jblcurrentPromotion.setHorizontalAlignment(SwingConstants.CENTER);
        jblselectStatus.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblmenuID.setVerticalAlignment(SwingConstants.CENTER);
        jblmenuName.setVerticalAlignment(SwingConstants.CENTER);
        jblcurrentMenuStatus.setVerticalAlignment(SwingConstants.CENTER);
        jblcurrentPromotion.setVerticalAlignment(SwingConstants.CENTER);
        jblselectStatus.setVerticalAlignment(SwingConstants.CENTER);
        
        jtamenuList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(7,2));
        jpNew.add(jblmenuID);
        jpNew.add(jtfmenuID);
        jpNew.add(jblmenuName);
        jpNew.add(jtfmenuName);
        jpNew.add(jblcurrentMenuStatus);
        jpNew.add(jtfmenuStatus);
        jpNew.add(jblcurrentPromotion);
        jpNew.add(jtfPromotionStatus);
        jpNew.add(jblselectStatus);
        jpNew.add(jcbmenuStatus);
        jpNew.add(jblselectPromotion);
        jpNew.add(jcbpromoStatus);
        jpNew.add(jbtUpdateMenu);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        SearchListener foodListener = new SearchListener();
        jtfmenuID.addActionListener(foodListener);
        UpdateMenuListener updateListener = new UpdateMenuListener();
        jbtUpdateMenu.addActionListener(updateListener);
        ResetListener resetListener = new ResetListener();
        jbtReset.addActionListener(resetListener);
        JScrollPane scrollPane = new JScrollPane(jtamenuList);
        add(scrollPane, BorderLayout.CENTER);
    }
    
     private class SearchListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int menuID = Integer.parseInt(jtfmenuID.getText());
                    
                    int menuID1 = menuList.getMenuEntry(1).getMenuID();
                    int menuID2 = menuList.getMenuEntry(2).getMenuID();
                    int menuID3 = menuList.getMenuEntry(3).getMenuID();
                    int menuID4 = menuList.getMenuEntry(4).getMenuID();
                    int menuID5 = menuList.getMenuEntry(5).getMenuID();
                    
                    if(menuID == menuID1){
                        jtfmenuName.setText("" + menuList.getMenuEntry(1).getMenuName());
                        jtfmenuStatus.setText("" + menuList.getMenuEntry(1).getMenuStatus());
                        jtfPromotionStatus.setText("" + menuList.getMenuEntry(1).getMenuPromo());
                    }else if(menuID == menuID2){
                        jtfmenuName.setText("" + menuList.getMenuEntry(2).getMenuName());
                        jtfmenuStatus.setText("" + menuList.getMenuEntry(2).getMenuStatus());
                        jtfPromotionStatus.setText("" + menuList.getMenuEntry(2).getMenuPromo());
                    }else if(menuID == menuID3){
                        jtfmenuName.setText("" + menuList.getMenuEntry(3).getMenuName());
                        jtfmenuStatus.setText("" + menuList.getMenuEntry(3).getMenuStatus());
                        jtfPromotionStatus.setText("" + menuList.getMenuEntry(3).getMenuPromo());
                    }else if(menuID == menuID4){
                        jtfmenuName.setText("" + menuList.getMenuEntry(4).getMenuName());
                        jtfmenuStatus.setText("" + menuList.getMenuEntry(4).getMenuStatus());
                        jtfPromotionStatus.setText("" + menuList.getMenuEntry(4).getMenuPromo());
                    }else if(menuID == menuID5){
                        jtfmenuName.setText("" + menuList.getMenuEntry(5).getMenuName());
                        jtfmenuStatus.setText("" + menuList.getMenuEntry(5).getMenuStatus());
                        jtfPromotionStatus.setText("" + menuList.getMenuEntry(5).getMenuPromo());
                    }else {
                        JOptionPane.showMessageDialog(null, "No such menu items");
                        clearText();
                    }
                }catch(Exception ex){
                
                }
            }
     }
            private class UpdateMenuListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                    try{
                    int menuID = Integer.parseInt(jtfmenuID.getText());
                    String menuName = jtfmenuName.getText();
                    String currentMenuStatus = jtfmenuStatus.getText();
                    String menuStatus = jcbmenuStatus.getSelectedItem().toString();
                    String menuPromo = jcbpromoStatus.getSelectedItem().toString();

                
                    Menu menu = new Menu(menuID, menuName, menuStatus, menuPromo);

                    menuList.updateMenu(menuID, menu);
                

                    JOptionPane.showConfirmDialog(null, "Do you want to update this menu?");
                    JOptionPane.showMessageDialog(null, "Menu has been updated");
                    jtamenuList.setText("Menu ID        Menu Name       Status      Promotion\n" + menuList.getMenuEntry(menuID) + "\n");
                
                    menu.setMenuID(Integer.parseInt(jtfmenuID.getText()));
                    menu.setMenuName(jtfmenuName.getText());
                    menu.setMenuStatus(jtfmenuStatus.getText());
                    menu.setMenuStatus(jcbmenuStatus.getSelectedItem().toString());
                    
                    clearText();
                }catch(Exception ex){
                    jtamenuList.setText("Text field cannot be blank");
                }
            }
                
                
            }
            
             private class ResetListener implements ActionListener {
             public void actionPerformed(ActionEvent e) {
                 clearText();
             }
        }
            public void clearText(){
            jtfmenuID.setText("");
            jtfmenuName.setText("");
            jtfmenuStatus.setText("");
            
            }

            public void menuList(){
            menuList.addMenu(new Menu(1, "X'mas", "Available", "In Promotion"));
            menuList.addMenu(new Menu(2, "Lunar New Year", "Not Available", "Not in promotion"));
            menuList.addMenu(new Menu(3, "Chinese New Year", "Not Available", "In Promotion"));
            menuList.addMenu(new Menu(4, "Hari Raya", "Available", "Not in promotion"));
            menuList.addMenu(new Menu(5, "Deepavali", "Available", "In Promotion"));
            
            }
}
