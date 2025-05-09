package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{
    JButton Deposit,Withdrawal,Mstatement,Pinchange,Balance,Exit;
    String cardnumber,pinnumber;
    
    Transactions(String cardnumber ,String pinnumber){
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
        setSize(980, 900);
        setLocation(220,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Transaction");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(980,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imagelabel = new JLabel(i3);
        imagelabel.setBounds(0 ,0,980,900);
        add(imagelabel);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220, 280, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 18));
        text.setForeground(Color.WHITE);
        imagelabel.add(text);
       
        Deposit = new JButton("Cash Deposit");
        Deposit.setBounds(190,375,130,30);
        Deposit.addActionListener(this);
        imagelabel.add(Deposit);
        
        Withdrawal = new JButton("Cash Withdrawal");
        Withdrawal.setBounds(390,375,133,30);
        Withdrawal.addActionListener(this);
        imagelabel.add(Withdrawal);
        
        Mstatement = new JButton("Mini Statement");
        Mstatement.addActionListener(this);
        Mstatement.setBounds(190,413,130,30);
        imagelabel.add(Mstatement);
        
        Pinchange = new JButton("Pin Change");
        Pinchange.addActionListener(this);
        Pinchange.setBounds(390,413,133,30);
        imagelabel.add(Pinchange);
        
        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(190,450,130,30);
        Balance.addActionListener(this);
        imagelabel.add(Balance);
        
        Exit = new JButton("Exit");
        Exit.setBounds(390,450,133,30);
        Exit.addActionListener(this);
        imagelabel.add(Exit);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == Exit){
        System.exit(0);
        
        }else if(e.getSource() == Deposit){
        setVisible(false);
        new Deposit(cardnumber,pinnumber).setVisible(true);
        
        }else if(e.getSource() == Withdrawal){
            setVisible(false);
            new Withdrawal(cardnumber,pinnumber).setVisible(true);
            
        }else if(e.getSource() == Balance){
            setVisible(false);
            new BalanceEnquiry(cardnumber,pinnumber).setVisible(true);
            
        }else if(e.getSource() == Pinchange){
            setVisible(false);
            new PinChange(cardnumber,pinnumber).setVisible(true);
        }
        
        else if(e.getSource() == Mstatement){
            new MiniStatement(cardnumber,pinnumber).setVisible(true);
        }
    }
    
    public static void main (String[] args){
        Transactions trans = new Transactions("" ,"");
    }
}
