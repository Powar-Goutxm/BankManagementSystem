package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeactivateAccount extends JFrame implements ActionListener{
        JButton deactivate,back;
        String transID,accountID;
        
        DeactivateAccount(String transID,String accountID){
        this.accountID = accountID;
        this.transID = transID;   
            
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         JLabel text = new JLabel ("Deactivate Your Account");
            text.setForeground(Color.WHITE);
            text.setFont(new Font ("Sytem",Font.BOLD ,16));
            text.setBounds(250,310,500,35);
            image.add(text);
            
            JLabel warning = new JLabel("Warning: This action will disable access to your account");
            warning.setForeground(Color.RED);
            warning.setFont(new Font("System", Font.BOLD, 14));
            warning.setBounds(150, 370, 500, 35);
            image.add(warning);
            
            deactivate = new JButton("Deactivate");  
            deactivate.setBounds(170,452,135,30);
            deactivate.addActionListener(this);
            image.add(deactivate);
            
            back = new JButton("Back");
            back.setBounds(370,452,135,30);
            back.addActionListener(this);
            image.add(back);
        }
        
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == back){
                setVisible(false);
                new Transactions(transID,accountID);
                
            }else if(e.getSource() == deactivate){
                int response = JOptionPane.showConfirmDialog(null,"Are you sure you want to deactivate your account?\nThis will prevent future logins.",
                "Confirm Deactivation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
                if (response == JOptionPane.YES_OPTION) {
                     try {
                    connection conn = new connection();
                    // Update the SQL query to only affect the current account
                    String query = "UPDATE Account SET Account_Status = 'Deactive' WHERE AccountID = '" + accountID + "'";
                    int rowsAffected = conn.statement.executeUpdate(query);
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Your account has been deactivated successfully.\nYou will now be logged out.",
                            "Account Deactivated", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                        setVisible(false);
                        new Login().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Failed to deactivate account. Please try again or contact support.",
                            "Deactivation Failed", 
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                    conn.statement.close();
                    conn.conn.close();
                    
                } catch (Exception xe) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Database error occurred: " + xe.getMessage(),
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                    xe.printStackTrace();
                }
                }
              
            }
        }
        
        public static void main (String[] args){
            new DeactivateAccount("","");
        }
}
