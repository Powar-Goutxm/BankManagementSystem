package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerDashboard extends JFrame {
    private int customerId;
    
    CustomerDashboard(int customerId){
        
        this.customerId = customerId;
    getContentPane().setBackground(Color.white);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(690,600);
    setLocation(350,50);
    setVisible(true);
    setLayout(null);
     setTitle("Customer Dashboard");
     
     JLabel idLabel = new JLabel("Your Customer ID: " + customerId);
        idLabel.setBounds(50, 50, 300, 30);
        add(idLabel);
   }
    
    public static void main(String[] args){
   CustomerDashboard customer = new CustomerDashboard(1);
    }
}
