package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,text;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1;
    ButtonGroup accountTypGrp;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(690,700);
        setLocation(350,20);
        setVisible(true);
        setLayout(null);
        
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(210, 73, 300, 28);
        add(l1);
        
        //icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankk.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel iconlabel = new JLabel(i3);
        iconlabel.setBounds(30, 0, 100, 100);
        add(iconlabel);
    
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        l2.setBounds(50,140,200,30);
        add(l2);
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD,15));
        r1.setBackground(Color.white);
        r1.setBounds(50,180,150,20); 
        add(r1);
        
        r2 = new JRadioButton("Fixed Account");
        r2.setFont(new Font("Raleway", Font.BOLD,15));
        r2.setBackground(Color.white);
        r2.setBounds(250,180,150,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD,15));
        r3.setBackground(Color.white);
        r3.setBounds(50,230,150,20);
        add(r3);
        
         accountTypGrp = new ButtonGroup();
         accountTypGrp.add(r1);
         accountTypGrp.add(r2);
         accountTypGrp.add(r3);
         accountTypGrp.add(r4);
         
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD,15));
        r4.setBackground(Color.white);
        r4.setBounds(250,230,300,20);
        add(r4);
        
        text = new JLabel("The Following Will Be Generated For Your Account:");
        text.setFont(new Font("Raleway", Font.BOLD, 14));
        text.setBackground(Color.WHITE);
        text.setBounds(50, 282, 600, 30);
        add(text);
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(50,310,200,30);
        add(l3);
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(280,310,250,30);
        add(l4);
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(50,340,200,20);
        add(l5);
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        l6.setBounds(280,340,500,20);
        add(l6);
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        l7.setBounds(50,380,200,30);
        add(l7);
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(280,380,200,30);
        add(l8);
        
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
        l9.setBounds(50,410,200,20);
        add(l9);
        
        l11 = new JLabel("Application Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 29));
        l11.setBounds(170, 20, 500, 35);
        add(l11);
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 29));
        l12.setBounds(700, 20, 150, 35);
        add(l12);
        
        c1 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c1.setFont(new Font("Raleway", Font.BOLD, 13));
        c1.setBackground(Color.WHITE);
        c1.setBounds(50, 450, 600, 30);
        add(c1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(160, 520, 90, 30);
        b1.setFont(new Font("Raleway", Font.BOLD, 14));  
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380, 520, 90, 30);
        b2.setFont(new Font("Raleway", Font.BOLD, 14));  
        b2.addActionListener(this);
        add(b2);
    }
    
    public void actionPerformed(ActionEvent e){
    if(e.getSource() == b1){
       String accountType = null;
           if(r1.isSelected()){
           accountType = "Savings Account";
           }
           else if(r2.isSelected()){
           accountType = "Fixed Account";
           }
           else if(r3.isSelected()){
           accountType = "Current Account";
           }
           else if(r4.isSelected()){
           accountType = "Recurring Deposit Account";
           }
           //Generating PinNo
           Random random = new Random();
           String cardNo = "" + Math.abs((random.nextLong() % 90000000L) + 233569000000L);
           
           //Default pinNo Generated
           String pinNo = "" + Math.abs((random.nextLong() & 9000L) + 1000L);
           
           try{
               if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
               }else{
                   connection conn = new connection();
                   String query1 = "INSERT INTO SignupThree VALUES ('"+formno+"', '"+accountType+"', '"+cardNo+"', '"+pinNo+"')";
                   String query2 = "INSERT INTO Login VALUES ('"+formno+"', '"+cardNo+"', '"+pinNo+"')";
                   conn.statement.executeUpdate(query1);
                   conn.statement.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: " + cardNo + "\n Pin No: " + pinNo);
                   
                   setVisible(false);
                   new Deposit(pinNo).setVisible(true);
               }
           }catch(Exception ae){
                ae.printStackTrace();
           }
           
        }else if(e.getSource() == b2){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
    SignupThree s3 = new SignupThree(""); 
    }
}
