package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Transactions extends JFrame {
    
    Transactions(){
        
        setSize(900, 900);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Transaction");
        getContentPane().setBackground(Color.WHITE);
        //setUndecorated(true);
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
       
        
    }
    
    public static void main (String[] args){
        Transactions trans = new Transactions();
    }
}
