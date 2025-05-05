package bank.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange  extends JFrame implements ActionListener{
    JTextField pin,repin;
    Jbutton  change, back;
    Pinchange(String pinchange){
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage() .getScaledInstance(900 , 900 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel (i3);
         image.setBounds(0 , 0 ,900,900);
         add(image);
          JLabel text = new JLabel ("CHANGE YOUR PIN");
          text.setForeground(Color.WHITE);
          text.setFont(new Font ("Sytem",Font.BOLD ,16));
          text.setBounds(250,280,500,35);
          image.add(text);
          
           JLabel pintext = new JLabel ("NEW PIN");
          pintext.setForeground(Color.WHITE);
          pintext.setFont(new Font ("Sytem",Font.BOLD ,16));
          pintext.setBounds(165,320,180,25);
          image.add(pintext);
          
          pin = new JTextField();
          pin.setFont(new Font ("Raleway" , Font.BOLD,25));
          pin.setBounds(330,320,180,25);
          image.add(pin);
          
           JLabel repintext = new JLabel ("RE-ENTER NEW PIN");
          repintext.setForeground(Color.WHITE);
          repintext.setFont(new Font ("Sytem",Font.BOLD ,16));
          repintext.setBounds(165,360,180,25);
          image.add(repintext);
          
          repin = new JTextField();
          repin.setFont(new Font ("Raleway" , Font.BOLD,25));
          repin.setBounds(330,360,180,25);
          image.add(repin);
          
          change.setBounds(355,485,150,30);
          change.addActionListener(this);
          image.add(change);
          
          back = new JButton ("BACK");
          back.setBounds(355,520,150,30);
          back.addActionListener(this);
          image.add(back);
          
         setSize (900,900);
         setLocation(300,0);
         setVisible(true);
    }
    
    public void actionperformed(ActionEvent ae ){
 try{
     
 }catch (Exception e){
     System.out.println("");
 }
    }
    public static void main (String args[]){
        new Pinchange ("").setVisible(true);
    }
    
}
