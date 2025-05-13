package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener{
    JButton Deposit,Withdrawal,Mstatement,Pinchange,Balance,deactivate,Exit;
    String transID,accountID;
    
    Transactions(String transID,String accountID){
        this.transID = transID;
        this.accountID = accountID;
       
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
        text.setBounds(210, 280, 700, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 19));
        text.setForeground(Color.WHITE);
        imagelabel.add(text);
       
        Deposit = new JButton("Cash Deposit");
        Deposit.setBounds(180,375,145,31);
        Deposit.addActionListener(this);
        imagelabel.add(Deposit);
        
        Withdrawal = new JButton("Cash Withdrawal");
        Withdrawal.setBounds(390,375,145,31);
        Withdrawal.addActionListener(this);
        imagelabel.add(Withdrawal);
        
        Mstatement = new JButton("Mini Statement");
        Mstatement.addActionListener(this);
        Mstatement.setBounds(180,413,145,31);
        imagelabel.add(Mstatement);
        
        Pinchange = new JButton("Pin Change");
        Pinchange.addActionListener(this);
        Pinchange.setBounds(390,413,145,31);
        imagelabel.add(Pinchange);
        
        Balance = new JButton("Balance Enquiry");
        Balance.setBounds(180,450,145,31);
        Balance.addActionListener(this);
        imagelabel.add(Balance);
        
        deactivate = new JButton("Deactivate Account");
        deactivate.setBounds(390,450,145,31);
        deactivate.addActionListener(this);
        imagelabel.add(deactivate);
        
        Exit = new JButton("Exit");
        Exit.setBounds(390,487,145,31);
        Exit.addActionListener(this);
        imagelabel.add(Exit);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == Exit){
        System.exit(0);
        
        }else if(e.getSource() == Deposit){
        setVisible(false);
        new Deposit(Integer.parseInt(accountID)).setVisible(true);
        
        }else if(e.getSource() == Withdrawal){
            setVisible(false);
            new Withdrawal(transID,Integer.parseInt(accountID)).setVisible(true);
            
        }else if(e.getSource() == Balance){
            setVisible(false);
            new BalanceEnquiry(transID,Integer.parseInt(accountID)).setVisible(true);
            
        }else if(e.getSource() == Pinchange){
            setVisible(false);
            new PinChange(transID,accountID).setVisible(true);
        }
        else if(e.getSource() == Mstatement){
            new MiniStatement(transID,accountID).setVisible(true);
        }
        else if(e.getSource() == deactivate){
            new DeactivateAccount(transID,accountID).setVisible(true);
        }
    }
    
    public static void main (String[] args){
        Transactions trans = new Transactions("" ,"");
    }
}
