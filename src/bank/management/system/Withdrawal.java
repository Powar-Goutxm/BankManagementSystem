package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Withdrawal extends JFrame implements ActionListener{
    JButton withdraw,back;
    String cardnumber,pinnumber;
    JTextField amount;
    
    Withdrawal(String cardnumber,String pinnumber){
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
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
                String DepAmt = amount.getText();
                double depositAmount = Double.parseDouble(DepAmt);
                java.util.Date date = new java.util.Date();
                
                
                if(DepAmt.equals("")){
                        JOptionPane.showMessageDialog(null,"Amount Field Empty! Please Enter the amount");
                        
                    }else{
                            try{  
                                  connection conn = new connection();
                                  
                                  String balanceQuery = "SELECT Balance FROM Transaction WHERE Card_No = '" + cardnumber + "' ORDER BY Trans_Id DESC LIMIT 1";
                                  ResultSet rs = conn.statement.executeQuery(balanceQuery);
            
                                   if(rs.next()) {
                                     balance = Double.parseDouble(rs.getString("Balance"));
                                     }                 
                                        
                                        
                                        if(depositAmount <= balance){
                                            balance -= depositAmount;
                                            String query = "INSERT INTO Transaction (Card_No, Pin_No, Trans_Date, Trans_Type, Amount, Balance) " +
"VALUES ('"+cardnumber+"', '"+pinnumber+"', '"+date+"', 'Withdraw', '"+DepAmt+"', '"+balance+"')";
                                            conn.statement.executeUpdate(query);
                                            JOptionPane.showMessageDialog(null, "Rs " +DepAmt+ ".00"+ " Withdraw Succesfull");
                                        
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Insufficeient Balance! Enter Again");
                                             }
                                        
                            }catch(Exception ae){
                                ae.printStackTrace();
                            }
                        setVisible(false);
                        new Transactions(cardnumber,pinnumber).setVisible(true);
                    }
                
                    
            }else if(e.getSource() == back){
                setVisible(false);
                new Transactions(cardnumber,pinnumber).setVisible(true);
            }
        
        }
    public static void main(String[] args){
        new Withdrawal("","");
    }
}
