package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String cardnumber,pinnumber;
    BalanceEnquiry(String cardnumber,String pinnumber){   // parameterised constructor
        this.cardnumber = cardnumber ;
        this.pinnumber = pinnumber ;
        setLayout(null);
        setSize(900,900);                                
        setLocation (300,0);
        setVisible(true);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage() .getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0 , 0 ,900,900);
         add(image);
        
        back = new JButton ("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        connection conn = new connection();
        Double balance = 0.00;
        
        try {
           String balanceQuery = "SELECT Balance FROM Transaction WHERE Card_No = '" + cardnumber + "' ORDER BY Trans_Date DESC LIMIT 1";
                                  ResultSet rs = conn.statement.executeQuery(balanceQuery);
            
                                   if(rs.next()) {
                                     balance = Double.parseDouble(rs.getString("Balance"));
                                     }      
        }catch (Exception e ){
            System.out.println(e);
        }
        
       JLabel text = new JLabel("Your Current Account Balance Is Rs " + balance);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System", Font.BOLD, 17));
       text.setBounds(162,385,400,30);
       image.add(text);  
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(cardnumber,pinnumber).setVisible(true);
    }
    public static void main (String agrs[]){
        new BalanceEnquiry("", "");
        
    }
    
}
