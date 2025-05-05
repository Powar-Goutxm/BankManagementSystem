package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String pinchange;
    BalanceEnquiry(String pinchange){   // parameterised constructor
        this.pinchange = pinchange ;
        setLayout(null);
        setSize(900,900);                                
        setLocation (300,0);
        setUndecorated(true);
        setVisible(true);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/3923.jpg"));
        Image i2 = i1.getImage() .getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
        image.setBounds(0 , 0 ,900,900);
         add(image);
        
        back = new JButton ("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        connection c = new connection();
        int balance = 0;
        /*
        try {
            ResultSet rs = c.statement.executeQuery("SELECT * FROM BANK WHERE pin = " +pinnumber+"'");           
            while(rs.next()) {
             if ( rs.getString("type").equals("Deposit")){
                 balance += Integer.parseInt(rs.getString("amount"));
             } else {
                 balance -= Integer.parseInt(rs.getString("amount"));
             }
               
            }   
        }catch (Exception e ){
            System.out.println(e);
        }
        */
       JLabel text = new JLabel("Your Current Account Balance Is Rs" + balance);
       text.setForeground(Color.WHITE);
       text.setBounds(170,300,400,30);
       image.add(text);  
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinchange).setVisible(true);
    }
    public static void main (String agrs[]){
        new BalanceEnquiry(" ");
        
    }
    
}
