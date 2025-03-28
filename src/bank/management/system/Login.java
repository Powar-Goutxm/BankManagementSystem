/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//Bank Management System 

 //Login class 
public class Login extends JFrame implements ActionListener{
    //Global declaration
    JButton signin,clear,signup;
    JTextField cardTField;
    JPasswordField pinTField;
    
     //Constructor of Login class
    Login(){
    //creating the Frame  
    setSize(750,500);
    setLocation(250,100);
    setVisible(true); 
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bank");
    
    //Setting the Icon
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bankk.jpg"));
    Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2); 
    JLabel label=  new JLabel(i3);
    add(label);
   
    label.setBounds(70, 10, 100, 100);
     setLayout(null);
     getContentPane().setBackground(Color.white);
   
        //setting headline
    JLabel text = new JLabel("Welcome to the Bank ");
    text.setBounds(225, 40, 400, 40);
    text.setFont(new Font("Osward", Font.BOLD,35));
    add(text);
   
    //card no
    JLabel cardno = new JLabel("Card No: "); 
    cardno.setFont(new Font("Osward", Font.BOLD,25));
    cardno.setBounds(120, 150, 150, 30);
    add(cardno);
    cardTField = new JTextField();
    cardTField.setFont(new Font("Arial",Font.BOLD,15));
    cardTField.setBounds(250, 150, 250, 30);
    add(cardTField);
    
     //Pin no
    JLabel pin = new JLabel("PIN No: "); 
    pin.setBounds(120, 220, 400, 40);
    pin.setFont(new Font("Osward", Font.BOLD,25));
    add(pin);
    pinTField = new JPasswordField();
    pinTField.setFont(new Font("Arial",Font.BOLD,15));
    cardTField.setBounds(250, 150, 250, 30);
    pinTField.setBounds(250, 220, 250, 40);
    add(pinTField);
     
     //signin button
       signin =new JButton("SIGN IN");
       signin.setBounds(250, 300, 100, 30);
       signin.setBackground(Color.blue);
       signin.setForeground(Color.white);
       signin.addActionListener(this);
       add(signin);
       
       //Clear button
      clear =new JButton("CLEAR");
      clear.setBounds(400, 300, 100, 30);
      clear.setBackground(Color.blue);
      clear.setForeground(Color.white);
      clear.addActionListener(this);
      add(clear);
       
       //signup button
      signup =new JButton("SIGN UP");
      signup.setBounds(300, 350, 150, 30);
      signup.setBackground(Color.blue);
      signup.setForeground(Color.white);
      signup.addActionListener(this);
      add(signup);
    }
    //Button working
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == signin){
           
        }else if(e.getSource() == clear){
            cardTField.setText("");
            pinTField.setText("");
        }else if(e.getSource() == signup){
            setVisible(false);
           new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    } 
}
