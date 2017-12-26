package Client;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kevin lim
 */
public class LoginSystem extends JFrame{
    private JLabel jlbTitle = new JLabel("FastDeliveryMan sdn.bhd");
    private JLabel jlbUsername = new JLabel("Username: ");
    private JLabel jlbPassword = new JLabel("Password: ");

    private JTextField jtfName = new JTextField();
    private JTextField jtfPassword = new JTextField();
    private JButton loginButton = new JButton("Login");

    public static String username = "";
    public static String password = "";
     
    private static LoginAccount[] loginAccountArr;
    public static LoginAccount user;
    
    public static LoginAccount getLoginAccount() {
        return user;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        LoginSystem.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        LoginSystem.password = password;
    } 
     
     public LoginSystem(){
        setTitle("Fast Delivery Man");
        Font fontTitle = new Font("Arial", Font.BOLD, 36);
        Font font = new Font("Arial", Font.BOLD, 18);
        loginButton.setFont(font);
        
        jlbTitle.setFont(fontTitle);
        jlbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        jlbUsername.setHorizontalAlignment(SwingConstants.CENTER);
        jlbPassword.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        JPanel jplLogin = new JPanel(new GridLayout(0,2));
        JPanel jplTop = new JPanel();
        JPanel jplBot = new JPanel();
        jplTop.add(jlbTitle);
        add(jplTop, BorderLayout.NORTH);
        jplLogin.add(jlbUsername);
        jplLogin.add(jtfName);
        jplLogin.add(jlbPassword);
        jplLogin.add(jtfPassword);
        add(jplLogin);
        jplBot.add(loginButton);
        add(jplBot, BorderLayout.SOUTH);
        
        LoginButtonListener listener = new LoginButtonListener();
        loginButton.addActionListener(listener);
     }
     
     private class LoginButtonListener implements ActionListener {
    @Override
        public void actionPerformed(ActionEvent e) {
                username = jtfName.getText();
                password = jtfPassword.getText();
                
                for (int i = 0 ; i < loginAccountArr.length ; i++) {
                    if (username.equalsIgnoreCase(loginAccountArr[i].getAccountID()) && password.equalsIgnoreCase(loginAccountArr[i].getPassword())) {
                        user = loginAccountArr[i];
                        break;
                    }
                }
                
                if (user != null) {
                    MainMenu mn = new MainMenu();
                    mn.getContentPane().setPreferredSize(new Dimension(600, 500));
                    mn.pack();
                    mn.setLocationRelativeTo(null);
                    mn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    mn.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter another ID or Password.", "Loggin Failed", JOptionPane.ERROR_MESSAGE);
                }
        }
    }
     
    public static void main(String[] args) {
        LoginSystem frame = new LoginSystem();
        frame.initLoginAccount();
        frame.getContentPane().setPreferredSize(new Dimension(650, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public void initLoginAccount() {
        loginAccountArr = new LoginAccount[4];
        loginAccountArr[0] = new LoginAccount("customer", "1", "customer");
        loginAccountArr[1] = new LoginAccount("manager", "2", "manager");
        loginAccountArr[2] = new LoginAccount("hr", "3", "hr");
        loginAccountArr[3] = new LoginAccount("deliveryman", "4", "deliveryman");
        
    }
    
    public class LoginAccount {
        String accountID;
        String password;
        String type;

        public LoginAccount(String accountID, String password, String type) {
            this.accountID = accountID;
            this.password = password;
            this.type = type;
        }

        public String getAccountID() {
            return accountID;
        }

        public void setAccountID(String accountID) {
            this.accountID = accountID;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
