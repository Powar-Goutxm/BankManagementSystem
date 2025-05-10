package bank.management.system;
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
        
public class MiniStatement extends JFrame implements ActionListener{
    String transID,accountID;
    JButton exitButton;
    
    MiniStatement(String transID, String accountID) {
        this.transID = transID;
        this.accountID = accountID;
        
        
        setSize(400, 475);
        setLocation(790, 245);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JEditorPane text = new JEditorPane();
        text.setContentType("text/html");
        text.setEditable(false);
        text.setBounds(20, 140, 360, 240);
        
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setBounds(20, 140, 360, 240);
        add(scrollPane);
        
        JLabel bank = new JLabel("HBFC Bank");
        bank.setFont(new Font("Raleway", Font.BOLD, 18));
        bank.setBounds(160, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setFont(new Font("Raleway", Font.BOLD, 16));
        card.setBounds(20, 80, 300, 20);
        add(card);
    
        JLabel balance = new JLabel();
        balance.setFont(new Font("Raleway", Font.BOLD, 14));
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        exitButton = new JButton("Back");
        exitButton.setBackground(Color.blue);
        exitButton.setForeground(Color.white);
        exitButton.setBounds(150, 440, 100, 30);
        exitButton.addActionListener(this);
        add(exitButton);
        
        try {
            connection conn = new connection();
            String query = "SELECT * FROM Account WHERE AccountID = '"+accountID+"'";
            ResultSet rs = conn.statement.executeQuery(query);
            while(rs.next()) {
                card.setText("Card Number: " +"XXXXXXXXXX"+ rs.getString("Card_No").substring(10, 16));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        try {
            connection conn = new connection();
            ResultSet rs = conn.statement.executeQuery("SELECT * FROM Transaction WHERE AccountID = '"+accountID+"'");
            
            //HTML table code
            StringBuilder htmlContent = new StringBuilder();
            htmlContent.append("<html><table style='width:100%; border-collapse:collapse;'>");
            htmlContent.append("<tr style='background-color:#f0f0f0;'>");
            htmlContent.append("<th style='padding:5px; text-align:left; border-bottom:1px solid #ddd;'>Date</th>");
            htmlContent.append("<th style='padding:5px; text-align:left; border-bottom:1px solid #ddd;'>Type</th>");
            htmlContent.append("<th style='padding:5px; text-align:left; border-bottom:1px solid #ddd;'>Amount</th>");
            htmlContent.append("<th style='padding:5px; text-align:left; border-bottom:1px solid #ddd;'>Balance</th>");
            htmlContent.append("</tr>");
            
            boolean hasData = false;
            while(rs.next()) {
                hasData = true;
                htmlContent.append("<tr style='border-bottom:1px solid #eee;'>");
                htmlContent.append("<td style='padding:5px;'>").append(rs.getString("Trans_Date")).append("</td>");
                htmlContent.append("<td style='padding:5px;'>").append(rs.getString("Trans_Type")).append("</td>");
                htmlContent.append("<td style='padding:5px;'>").append(rs.getString("Amount")).append("</td>");
                htmlContent.append("<td style='padding:5px;'>").append(rs.getString("Balance")).append("</td>");
                htmlContent.append("</tr>");
                
                //balance
                balance.setText("Current Balance: Rs " + rs.getString("Balance"));
            }
            
            htmlContent.append("</table></html>");
            
            if (hasData) {
                text.setText(htmlContent.toString());
            } else {
                text.setText("<html><p>No transactions found for this account.</p></html>");
            }
           rs.close();
           conn.statement.close();
           conn.conn.close();
            
        } catch(Exception ae) {
            ae.printStackTrace();
            text.setText("<html><p style='color:red'>Error loading transactions.</p></html>");
        }
    }
    
     public void actionPerformed(ActionEvent ae) {
                
             if(ae.getSource() == exitButton)
                setVisible(false);
            }
     
    public static void main(String[] args) {
        new MiniStatement("","");
    }
}