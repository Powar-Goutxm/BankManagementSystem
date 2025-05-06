package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField pin;
    JPasswordField repin;
    JButton  change, back;
    String pinnumber;

    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
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
            pin.setFont(new Font ("Raleway" , Font.BOLD,22));
            pin.setBounds(330,360,180,25);
            image.add(pin);

             JLabel repintext = new JLabel ("RE-ENTER NEW PIN");
            repintext.setForeground(Color.WHITE);
            repintext.setFont(new Font ("Sytem",Font.BOLD ,16));
            repintext.setBounds(170,400,180,25);
            image.add(repintext);

            repin = new JPasswordField();
            repin.setFont(new Font ("Raleway" , Font.BOLD,23));
            repin.setBounds(330,400,180,25);
            image.add(repin);
            
            change = new JButton("Change");  
            change.setBounds(170,452,135,30);
            change.addActionListener(this);
            image.add(change);
        
            back = new JButton("Back");
            back.setBounds(370,452,135,30);
            back.addActionListener(this);
            image.add(back);
    }
    
     public void actionPerformed(ActionEvent e){
     
     }
    
    public static void main(String[] args){
        new PinChange("").setVisible(true);
    }
}
