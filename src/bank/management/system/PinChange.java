package bank.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JTextField pin;
    JPasswordField repin;
    JButton  change, exit;
    String cardnumber,pinnumber;

    
    PinChange(String cardnumber,String pinnumber){
        this.cardnumber = cardnumber;
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
            pin.setFont(new Font ("Raleway" , Font.BOLD, 20));
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
        
            exit = new JButton("Exit");
            exit.setBounds(370,452,135,30);
            exit.addActionListener(this);
            image.add(exit);
    }
    
     public void actionPerformed(ActionEvent e){
        if(e.getSource() ==  change){
             try{
             String npin = pin.getText();
             String rpin = repin.getText();
             
             if(!npin.equals(rpin)){
                 JOptionPane.showMessageDialog(null, "Pins Do Not Match! Please Re-eneter Your Pin");
                 return;
             }
             
             if(npin.equals("") || repin.equals("")){
                 JOptionPane.showMessageDialog(null, "Field Empty! Please Enter Pin");
                 return;
             }
            
                connection conn = new connection();
                String query1 = "Update Transaction SET Pin_No = '"+npin +"' WHERE Card_No = '"+cardnumber+"'";
                String query2 = "Update Login SET Pin_No = '"+npin +"' WHERE Card_No = '"+cardnumber+"'";
                String query3 = "Update SignupThree SET Pin_No = '"+npin +"' WHERE Card_No = '"+cardnumber+"'";
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);
             
                JOptionPane.showMessageDialog(null, "Pin Changed Succesfully");
                
         }catch(Exception ae){
             ae.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login ().setVisible(true);
        }
     }
    
    public static void main(String[] args){
        new PinChange("","").setVisible(true);
    }
}
