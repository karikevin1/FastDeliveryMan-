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
public class DeleteMenu extends JFrame {
    private JLabel jblmenuID = new JLabel("Menu ID :");
    private JLabel jblmenuName = new JLabel("Menu Name :");
    
    private JTextField jtfmenuID = new JTextField();
    private JTextField jtfmenuName = new JTextField();
    
    private JButton jbtDeleteMenu = new JButton("Delete Menu");
    private JButton jbtReset = new JButton("Reset");
    
    
    public MenuInterface<Menu> menuList = new MenuList<>();
    
    public DeleteMenu(){
        menuList();
        setTitle("Delete Menu");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblmenuID.setHorizontalAlignment(SwingConstants.CENTER);
        jblmenuName.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblmenuID.setVerticalAlignment(SwingConstants.CENTER);
        jblmenuName.setVerticalAlignment(SwingConstants.CENTER);
        
        JPanel jpNew = new JPanel(new GridLayout(5,2));
        jpNew.add(jblmenuID);
        jpNew.add(jtfmenuID);
        jpNew.add(jblmenuName);
        jpNew.add(jtfmenuName);
        jpNew.add(jbtDeleteMenu);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        SearchListener foodListener = new SearchListener();
        jtfmenuID.addActionListener(foodListener);
        DeleteMenuListener deleteListener = new DeleteMenuListener();
        jbtDeleteMenu.addActionListener(deleteListener);
        ResetListener resetListener = new ResetListener();
        jbtReset.addActionListener(resetListener);
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
                    }else if(menuID == menuID2){
                        jtfmenuName.setText("" + menuList.getMenuEntry(2).getMenuName());                    
                    }else if(menuID == menuID3){
                        jtfmenuName.setText("" + menuList.getMenuEntry(3).getMenuName());        
                    }else if(menuID == menuID4){
                        jtfmenuName.setText("" + menuList.getMenuEntry(4).getMenuName());         
                    }else if(menuID == menuID5){
                        jtfmenuName.setText("" + menuList.getMenuEntry(5).getMenuName());
                    }else {
                        JOptionPane.showMessageDialog(null, "No such menu items");
                        clearText();
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "No such menu items");
                }
            }
    }
    
        private class DeleteMenuListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                try{
                int menuID = Integer.parseInt(jtfmenuID.getText());
                String menuName = jtfmenuName.getText();
                
                for(int i = 1; i < menuList.getNumberOfMenu(); i ++){
                menuList.DeleteMenu(i).getMenuID();
                }
                
                JOptionPane.showConfirmDialog(null, "Do you want to delete this menu?");
                JOptionPane.showMessageDialog(null, "Menu has been deleted");
                clearText();
                
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Text Field cannot be blank");
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
            
        }
         public void menuList(){
            menuList.addMenu(new Menu(1, "X'mas", "Available", "In Promotion"));
            menuList.addMenu(new Menu(2, "Lunar New Year", "Not Available", "Not in promotion"));
            menuList.addMenu(new Menu(3, "Chinese New Year", "Not Available", "In Promotion"));
            menuList.addMenu(new Menu(4, "Hari Raya", "Available", "Not in promotion"));
            menuList.addMenu(new Menu(5, "Deepavali", "Available", "In Promotion"));
            
        }
    
}
