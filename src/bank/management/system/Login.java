/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//Bank Management System 

 //Login class 
public class Login extends JFrame implements ActionListener{
    //Global declaration
    JButton loginB,clearB,signupB;
    JTextField userNameTField;
    JPasswordField passwordTField;
    JRadioButton customerRB,adminRB;
    
     //Constructor of Login class
    Login(){
    //creating the Frame  
    setSize(750,500);
    setLocation(250,100);
    setVisible(true); 
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bank Login");
    
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
   
    //username
    JLabel username = new JLabel("Username: "); 
    username.setFont(new Font("Osward", Font.BOLD,25));
    username.setBounds(120, 150, 150, 30);
    add(username);
    userNameTField = new JTextField();
    userNameTField.setFont(new Font("Arial",Font.BOLD,15));
    userNameTField.setBounds(250, 150, 250, 30);
    userNameTField.setToolTipText("Enter Your Username or Email");
    add(userNameTField);
    
     //password
    JLabel pass = new JLabel("Password: "); 
    pass.setBounds(120, 220, 400, 40);
    pass.setFont(new Font("Osward", Font.BOLD,25));
    add(pass);
    passwordTField = new JPasswordField();
    passwordTField.setFont(new Font("Arial",Font.BOLD,15));
    passwordTField.setBounds(250, 220, 250, 30);
    passwordTField.setToolTipText("Enter Your Password");
    add(passwordTField);
     
    //choose role
    JLabel role = new JLabel("Login as:");
    role.setBounds(180, 270, 150, 27);
    role.setFont(new Font("Arial",Font.PLAIN,15));
    add(role);
    
    customerRB = new JRadioButton("Customer", true);
    customerRB.setBounds(250, 270, 100, 25);
    customerRB.setBackground(Color.white);
    add(customerRB);
    adminRB = new JRadioButton("Admin");
    adminRB.setBackground(Color.white);
    adminRB.setBounds(390, 270, 100, 25);
    add(adminRB);
    
    ButtonGroup roleGroup = new ButtonGroup();
    roleGroup.add(customerRB);
    roleGroup.add(adminRB);
    
     //Login button
       loginB =new JButton("LOGIN");
       loginB.setBounds(250, 320, 100, 30);
       loginB.setBackground(Color.blue);
       loginB.setForeground(Color.white);
       loginB.addActionListener(this);
       add(loginB);
       
       //Clear button
      clearB =new JButton("CLEAR");
      clearB.setBounds(400, 320, 100, 30);
      clearB.setBackground(Color.blue);
      clearB.setForeground(Color.white);
      clearB.addActionListener(this);
      add(clearB);
       
      
       //signup button
    JLabel signupMsg = new JLabel("Don't have an account?");
    signupMsg.setBounds(250, 390, 190, 27);
    signupMsg.setFont(new Font("Arial",Font.PLAIN,14));
    add(signupMsg);
       
      signupB =new JButton("SIGN UP");
      signupB.setBounds(400, 390, 82, 27);
      signupB.setBackground(Color.blue);
      signupB.setForeground(Color.white);
      signupB.addActionListener(this);
      add(signupB);
    }
    //Button working
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginB){
            String username = userNameTField.getText();
            String password = new String (passwordTField.getPassword());
            
            try{
                connection login = new connection();
                String query = "SELECT * FROM login WHERE Username = ? AND Password = ?";
                
                PreparedStatement pstmt = login.conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Succesfull");
                //new Dashboard().setVisible(true);
                dispose();
                }
                else{
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }        
        }else if(e.getSource() == clearB){
            userNameTField.setText("");
            passwordTField.setText("");
        }else if(e.getSource() == signupB){
           dispose();
           new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
       Login login = new Login();
    } 
}
