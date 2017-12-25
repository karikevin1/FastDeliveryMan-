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
public class CreateMenu extends JFrame {
    private JLabel jblmenuID = new JLabel("Menu ID :");
    private JLabel jblmenuName = new JLabel("Menu Name :");
    private JLabel jblmenuStatus = new JLabel("Status :");
    private JLabel jblpromoStatus = new JLabel("Promotion :");
    
    private JTextField jtfmenuID = new JTextField();
    private JTextField jtfmenuName = new JTextField();
    String[] menuStatusList = new String[]{"Available", "Not Available"};
    JComboBox<String> jcbmenuStatus = new JComboBox<>(menuStatusList);
    String[] promoStatusList = new String[]{"In Promotion", "Not in Promotion"};
    JComboBox<String> jcbpromoStatus = new JComboBox<>(promoStatusList);
    
    private JTextArea jtamenuList = new JTextArea(20, 20);
    
    private JButton jbtCreateMenu = new JButton("Create Menu");
    private JButton jbtReset = new JButton("Reset");
    
    
    public MenuInterface<Menu> menuList = new MenuList<>();
    
    public CreateMenu(){
        menuList();
        setTitle("Create Menu");
        Font font = new Font("Arial", Font.BOLD, 18);
        jblmenuID.setHorizontalAlignment(SwingConstants.CENTER);
        jblmenuName.setHorizontalAlignment(SwingConstants.CENTER);
        jblmenuStatus.setHorizontalAlignment(SwingConstants.CENTER);
        jblpromoStatus.setHorizontalAlignment(SwingConstants.CENTER);
        
        jblmenuID.setVerticalAlignment(SwingConstants.CENTER);
        jblmenuName.setVerticalAlignment(SwingConstants.CENTER);
        jblmenuStatus.setVerticalAlignment(SwingConstants.CENTER);
        jblpromoStatus.setVerticalAlignment(SwingConstants.CENTER);
        
        jtamenuList.setEditable(false);
        JPanel jpNew = new JPanel(new GridLayout(5,2));
        jpNew.add(jblmenuID);
        jpNew.add(jtfmenuID);
        jpNew.add(jblmenuName);
        jpNew.add(jtfmenuName);
        jpNew.add(jblmenuStatus);
        jpNew.add(jcbmenuStatus);
        jpNew.add(jblpromoStatus);
        jpNew.add(jcbpromoStatus);
        jpNew.add(jbtCreateMenu);
        jpNew.add(jbtReset);
        add(jpNew, BorderLayout.NORTH);
        
        CreateMenuListener createListener = new CreateMenuListener();
        jbtCreateMenu.addActionListener(createListener);
        JScrollPane scrollPane = new JScrollPane(jtamenuList);
        add(scrollPane, BorderLayout.CENTER);
        
    }
     private class CreateMenuListener implements ActionListener{
            public void actionPerformed(ActionEvent e){   
                try{

                int menuID = Integer.parseInt(jtfmenuID.getText());
                String menuName = jtfmenuName.getText();
                String menuStatus = jcbmenuStatus.getSelectedItem().toString();
                String promoStatus = jcbpromoStatus.getSelectedItem().toString();
                
                Menu menu = new Menu(menuID, menuName, menuStatus, promoStatus);
                
                
                menuList.addMenu(menuID, menu);
                
                
                JOptionPane.showConfirmDialog(null, "Do you want to create this Menu?");
                JOptionPane.showMessageDialog(null, "Menu has been created");

                jtamenuList.setText("Menu ID        Menu Name       Status      Promotion\n"  + menuList.getMenuEntry(menuID).toString() + "\n\nCurrent Menu List added :" + menuList.getNumberOfMenu());
                
                menu.setMenuID(Integer.parseInt(jtfmenuID.getText()));
                menu.setMenuName(jtfmenuName.getText());
                menu.setMenuStatus(jcbmenuStatus.getSelectedItem().toString());
               

                clearText();
            }catch(Exception ex){
                jtamenuList.setText("Wrong Format / Text Field cannot be blank");
            }
            }
            public void clearText(){
                jtfmenuID.setText("");
                jtfmenuName.setText("");  
            }
            
           
            
           
     }
      public void menuList(){
            
            
            }

}
