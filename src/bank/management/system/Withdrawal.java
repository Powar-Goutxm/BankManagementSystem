package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener{
    JButton withdraw,back;
    String transID,accountID;
    JTextField amount;
    
    Withdrawal(String transID,int accountID){
    this.transID = transID;
    this.accountID = String.valueOf(accountID);
    
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
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 350, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        amount.setBounds(170, 390, 300, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(170,452,135,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(370,452,135,30);
        back.addActionListener(this);
        image.add(back);
    }
    
    public void actionPerformed(ActionEvent e){
        double balance = 0.00;
            if(e.getSource() == withdraw){
                String withdrawAmt = amount.getText();
                double withdrawAmount = Double.parseDouble(withdrawAmt);
                java.util.Date date = new java.util.Date();
                
                
                if(withdrawAmt.equals("")){
                        JOptionPane.showMessageDialog(null,"Amount Field Empty! Please Enter the amount");
                        
                    }else{
                            try{  
                                  connection conn = new connection();
                                  
                                   String balanceQuery = "SELECT Balance FROM Transaction WHERE AccountID = '" + accountID + "' ORDER BY Trans_Id DESC LIMIT 1";
                                  ResultSet rs = conn.statement.executeQuery(balanceQuery);
            
                                   if(rs.next()) {
                                     balance = Double.parseDouble(rs.getString("Balance"));
                                     }                 
                                        
                                        
                                        if(withdrawAmount <= balance){
                                            balance -= withdrawAmount;
                                            String query = "INSERT INTO Transaction (AccountID, Trans_Date, Trans_Type, Amount, Balance) " +
                                "VALUES ('" + accountID + "', '" + date + "', 'Withdraw', '" + withdrawAmt + "', '" + balance + "')";
                                            conn.statement.executeUpdate(query);
                                            rs.close();
                                            conn.statement.close();
                                            conn.conn.close();
                                            
                                            JOptionPane.showMessageDialog(null, "Rs " +withdrawAmt+ ".00"+ " Withdraw Succesfull");
                                        
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Insufficeient Balance! Enter Again");
                                             }
                                        
                            }catch(Exception ae){
                                ae.printStackTrace();
                            }
                        setVisible(false);
                        new Transactions(transID,accountID).setVisible(true);
                    }
                
                    
            }else if(e.getSource() == back){
                setVisible(false);
               new Transactions(transID,accountID).setVisible(true);
            }
        
        }
    public static void main(String[] args){
        new Withdrawal("",0);
    }
}
