package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{
    JButton Deposit,Withdrawal,Mstatement,Pinchange,Balance,Exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setSize(900, 900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Transaction");
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imagelabel = new JLabel(i3);
        imagelabel.setBounds(0,0,900,900);
        add(imagelabel);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210, 230, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        imagelabel.add(text);
       
        Deposit = new JButton("Cash Deposit");
        Deposit.setBounds(170,375,130,30);
        Deposit.addActionListener(this);
        imagelabel.add(Deposit);
        
        Withdrawal = new JButton("Cash Withdrawal");
        Withdrawal.setBounds(355,375,133,30);
        Withdrawal.addActionListener(this);
        imagelabel.add(Withdrawal);
        
        Mstatement = new JButton("Mini Statement");
        Mstatement.addActionListener(this);
        Mstatement.setBounds(170,413,130,30);
        imagelabel.add(Mstatement);
        
        Pinchange = new JButton("Pin Change");
        Pinchange.addActionListener(this);
        Pinchange.setBounds(355,413,133,30);
        imagelabel.add(Pinchange);
        
        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(170,450,130,30);
        Balance.addActionListener(this);
        imagelabel.add(Balance);
        
        Exit = new JButton("Exit");
        Exit.setBounds(355,450,133,30);
        Exit.addActionListener(this);
        imagelabel.add(Exit);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == Exit){
        System.exit(0);
        
        }else if(e.getSource() == Deposit){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
        
        }else if(e.getSource() == Withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        
    }
    
    public static void main (String[] args){
        Transactions trans = new Transactions("");
    }
}
