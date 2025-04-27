/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    setSize(690,720);
    setLocation(350,10);
    setVisible(true);
    setLayout(null);
     setTitle("Customer Dashboard");
   }
}
