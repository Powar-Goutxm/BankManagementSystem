package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField pin;
    JPasswordField repin;
    JButton  change, exit;
    String transID,accountID;
    
    //constructor
    PinChange(String transID,String accountID){
        this.accountID = accountID;
        this.transID = transID;
        
        setSize(900,900);
        setUndecorated(true);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3923.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
            JLabel text = new JLabel ("CHANGE YOUR PIN");
            text.setForeground(Color.WHITE);
            text.setFont(new Font ("Sytem",Font.BOLD ,16));
            text.setBounds(250,310,500,35);
            image.add(text);
            
            JLabel pintext = new JLabel ("NEW PIN");
            pintext.setForeground(Color.WHITE);
            pintext.setFont(new Font ("Sytem",Font.BOLD ,16));
            pintext.setBounds(170,360,180,25);
            image.add(pintext);
            
            pin = new JTextField();
            pin.setFont(new Font ("Raleway", Font.BOLD, 20));
            pin.setBounds(330,360,180,25);
            image.add(pin);

             JLabel repintext = new JLabel ("RE-ENTER NEW PIN");
            repintext.setForeground(Color.WHITE);
            repintext.setFont(new Font ("Sytem",Font.BOLD ,16));
            repintext.setBounds(170,400,180,25);
            image.add(repintext);

            repin = new JPasswordField();
            repin.setFont(new Font ("Raleway" , Font.BOLD, 20));
            repin.setBounds(330,400,180,25);
            image.add(repin);
            
            change = new JButton("Change");  
            change.setBounds(170,452,135,30);
            change.addActionListener(this);
            image.add(change);
        
            exit = new JButton("Back");
            exit.setBounds(370,452,135,30);
            exit.addActionListener(this);
            image.add(exit);
    }
    
     public void actionPerformed(ActionEvent e){
        if(e.getSource() ==  change){
             try{
             String npin = pin.getText().trim();
             String rpin = new String(repin.getPassword()).trim();
             
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null, "Pins Do Not Match! Please Re-eneter Your Pin");
                 return;
             }
             
             if(npin.equals("") || repin.equals("")){
                 JOptionPane.showMessageDialog(null, "Field Empty! Please Enter Pin");
                 return;
             }
            
             if (accountID == null || accountID.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid Account ID!");
             return;
            }
             
                connection conn = new connection();
                String query = "Update Account SET Pin_No = '"+npin +"' WHERE AccountID = '"+accountID+"'";
                conn.statement.executeUpdate(query);
                
                conn.statement.close();
                conn.conn.close();
                
                JOptionPane.showMessageDialog(null, "Pin Changed Succesfully");
                setVisible(false);
                new Login ().setVisible(true);
                
         }catch(Exception ae){
             ae.printStackTrace();
            }
        
             
        if(e.getSource() == exit){
            setVisible(false);
            new Transactions(transID,accountID).setVisible(true);
            
          }
        }
     }
    
    public static void main(String[] args){
        new PinChange("","").setVisible(true);
    }
}
