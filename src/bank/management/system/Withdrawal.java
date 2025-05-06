package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Withdrawal extends JFrame implements ActionListener{
    JButton withdraw,back;
    String pinnumber;
    JTextField amount;
    
    Withdrawal(String pinnumber){
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
        
        JLabel text = new JLabel("Enter The Amount You Want To Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(170, 350, 400, 20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 16));
        amount.setBounds(170, 390, 300, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(170,452,135,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(370,452,135,30);
        back.addActionListener(this);
        image.add(back);
        
        
    }
    
    public void actionPerformed(ActionEvent e){
            if(e.getSource() == withdraw){
                String DepAmt = amount.getText();
                Date date = new Date();
                
                    if(DepAmt.equals("")){
                        JOptionPane.showMessageDialog(null,"Amount Field Empty! Please Enter the amount");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                        
                    }else{
                            try{
                                  connection conn = new connection();
                                  String query = "INSERT INTO Transaction VALUES ('"+pinnumber+"', '"+date+"', 'Withdraw', '"+DepAmt+",)";
                                  conn.statement.executeUpdate(query);
                                  JOptionPane.showMessageDialog(null, "Rs " +DepAmt+ ".00"+ " Deposited Succesfully");
                            }catch(Exception ae){
                                ae.printStackTrace();
                            }
                        
                    }
                    
            }else if(e.getSource() == back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        
        }
    public static void main(String[] args){
        new Withdrawal("");
    }
}
